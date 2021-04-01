/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.gui;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidevpfe.tools.Myconnexion;

/**
 * FXML Controller class
 *
 * @author ramzuss
 */
public class ChangePasswordController implements Initializable {

   @FXML
    public PasswordField pfactuel;

    @FXML
    public PasswordField pfnouveau;

    @FXML
    public PasswordField pfconfirme;

    public LoginController lg;
    @FXML
    private Label laccueil;
    @FXML
    private Label lgereruser;
    @FXML
    private Label lgererprofile;
    @FXML
    private Label laffecter;
    @FXML
    private Label changepassword;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }   
    
     @FXML
     public void gererUser() throws IOException{
    
     lgereruser.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("GererUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
   @FXML
     public void affecterEncadrant() throws IOException{
    
     laffecter.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AffecterEncadrant.fxml"));
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
    
    
    
    
    
    
     
    
    public String cryptage(String password){
        String crypte="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            crypte=crypte+(char)c;
        }
        return crypte;
    }
     public static String decryptage(String password){
        String aCrypter="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48; 
            aCrypter=aCrypter+(char)c;
        }
        return aCrypter;
    }
    
    
    @FXML
    public void changePassword(){
    Connection connection = Myconnexion.getInstance().getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("UPDATE user SET password=?, confirm_password=? WHERE password=?");
           
            if  (pfnouveau.getText().length()<8) {

            JOptionPane.showMessageDialog(null, "verifier votre nouveau mot de passe");
             }
            else if  (!(pfnouveau.getText().equalsIgnoreCase(pfconfirme.getText()))) {

            JOptionPane.showMessageDialog(null, "verifier la confirmation du password");
             }
              
            else{
            stmt.setString(3, cryptage(pfactuel.getText()));
            
              
           
            stmt.setString(1, cryptage(pfnouveau.getText()));
            stmt.setString(2, cryptage(pfconfirme.getText()));
           
              int i = stmt.executeUpdate();

            System.out.println(i);
            JOptionPane.showMessageDialog(null, "votre mot de passe à été changé avec succès");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
         
    }

    

    
 

}
