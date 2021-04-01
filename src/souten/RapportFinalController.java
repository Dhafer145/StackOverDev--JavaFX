/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package souten;

//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.io.File;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.io.IOException;
//import Entite.RapportFinal;
//import java.sql.SQLException;
//import services.RapportFinal_CRUD;
//import javafx.fxml.Initializable ;
//import javafx.fxml.FXML;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser;
//import javafx.stage.FileChooser.ExtensionFilter;
//import javafx.stage.Stage;
//import javafx.scene.input.KeyEvent;
import Entite.RapportFinal;
import tools.myconnection;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author usp
 */
public class RapportFinalController implements Initializable {
    
     List<String>   lstfile ;

    @FXML
    private Button BtnSingle;
    @FXML
    private TextField tplagiat;
    @FXML
    private TextField tfichier; 
    @FXML
    private TextField txtID;
    @FXML
    private Button Envoyer;
    @FXML
    private Button Bedit;        
    String path;
    @FXML
    private TableColumn<RapportFinal, Integer> colid;
     @FXML
    private TableColumn<RapportFinal, String> colfichier;
      @FXML
    private TableColumn<RapportFinal, String> colplagia;
      ObservableList<RapportFinal> oblist = FXCollections.observableArrayList();
      @FXML
    private TableView<RapportFinal> tv;
    @FXML
    private Label label;
      
      @Override
     
     
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
        
    }
    
    @FXML
      public void ButtonAction(javafx.event.ActionEvent evn) throws SQLException, Exception {
       if(evn.getSource() == Envoyer)
       {ajouterRapportFinal();}
       else if(evn.getSource() == BtnSingle)
               {RapportC(evn);}
      
}
      
        
      
      
      @FXML

   
   public void RapportC (ActionEvent event){
        
        FileChooser fc = new FileChooser();
        List<File> f = fc.showOpenMultipleDialog(null);
      for (File file: f)
          path=file.getAbsolutePath();
    
      if (f!=null){
          for (int j=0; j< f.size();j++ ){
       tfichier.setText(path);
             
          }
      }
    }
 
    
//    @FXML
//    public void AjouterPlagiat (ActionEvent event){
//        String rplagiat = Emptext.getText();
//        RapportFinal rp = new RapportFinal(rplagiat);
//        RapportFinal_CRUD crp = new  RapportFinal_CRUD();
//        crp.ajouterPlagiat(rp) ;
//     
 //   }
   
    public void ajouterRapportFinal( ) throws Exception{
        
        Connection cnx = myconnection.getInstance().getConnection();
           PreparedStatement stm;    
        try {
     stm = cnx.prepareStatement("INSERT INTO rapport_final (plagiat,fichier) values (?,?)");
           
            stm.setString(1 , tplagiat.getText());
            stm.setString(2, tfichier.getText());
            
            int i=stm.executeUpdate();
            System.out.println(i);
            
        } catch (Exception ex) {
           ex.printStackTrace();
            
        }
        String title = "succes ";
        String message = "rapport et plagiat ajoutés en succé";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        email.sendMail("selim.saidi@esprit.tn");
    
    }   



public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = myconnection.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id_rf,plagiat,fichier from rapport_final");
            
            while(rs.next()){
                oblist.add(new RapportFinal(rs.getInt("id_rf"),rs.getString("plagiat"),rs.getString("fichier")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(RapportFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_rf"));
        colplagia.setCellValueFactory(new PropertyValueFactory<>("plagiat"));
        colfichier.setCellValueFactory(new PropertyValueFactory<>("fichier"));
    
        
       
        
        tv.setItems(oblist);
    
    }
public void ModifierRa(ActionEvent Event) {
    Connection  cn=myconnection.getInstance().getConnection();
    PreparedStatement st;
try {
    
  st=cn.prepareStatement("UPDATE rapport_final SET plagiat=?, fichier=? where id_rf=?");
 
           
             st.setString(1, tplagiat.getText());
             st.setString(2, tfichier.getText());
             st.setString(3,( txtID.getText()));
             
             int i= st.executeUpdate();
            System.out.println(i);
            
        } catch (Exception ex) {
           ex.printStackTrace();
            
        }    
     loadTable();
}
@FXML
    private void modifier(MouseEvent event) {
        
       RapportFinal r= tv.getSelectionModel().getSelectedItem();
       
       txtID.setText(String.valueOf(r.getId_RF()));
       
       tplagiat.setText(r.getFichier());
       
       tfichier .setText(r.getPlagiat());
       
       
       
     
    }

}
