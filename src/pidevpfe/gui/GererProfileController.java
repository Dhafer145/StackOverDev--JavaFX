/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pidevpfe.tools.Myconnexion;
/**
 * FXML Controller class
 *
 * @author ramzuss
 */
public class GererProfileController implements Initializable {
Label lab;
  @FXML
    private TextField username;

    @FXML
    private TextField fullname;

    @FXML
    private TextField addresse;
    @FXML
    private Label email;
    @FXML
    private Label logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
  public void seTtext(String username,String fullname,String adresse,String email){
    this.username.setText(username);
        this.fullname.setText(fullname);
    this.addresse.setText(adresse);
      this.email.setText(email);

    }

    @FXML
    void modifier(ActionEvent event) {
Connection connection = Myconnexion.getInstance().getConnection();
        PreparedStatement stmt;

        try {
            stmt = connection.prepareStatement("UPDATE user SET user_name=?, full_name=?, address=? WHERE email=?");
            
            stmt.setString(4, (email.getText()));
            
              
           
            stmt.setString(1, username.getText());
            stmt.setString(2, fullname.getText());
           
              stmt.setString(3, email.getText());
            
 

              int i = stmt.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
        
    
    }

}
