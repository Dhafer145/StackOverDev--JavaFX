/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;



//import Tools.Pdff;
import static Tools.Print.printNode;
import com.itextpdf.text.DocumentException;
import entities.Journal_projet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tools.Myconn;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class JournalStageController implements Initializable {

   @FXML
    private TextField text_tache;
   
    @FXML
    private TextField text_avis;

    @FXML
    private DatePicker date_tache ;
    
 
    @FXML
    private Button btnEnvoyer;
    
    @FXML
    private TableColumn<Journal_projet, Integer> colid;
    @FXML
    private TableColumn<Journal_projet, String> coldate;
    @FXML
    private TableColumn<Journal_projet, String> coltache;
    @FXML
    private TableColumn<Journal_projet, String> colavis;
    
    ObservableList<Journal_projet> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<Journal_projet> tv_stage;
    @FXML
    private Button print;
    @FXML
    private AnchorPane AnO;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField text_id;
    @FXML
    private Button btnespace;
    
    
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
                loadTable();

    }    
    
    @FXML
    public void Send() {
Connection connection =Myconn.getInstance().getConnection();
        PreparedStatement stm;
      try{
         
           if  (((TextField)date_tache.getEditor()).getText().length()==0 )  {

            JOptionPane.showMessageDialog(null, "Vous devez écrire une date");
             }
           else  if  ((text_tache.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "Vous devez écrire une tâche");
             }
          else {     
stm = connection.prepareStatement("insert into journal_projet(date,tache,avis) values(?,?,?)");

stm.setString(1, ((TextField)date_tache.getEditor()).getText());
stm.setString(2, text_tache.getText());
stm.setString(3, text_avis.getText());
date_tache.setValue(null);

int i = stm.executeUpdate();
            System.out.println(i);
             }
    

    }
catch (Exception e){
            e.printStackTrace();
        }
String title = "succes ";
        String message = "journal ajouté avec succes";

TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        
        loadTable();
       
}
    
    
    
//    private void pdf(ActionEvent event) throws DocumentException { 
//        
//        try {
//             Pdff pdf = new Pdff();
//            pdf.stagePdf();
//             JOptionPane.showMessageDialog(null, "done!", "", JOptionPane.INFORMATION_MESSAGE);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (DocumentException ex) {
//            Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      
//    }
    
    
    
    
    public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select  id_jp,date,tache,avis from journal_projet ");
            

            while(rs.next()){
                oblist.add(new Journal_projet(rs.getInt("id_jp"),rs.getString("date"),rs.getString("tache"),rs.getString("avis")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_jp"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coltache.setCellValueFactory(new PropertyValueFactory<>("tache"));
        colavis.setCellValueFactory(new PropertyValueFactory<>("avis"));
        
       
        
        tv_stage.setItems(oblist);
    
    }

    @FXML
    private void print(ActionEvent event) {
       try {
           printNode(tv_stage);
       } catch (NoSuchMethodException ex) {
           Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InvocationTargetException ex) {
           Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
//MODIFICATION
    
//    @FXML
//    private void Modif(ActionEvent event) {
//        String req ="UPDATE journal_projet SET tache= ? , avis= ? WHERE tache="  ;
////         String req ="UPDATE journal_projet SET tache='" + coltache.getText()+"',avis="+colavis.getText()+ "where tache= " + coltache.getText(); 
//   
//  Connection cn = Myconn.getInstance().getConnection();
//  PreparedStatement stm;
//try {
//        stm=cn.prepareStatement(req);
//           
////            stm.setString(1, ((TextField)date_tache.getEditor()).getText());
//             stm.setString(1, text_tache.getText());
//              stm.setString(2, text_avis.getText());
//             
//             stm.executeUpdate();
//            System.out.println("journal modifié");
//            
//        } catch (SQLException ex) {
//            System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//            
//        }
//    }
    @FXML
    public  void Modif(ActionEvent event){
    Connection cn = Myconn.getInstance().getConnection();
        PreparedStatement stm;

        try {
            stm = cn.prepareStatement("UPDATE journal_projet SET tache=?, avis=?  WHERE id_jp=?");
            
         stm.setString(3, (text_id.getText()));
            
              
           
            stm.setString(1, text_tache.getText());
            stm.setString(2, text_avis.getText());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
        loadTable();
}
    
    @FXML
    private void modifier(MouseEvent event) {
        
       Journal_projet jp= tv_stage.getSelectionModel().getSelectedItem();
       text_id.setText(String.valueOf(jp.getId_jp()));
       text_tache.setText(jp.getTache());
       text_avis.setText(jp.getAvis());
       
       
       
     
       
      
    }

    @FXML
    private void espace(ActionEvent event) throws IOException {
         btnespace.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("accueil_etudiant.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    
    
}
