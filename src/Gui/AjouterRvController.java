/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import tools.Myconn;
import entities.rendez_vous;
import java.sql.Connection;
import java.net.URL;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import services.rvCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author dhiabenmabrouk
 */
public class AjouterRvController implements Initializable {

    @FXML
    private TextField ajouterID;
    @FXML
    private TextField ajouterLieu;
    @FXML
    private TextField ajouterLogin;
    @FXML
    private TextField ajouterRaison;
    @FXML
    private DatePicker ajouterDate;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    

    private final Connection cnx;
    private PreparedStatement ste;
    public AjouterRvController() {
        Myconn bd=Myconn.getInstance();
        cnx=bd.getConnection();
           }
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    

    @FXML
    private void Valider(ActionEvent event) throws Exception {
        
try{
        String x = ajouterDate.getValue().toString();
        rendez_vous rv = new rendez_vous(ajouterLogin.getText(),ajouterLieu.getText(),x,ajouterRaison.getText());
        rvCRUD crd = new rvCRUD();
        crd.AjouterRv(rv);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AJOUT AVEC SUCCES");
        alert.setHeaderText(null);
        alert.setContentText("Rendez_vous "+rv.getId_rv()+" "+rv.getLogin()+" ajouté avec succès");
        alert.showAndWait();
        
        }

        catch(RuntimeException ex)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR," Les informations sont Invalides ou incompletes Veuillez les verifiers ",ButtonType.CLOSE);
            alert.showAndWait();
        }
       String title = "succes ";
        String message = "Rendez_vous ajouté avec succes";
        Stage stage = (Stage) annuler.getScene().getWindow();
        stage.close();

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
    }
    @FXML
    private void Annuler(MouseEvent event) {
        Stage stage = (Stage) annuler.getScene().getWindow();
        stage.close();
        
    }
    
}
