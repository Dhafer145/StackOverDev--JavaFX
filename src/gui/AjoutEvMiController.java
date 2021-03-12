/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.EvaluationMi;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.EvaluationMiCRUD;
import test.NewFXMain;
import tools.SendMail;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AjoutEvMiController implements Initializable {

    @FXML
    private RadioButton ponctualiteoui;
    @FXML
    private RadioButton ponctualitenon;
    @FXML
    private TextField commentaire1;
    
    @FXML
    private RadioButton integrationoui;
    @FXML
    private RadioButton integrationnon;
    @FXML
    private TextField commentaire2;
    
    @FXML
    private RadioButton travailoui;
    @FXML
    private RadioButton travailnon;
    @FXML
    private TextField commentaire3;
    
    @FXML
    private RadioButton competenceoui;
    @FXML
    private RadioButton competencenon;
    @FXML
    private TextField commentaire4;
    
    @FXML
    private RadioButton egoui;
    @FXML
    private RadioButton egnon;
    
    @FXML
    private TextArea commentaire5;
    
    @FXML
    private Button btnConfirmer;
    @FXML
    private Button btnCancel;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void ajoutEv(ActionEvent event) throws IOException {
        
            // Ajouter ev
            Boolean ponctualite = ponctualiteoui.isSelected();
            String comm1 = commentaire1.getText();
            Boolean integration = integrationoui.isSelected();
            String comm2 = commentaire2.getText();
            Boolean travail = travailoui.isSelected();
            String comm3 = commentaire3.getText();
            Boolean competence = competenceoui.isSelected();
            String comm4 = commentaire4.getText();
            Boolean evaluation_global = egoui.isSelected();
            String comm5 = commentaire5.getText();
            
            EvaluationMi evaluation = new EvaluationMi(ponctualite,comm1,integration,comm2,travail,comm3,competence,
            comm4,evaluation_global,comm5);
            
            EvaluationMiCRUD emc = new EvaluationMiCRUD();
            
            emc.ajouterEvaluationMi(evaluation);
            
            //Ajout effectué
            
            String title = "succes ";
        String message = "Evaluation ajoutée avec succes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
//             try {
            // send mail
//            SendMail.sendMail("jihenelabidi1998@gmail.com");
//        } catch (Exception ex) {
//            Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
            System.out.println("Ajout effectué");
        
    }
    
}
