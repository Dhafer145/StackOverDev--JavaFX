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
public class Accueil_encadrantController implements Initializable {

    @FXML
    private Button btnpp;
    @FXML
    private Button btnconscr;
    @FXML
    private Button btnconspt;
    @FXML
    private Button visualiser;
    @FXML
    private Button changepassword;
    @FXML
    private Button lgererprofile;
    @FXML
    private Button btnplagiat;
    @FXML
    private Label lemail;
    @FXML
    private Label lnom;
    @FXML
    private Button btnjs;
    @FXML
    private Button btnGrille;
    @FXML
    private Button logout;
    @FXML
    private Button btnrdv;

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
    private void conspp(ActionEvent event) throws IOException {
       
        btnpp.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Validation_proposition.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void conscr(ActionEvent event) throws IOException {
        
        btnconscr.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Consulter_cr.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void conspt(ActionEvent event) throws IOException {
        btnconspt.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Tableau_plan.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

   @FXML
    public void visualiserEtudiants(MouseEvent event) throws IOException {
    PreparedStatement pst = null;
     ResultSet rs = null;
       Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where email=?";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, lemail.getText());
            
            
            
            rs = pst.executeQuery();
            
            if(rs.next()){ 
   
             
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("VisualiserEtudiants.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        
        VisualiserEtudiantsController ve=loader.getController();
       // ve.seTtext(lemail.getText());
        ve.seTtext(lemail.getText());
       // ve.getuserList(lemail.getText());
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
     visualiser.getScene().getWindow().hide();  //pour fermer interface login

            } 
          
                } 
    catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }
    @FXML
    private void changepassword(ActionEvent event) throws IOException {
        changepassword.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    @FXML
     public void gererProfile() throws Exception{
         PreparedStatement pst = null;
     ResultSet rs = null;
      Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where email=?";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, lemail.getText());
            
            
            
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

    @FXML
    private void consjs(ActionEvent event) throws IOException {
         btnjs.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Consulter_journal.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
     public void GetGrille() throws IOException{
    
     btnGrille.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AfficherGrille.fxml"));
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
    public void rapportpl(MouseEvent event) throws IOException {
        
        btnplagiat.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("RapporUpload.fxml"));
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
    private void AjoutRdv(ActionEvent event) throws IOException {
     btnjs.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AfficherRv.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    
    }
    
    
}
