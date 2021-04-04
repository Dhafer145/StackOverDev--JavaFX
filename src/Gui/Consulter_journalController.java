/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.CompteRendu;
import entities.Journal_projet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Consulter_journalController implements Initializable {

    @FXML
    private TableColumn<Journal_projet, Integer> colid;
    @FXML
    private TableView<Journal_projet> tv_stage;
    @FXML
    private TableColumn<Journal_projet, String> coldate;
    @FXML
    private TableColumn<Journal_projet, String> coltache;
    @FXML
    private TableColumn<Journal_projet, String> colavis;
ObservableList<Journal_projet> oblist = FXCollections.observableArrayList();
 Connection cn = Myconn.getInstance().getConnection();
    @FXML
    private Button accueil;
    @FXML
    private TableColumn<Journal_projet, Integer> coletudiant;
    @FXML
    private Button logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTable();
    }    
 public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id_user,id_jp,date,tache,avis from journal_projet ");
            

            while(rs.next()){
                oblist.add(new Journal_projet(rs.getInt("id_user"), rs.getInt("id_jp"),rs.getString("date"),rs.getString("tache"),rs.getString("avis")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_jp"));
        coletudiant.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coltache.setCellValueFactory(new PropertyValueFactory<>("tache"));
        colavis.setCellValueFactory(new PropertyValueFactory<>("avis"));
        
       
        
        tv_stage.setItems(oblist);
    
    }
   
    PreparedStatement pst = null;
     ResultSet rs = null;
     
     
     
    @FXML
     public void Accueil () throws Exception{  
          
    Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where id_user = ?  ";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, LoginController.logged+"");
           
            
          
           
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
              
            String role =rs.getString(7);
               
                
            if(role.equals("Encadrant Académique "))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Accueil_encadrant.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Accueil_encadrantController aea=loader.getController();
        aea.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      accueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
            
            if(role.equals("Encadrant Professionnel"))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Acceuil_pro.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Acceuil_proController aea=loader.getController();
        aea.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      accueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
                 
            } 
          
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }

     
    @FXML
    public void logout() throws IOException{
    
     logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

   
    
}
