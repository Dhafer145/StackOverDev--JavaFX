/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.EvaluationMi;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.EvaluationMiCRUD;
import test.NewFXMain;
import tools.MyConnection;
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
    private ComboBox combo;

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
    
    private String etudiant;
    
    private int id_etudiant=117;
    
    private final int id_encadrant=92;
   
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ObservableList<String> options = FXCollections.observableArrayList();
            Connection cnx = MyConnection.getInstance().getConnection();
            ResultSet rs = cnx.createStatement().executeQuery("select full_name from user where id_user in (select id_etudiant from affectation where id_encadrant_entreprise=92)");
            while(rs.next()){
                options.add(rs.getString("full_name"));
            
            }
//            ObservableList<String> options = FXCollections.observableArrayList("Option 1","Option 2","Option 3");
            combo.setItems(options);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
    @FXML
    private void selectEtudiant(ActionEvent event) throws IOException{
        
        String s = combo.getSelectionModel().getSelectedItem().toString();
        System.out.println("la chaine"+s);
            
        etudiant=s;
         System.out.println("la chaine"+etudiant);
//        try {
//            
//            Connection cnx = MyConnection.getInstance().getConnection();
//            ResultSet rs = cnx.createStatement().executeQuery("select id_user from user where full_name="+etudiant+"");
//            
//            while(rs.next()){
//                id_etudiant=rs.getInt("id_user");
//            
//            }
//            
//             System.out.println("l'id etudiant"+id_etudiant);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
    
    }
    
    @FXML
    private void ajoutEv(ActionEvent event) throws IOException {
        
            // Ajouter ev
            
            
            try {
            
            String e= "\""+etudiant+"\"";
            Connection cnx1 = MyConnection.getInstance().getConnection();
            ResultSet rs = cnx1.createStatement().executeQuery("select * from user where full_name = "+e+"");
           
            
            while(rs.next()){
                id_etudiant=rs.getInt("id_user");
            
            }
            
             System.out.println("l'id etudiant"+id_etudiant);
            
        } catch (SQLException ex) {
            Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
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
            
            EvaluationMi evaluation = new EvaluationMi(id_encadrant,id_etudiant,ponctualite,comm1,integration,comm2,travail,comm3,competence,
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
        
        
//            try {
//            
//           SendMail.sendMail("jihenelabidi1998@gmail.com");
//       } catch (Exception ex) {
//           Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
//       }
        
            System.out.println("Ajout effectué");
        
    }
    
    
    
}
