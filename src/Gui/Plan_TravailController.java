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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tools.Myconn;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Plan_TravailController implements Initializable {

    @FXML
    private AnchorPane ano;
    @FXML
    private Button btnsprint;
    @FXML
    private Button btnbacklog;
    @FXML
    private TextField text_backlog;
    @FXML
    private TextField text_sprint;
    String path;
    @FXML
    private Button btnSend;
    @FXML
    private Button btncompte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML
    void FileChooser1(){
      
        FileChooser fc = new FileChooser();
        List<File> f = fc.showOpenMultipleDialog(null);
      for (File file: f)
          path=file.getAbsolutePath();
      
      if (f!=null){
          for (int j=0; j< f.size();j++ ){
       text_backlog.setText(path);
             
          }
      }

  
    }
    
    @FXML
    void FileChooser2(){
      
        FileChooser fc = new FileChooser();
        List<File> f = fc.showOpenMultipleDialog(null);
      for (File file: f)
          path=file.getAbsolutePath();
      
      if (f!=null){
          for (int j=0; j< f.size();j++ ){
       text_sprint.setText(path);
             
          }
      }

  
    }
    @FXML
      public void ajout() throws SQLException{

       
Connection connection =Myconn.getInstance().getConnection();
        PreparedStatement stm;
      try{
     
      
stm = connection.prepareStatement("insert into plan_travail(backlog,sprints) values(?,?)");

stm.setString(2, text_backlog.getText());
stm.setString(1, text_sprint.getText());




int i = stm.executeUpdate();
            System.out.println(i);
             }
    

    
catch (Exception e){
            e.printStackTrace();
        }
      
String title = "succes ";
        String message = "plan de travail ajouté avec succes";

TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
}
    @FXML
        public void Compte() throws IOException {
    
     btncompte.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("CompteRendu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    
}
