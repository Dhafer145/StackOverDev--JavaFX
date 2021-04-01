package Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tools.Myconn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CompteRenduController implements Initializable {

    /**
     * Initializes the controller class.
     */
  
    @FXML
    private TextField tfcomm;

    @FXML
    private Button btnajout;
 
    @FXML
    private Button btnupload;
    
    @FXML
    private TextField listview;
    String path;
    @FXML
    private Button btnjs;
    @FXML
    private Button btnespace;
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void ButtonAction(ActionEvent evn) throws SQLException {
       if(evn.getSource() == btnajout)
       {ajout();}
       else if(evn.getSource() == btnupload)
               {FileChooser();}
    
}
    
    void FileChooser(){
      
        FileChooser fc = new FileChooser();
        List<File> f = fc.showOpenMultipleDialog(null);
      for (File file: f)
          path=file.getAbsolutePath();
      
      if (f!=null){
          for (int j=0; j< f.size();j++ ){
       listview.setText(path);
             
          }
      }

  
    }
    public void ajout() throws SQLException{

       
Connection connection =Myconn.getInstance().getConnection();
        PreparedStatement stm;
      try{
     
      
stm = connection.prepareStatement("insert into compte_rendu(fichier,commentaire) values(?,?)");

stm.setString(2, tfcomm.getText());
stm.setString(1, listview.getText());




int i = stm.executeUpdate();
            System.out.println(i);
             }
    

    
catch (Exception e){
            e.printStackTrace();
        }
      
String title = "succes ";
        String message = "compte rendu ajouté avec succes";

TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
}

    @FXML
         public void journal() throws IOException {
    
     btnjs.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Journal_Stage.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
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