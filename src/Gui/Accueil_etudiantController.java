/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Accueil_etudiantController implements Initializable {

    @FXML
    private Button btncr;
    @FXML
    private Button btnprop;
    @FXML
    private Button btnjs;
    @FXML
    private Button btnplan;
    @FXML
    private Label lemail;
    @FXML
    private Label lnom;
    @FXML
    private Button changepassword;
    @FXML
    private Button ButtonConsultBilan;
    @FXML
    private Button logout;
    @FXML
    private Button lgererprofile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void seTtext(String fullname,String email){
    this.lnom.setText(fullname);
    this.lemail.setText(email);
    }
    @FXML
    private void ajoutCr(ActionEvent event) throws IOException {
        btncr.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("CompteRendu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void proposer(ActionEvent event) throws IOException {
        btnprop.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("ProposerProjet.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void journal(ActionEvent event) throws IOException {
        btnjs.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Journal_Stage.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void plandetravail(ActionEvent event) throws IOException {
        btnplan.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Plan_Travail.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

   @FXML
    public void changepassword() throws IOException{
    
     changepassword.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void consultBilan(MouseEvent event) throws IOException {
     ButtonConsultBilan.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("BilansPeriodiques.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    
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
    
    @FXML
    public void gererProfile(MouseEvent event) {
        
        PreparedStatement pst = null;
     ResultSet rs = null;
      Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where id_user=?";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, LoginController.logged+"");
            
            
            
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
               
           
                     
                    
             String username=rs.getString(2);
             String fullname=rs.getString(3);
             String adresse=rs.getString(8);
             
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("GererProfile.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        
        GererProfileController gp=loader.getController();
        gp.seTtext(username,fullname,adresse,lemail.getText());
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
     lgererprofile.getScene().getWindow().hide();  //pour fermer interface login

       
  
                
               
            
                
            
            } 
          
                } 
    catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }

    
}
