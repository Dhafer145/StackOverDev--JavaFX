/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.Proposition_projet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Details_propositionController implements Initializable {

    @FXML
    private AnchorPane AnO;
    @FXML
    private TextField text_nom;
    @FXML
    private TextField text_sujet;
    @FXML
    private TextField text_description;
    Proposition_projet p;
    @FXML
    private TextField text_cahier;
    @FXML
    private Button btnConsulter;
    @FXML
    private Button btnConsulter1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
        
    }   
    public void initData(Proposition_projet p){
        this.p=p;
        text_nom.setText(""+this.p.getId_user());
        text_sujet.setText(this.p.getNom_sujet());
         text_cahier.setText(this.p.getCahier_charge());
          text_description.setText(this.p.getDescription());
        
        
    }
    
    
//    @FXML
//     public void loadData() throws SQLException {
//        try {
//         
//         Connection cnx = Myconn.getInstance().getConnection();
//            
//            ResultSet rs = cnx.createStatement().executeQuery("Select  id_user,nom_sujet,cahier_charge,description from proposition_projet ");
//            
//            
//            
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//            
////              commentaire5.setText(ev.getComm5());   
//     } 

    @FXML
    private void proposition(ActionEvent event) throws IOException {
        
         btnConsulter.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Validation_proposition.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
     
    
}
