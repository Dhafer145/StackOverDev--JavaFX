/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.EvaluationMi;
import java.io.IOException;
import services.EvaluationMiCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AjoutEvMiController implements Initializable {

    
    @FXML
    private RadioButton ponctualite1oui;
    @FXML
    private RadioButton ponctualite1non;
    @FXML
    private RadioButton ponctualite2oui;
    @FXML
    private RadioButton ponctualite2non;
    @FXML
    private TextField commentaire1;
    
    
    @FXML
    private RadioButton integration1oui;
    @FXML
    private RadioButton integration1non;
    @FXML
    private RadioButton integration2oui;
    @FXML
    private RadioButton integration2non;
    @FXML
    private RadioButton integration3oui;
    @FXML
    private RadioButton integration3non;
    @FXML
    private TextField commentaire2;
    
    
    @FXML
    private RadioButton travail1oui;
    @FXML
    private RadioButton travail1non;
    @FXML
    private RadioButton travail2oui;
    @FXML
    private RadioButton travail2non;
    @FXML
    private RadioButton travail3oui;
    @FXML
    private RadioButton travail3non;
    @FXML
    private RadioButton travail4oui;
    @FXML
    private RadioButton travail4non;
    @FXML
    private TextField commentaire3;
    
    @FXML
    private RadioButton competence1oui;
    @FXML
    private RadioButton competence1non;
    @FXML
    private RadioButton competence2oui;
    @FXML
    private RadioButton competence2non;
    @FXML
    private RadioButton competence3oui;
    @FXML
    private RadioButton competence3non;
    @FXML
    private RadioButton competence4oui;
    @FXML
    private RadioButton competence4non;
    @FXML
    private RadioButton competence5oui;
    @FXML
    private RadioButton competence5non;
    @FXML
    private RadioButton competence6oui;
    @FXML
    private RadioButton competence6non;
    @FXML
    private TextField commentaire4;
    
    @FXML
    private RadioButton evaluation_globaleoui;
    @FXML
    private RadioButton evaluation_globalenon;
    
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
            Boolean ponctualite1 = ponctualite1oui.isSelected();
            Boolean ponctualite2 = ponctualite2oui.isSelected();
            String comm1 = commentaire1.getText();
            Boolean integration1 = integration1oui.isSelected();
            Boolean integration2 = integration2oui.isSelected();
            Boolean integration3 = integration3oui.isSelected();
            String comm2 = commentaire2.getText();
            Boolean travail1 = travail1oui.isSelected();
            Boolean travail2 = travail2oui.isSelected();
            Boolean travail3 = travail3oui.isSelected();
            Boolean travail4 = travail4oui.isSelected();
            String comm3 = commentaire3.getText();
            Boolean competence1 = competence1oui.isSelected();
            Boolean competence2 = competence2oui.isSelected();
            Boolean competence3 = competence3oui.isSelected();
            Boolean competence4 = competence4oui.isSelected();
            Boolean competence5 = competence5oui.isSelected();
            Boolean competence6 = competence6oui.isSelected();
            String comm4 = commentaire4.getText();
            Boolean evaluation_global = evaluation_globaleoui.isSelected();
            String comm5 = commentaire5.getText();
            
            EvaluationMi evaluation = new EvaluationMi(ponctualite1,ponctualite2,comm1,integration1,integration2,
            integration3,comm2,travail1,travail2,travail3,travail4,comm3,competence1,competence2,competence3,competence4,
            competence5,competence6,comm4,evaluation_global,comm5);
            
            EvaluationMiCRUD emc = new EvaluationMiCRUD();
            
            emc.ajouterEvaluationMi(evaluation);
            
            //Ajout effectué
            
            System.out.println("Ajout effectué");
        
    }
    
    
    
}
