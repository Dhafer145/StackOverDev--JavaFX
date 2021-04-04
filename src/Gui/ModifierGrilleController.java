/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.EvaluationMi;
import entities.GrilleEvaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import services.EvaluationMiCRUD;
import services.GrilleEvaluationCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class ModifierGrilleController implements Initializable {

    @FXML
    private ComboBox c1;
    @FXML
    private ComboBox c2;
    @FXML
    private ComboBox c3;
    @FXML
    private ComboBox c4;
    @FXML
    private ComboBox c5;
    @FXML
    private ComboBox c6;
    @FXML
    private ComboBox c7;
    @FXML
    private ComboBox c8;
    @FXML
    private Button btnConfirmer;
    @FXML
    private Button btnAnnuler;
    @FXML
    private TextField noteF;
    @FXML
    private TextField mentionF;
    @FXML
    private Button btnTotal;
    
//    private String question1;
//    private String question2;
//    private String question3;
//    private String question4;
//    private String question5;
//    private String question6;
//    private String question7;
//    private String question8;

    private String mention;
    private int note;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> opt = FXCollections.observableArrayList(
        "A",
        "B",
        "C",
        "D");
        
        c1.setItems(opt);
        c2.setItems(opt);
        c3.setItems(opt);
        c4.setItems(opt);
        c5.setItems(opt);
        c6.setItems(opt);
        c7.setItems(opt);
        c8.setItems(opt);
        
        try {
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierGrilleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


//    
    
    
    
    
    private void calculNote(){
    
        note=0;
        switch (c1.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c2.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c3.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c4.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c5.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c6.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c7.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
        
        switch (c8.getSelectionModel().getSelectedItem().toString()) {
            case "A":
                note+=5;
                break;
            case "B":
                note+=4;
                break;
            case "C":
                note+=2;
                break;
            case "D":
                note+=1;
                break;
        }
    
    }
    
    private void choixMention(){
    
        if(note<=11){mention="D";}else if(note<=27){mention="C";}else if(note<=35){mention="B";}else{mention="A";}
        
    }
    
    
    
    @FXML
    private void affTotal(ActionEvent event) throws IOException {
    
        calculNote();  
        choixMention();
        Integer y = note;
        String s = y.toString();
        noteF.setText(s);
        mentionF.setText(mention);

    }
    

   

    
    
    
    
    
    private void loadData() throws SQLException {
        
        GrilleEvaluationCRUD gec = new GrilleEvaluationCRUD();
        GrilleEvaluation ge = new GrilleEvaluation();
        ge=gec.consulterGrilleEvaluation();
        
        
        c1.setValue(ge.getQ1());
        c2.setValue(ge.getQ2());
        c3.setValue(ge.getQ3());
        c4.setValue(ge.getQ4());
        c5.setValue(ge.getQ5());
        c6.setValue(ge.getQ6());
        c7.setValue(ge.getQ7());
        c8.setValue(ge.getQ8());
        Integer n = ge.getNote();
        noteF.setText(n.toString());
        mentionF.setText(ge.getMention());
        
    }
    
    
    
    @FXML
    private void modifEv(ActionEvent event) {
        
        
        
        GrilleEvaluation grille = new GrilleEvaluation(mention,note,c1.getSelectionModel().getSelectedItem().toString(),
                c2.getSelectionModel().getSelectedItem().toString(),c3.getSelectionModel().getSelectedItem().toString(),
                c4.getSelectionModel().getSelectedItem().toString(),c5.getSelectionModel().getSelectedItem().toString(),
                c6.getSelectionModel().getSelectedItem().toString(),c7.getSelectionModel().getSelectedItem().toString(),
                c8.getSelectionModel().getSelectedItem().toString());
            
            GrilleEvaluationCRUD gec = new GrilleEvaluationCRUD();
            
            gec.modifierGrilleEvaluatin(grille, EvaluationMi.chosen);
            
            String title = "succes ";
        String message = "Grille modifiée avec succes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
        
    }
    
    
    
    
    
}
