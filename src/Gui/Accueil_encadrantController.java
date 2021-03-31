/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Accueil_encadrantController implements Initializable {

    @FXML
    private Button btnpp;
    @FXML
    private Button btnconscr;
    @FXML
    private Button btnconspt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void conspp(ActionEvent event) throws IOException {
       
        btnpp.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Validation_proposition.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void conscr(ActionEvent event) throws IOException {
        
        btnconscr.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Consulter_cr.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void conspt(ActionEvent event) throws IOException {
        btnconspt.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Tableau_plan.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
        
    }
    
    

