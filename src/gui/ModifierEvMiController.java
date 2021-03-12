/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import entities.EvaluationMi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.EvaluationMiCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class ModifierEvMiController implements Initializable {

    @FXML
    private RadioButton ponctualiteoui;
    @FXML
    private ToggleGroup ponctualite1;
    @FXML
    private RadioButton ponctualitenon;
    @FXML
    private TextField commentaire1;
    @FXML
    private RadioButton integrationoui;
    @FXML
    private ToggleGroup integration3;
    @FXML
    private RadioButton integrationnon;
    @FXML
    private TextField commentaire2;
    @FXML
    private RadioButton travailoui;
    @FXML
    private ToggleGroup travail3;
    @FXML
    private RadioButton travailnon;
    @FXML
    private TextField commentaire3;
    @FXML
    private RadioButton competenceoui;
    @FXML
    private ToggleGroup competence1;
    @FXML
    private RadioButton competencenon;
    @FXML
    private TextField commentaire4;
    @FXML
    private RadioButton egoui;
    @FXML
    private ToggleGroup evaluation_globale;
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
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadData();
            
//      
        } catch (SQLException ex) {
            Logger.getLogger(ModifierEvMiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        

    @FXML
    private void modifEv(ActionEvent event) {
        
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
            
            emc.modifierEvaluationMi(evaluation, EvaluationMi.chosen);
            
            String title = "succes ";
        String message = "Evaluation modifiée avec succes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        
    }
    
    @FXML
    private void loadData() throws SQLException {
        
        EvaluationMiCRUD emc = new EvaluationMiCRUD();
        EvaluationMi ev = new EvaluationMi();
        ev=emc.consulterEvaluationMi();
        
         if(ev.isPonctualite())
            ponctualiteoui.setSelected(true);
        else
            ponctualitenon.setSelected(true);

        commentaire1.setText(ev.getComm1());
        
        if(ev.isIntegration())
            integrationoui.setSelected(true);
        else
            integrationnon.setSelected(true);
            
        commentaire2.setText(ev.getComm2());
        
        if(ev.isTravail())
            travailoui.setSelected(true);
        else
            travailnon.setSelected(true);
        
        commentaire3.setText(ev.getComm3());
        
        if(ev.isCompetence())
            competenceoui.setSelected(true);
        else
            competencenon.setSelected(true);
        
        commentaire4.setText(ev.getComm4());
        
        if(ev.isEg())
            egoui.setSelected(true);
        else
            egnon.setSelected(true);
        
        commentaire5.setText(ev.getComm5());
        
        
    }
        
        
        
    
}
