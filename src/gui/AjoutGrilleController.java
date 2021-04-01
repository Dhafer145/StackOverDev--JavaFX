/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.GrilleEvaluation;
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
import javafx.scene.control.TextField;
import services.EvaluationMiCRUD;
import services.GrilleEvaluationCRUD;
import tools.MyConnection;
import tools.SendMail;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AjoutGrilleController implements Initializable {

    
    
     @FXML
    private Button btnTotal;
      @FXML
    private TextField noteF;
       @FXML
    private TextField mentionF;
    
    @FXML
    private ComboBox combo;
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
    
    private String etudiant;
    
    private int id_etudiant=117;
    
    private final int id_encadrant=90;
    
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String question6;
    private String question7;
    private String question8;

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
            ObservableList<String> options = FXCollections.observableArrayList();
            Connection cnx = MyConnection.getInstance().getConnection();
            ResultSet rs = cnx.createStatement().executeQuery("select full_name from user where id_user in (select id_etudiant from affectation where id_encadrant_academique=90)");
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
            
    }
    
    
    @FXML
    private void selectQ1(ActionEvent event) throws IOException{
        String q1 = c1.getSelectionModel().getSelectedItem().toString();
        question1=q1;         
    }
    
    @FXML
    private void selectQ2(ActionEvent event) throws IOException{        
        String q2 = c2.getSelectionModel().getSelectedItem().toString();
        question2=q2;       
    }
    
    @FXML
    private void selectQ3(ActionEvent event) throws IOException{      
        String q3 = c3.getSelectionModel().getSelectedItem().toString();
        question3=q3;      
    }
    
    @FXML
    private void selectQ4(ActionEvent event) throws IOException{    
        String q4 = c4.getSelectionModel().getSelectedItem().toString();
        question4=q4;       
    }
    
    @FXML
    private void selectQ5(ActionEvent event) throws IOException{       
        String q5 = c5.getSelectionModel().getSelectedItem().toString();
        question5=q5;        
    }
    
    @FXML
    private void selectQ6(ActionEvent event) throws IOException{     
        String q6 = c6.getSelectionModel().getSelectedItem().toString();
        question6=q6;       
    }
    
    @FXML
    private void selectQ7(ActionEvent event) throws IOException{      
        String q7 = c7.getSelectionModel().getSelectedItem().toString();
        question7=q7;      
    }
    
    @FXML
    private void selectQ8(ActionEvent event) throws IOException{       
        String q8 = c8.getSelectionModel().getSelectedItem().toString();
        question8=q8;        
    }
    
    
    
    
    
    private void calculNote(){
    
        note=0;
        switch (question1) {
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
        
        switch (question2) {
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
        
        switch (question3) {
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
        
        switch (question4) {
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
        
        switch (question5) {
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
        
        switch (question6) {
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
        
        switch (question7) {
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
        
        switch (question8) {
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
    
    
    
    
    
    @FXML
    private void ajoutGrille(ActionEvent event) throws IOException {
        
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
            
            calculNote();  
            choixMention();
            
            GrilleEvaluation ge = new GrilleEvaluation(id_encadrant,id_etudiant,mention,note,
                    question1,question2,question3,question4,question5,question6,question7,question8);
    
            
            
            
            
            GrilleEvaluationCRUD gec = new GrilleEvaluationCRUD();
            
            gec.ajouterGrilleEvaluation(ge);
            
            //Ajout effectué
            
            String title = "succes ";
        String message = "Grille ajoutée avec succes";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
//             try {
////            send mail;
//            SendMail.sendMail("jihenelabidi1998@gmail.com");
//        } catch (Exception ex) {
//            Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
try {
            
           SendMail.sendMail("jihenelabidi1998@gmail.com");
       } catch (Exception ex) {
           Logger.getLogger(AjoutEvMiController.class.getName()).log(Level.SEVERE, null, ex);
       }
            System.out.println("Ajout effectué");
    
            
    }
    
    
}
