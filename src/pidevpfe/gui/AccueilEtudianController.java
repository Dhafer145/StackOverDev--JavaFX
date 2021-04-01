/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pidevpfe.tools.Myconnexion;

/**
 * FXML Controller class
 *
 * @author ramzuss
 */
public class AccueilEtudianController implements Initializable {

    @FXML
    private Label laccueil;
    @FXML
    private Label lgererprofile;
    @FXML
    private Label changepassword;
    @FXML
    private Label lemail;
    @FXML
    private Label lnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    PreparedStatement pst = null;
     ResultSet rs = null;
    
     @FXML
     public void gererProfile() throws Exception{
         
      Connection cnx = Myconnexion.getInstance().getConnection();
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
    public void changepassword() throws IOException{
    
     changepassword.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

}