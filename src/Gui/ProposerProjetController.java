/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.SendEmail;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProposerProjetController implements Initializable {

    @FXML
    private TextField tfdescription;
    @FXML
    private Button btnajout;
    @FXML
    private Button btnCahier;
    @FXML
    private TextField tfsujet;
    String path;
    @FXML
    private TextField tfcahier;
    @FXML
    private Button btnplan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    void FileChooser(){
      
        FileChooser fc = new FileChooser();
        List<File> f = fc.showOpenMultipleDialog(null);
      for (File file: f)
          path=file.getAbsolutePath();
      
      if (f!=null){
          for (int j=0; j< f.size();j++ ){
       tfcahier.setText(path);
             
          }
      }

  
    }

    @FXML
    private void ajout(ActionEvent event) throws Exception {
        
         

       
Connection connection =Myconn.getInstance().getConnection();
        PreparedStatement stm;
      
        
        try{
     if  ((!(tfsujet.getText().matches("^[a-zA-Z]+$")))||(tfsujet.getText().length()==0)) {

            JOptionPane.showMessageDialog(null, "veuillez soumettre  votre sujet");
             }
    else if  (tfcahier.getText().length()==0) {

            JOptionPane.showMessageDialog(null, "veuillez déposer un fichier");
             }
      
      else if  (tfdescription.getText().length()==0) {

            JOptionPane.showMessageDialog(null, "veuillez décrire votre projet");
             }
     
     else {  
stm = connection.prepareStatement("insert into proposition_projet(nom_sujet,cahier_charge,description) values(?,?,?)");

stm.setString(1, tfsujet.getText());
stm.setString(2, tfcahier.getText());
stm.setString(3, tfdescription.getText());


String title = "succes ";
        String message = "proposition ajoutée avec succes";

TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();

int i = stm.executeUpdate();
            System.out.println(i);
             }
    
        }
   
catch (Exception e){
            e.printStackTrace();
        }
         SendEmail.sendMail("dhaferharbaoui@gmail.com");
      
      

}
    
     public void planTravail() throws IOException {
    
     btnplan.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("plan_Travail.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    
    }

  
    

