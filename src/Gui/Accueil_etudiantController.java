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
public class Accueil_etudiantController implements Initializable {

    @FXML
    private Button btncr;
    @FXML
    private Button btnprop;
    @FXML
    private Button btnjs;
    @FXML
    private Button btnplan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutCr(ActionEvent event) throws IOException {
        btncr.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("CompteRendu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void proposer(ActionEvent event) throws IOException {
        btnprop.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("ProposerProjet.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void journal(ActionEvent event) throws IOException {
        btnjs.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Journal_Stage.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void plandetravail(ActionEvent event) throws IOException {
        btnplan.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Plan_Travail.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
