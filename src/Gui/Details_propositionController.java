/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.CompteRendu;
import entities.Proposition_projet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.JOptionPane;
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
    private Button btnvalid;
    @FXML
    private Button btnrefus;
    @FXML
    private TextField tfraison;
    Connection cn = Myconn.getInstance().getConnection();
    @FXML
    private TextField tfid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
        
    }   
    public void initData(Proposition_projet p){
        this.p=p;
        tfid.setText(""+this.p.getId_sujet());
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

    @FXML
    private void Valider(ActionEvent event) {
//  Proposition_projet pp= tfid.getId_sujer()  ;
        PreparedStatement stm;

        try {
            stm = cn.prepareStatement("UPDATE proposition_projet SET validation_pp=?,commentaire_pp=?  WHERE id_sujet=?");
            
         stm.setString(1,"Validé");
         stm.setString(2,tfraison.getText());
            
//             Int id=  ValueOf.tfid.getText();
          stm.setString(3,tfid.getText());
         


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    

    @FXML
    private void Refuser(ActionEvent event) {
        Proposition_projet pp= new Proposition_projet() ;
        PreparedStatement stm;
if  (tfraison.getText().length()==0) {

            JOptionPane.showMessageDialog(null, "veuillez saisir la raison du refus");
             }
else{
        try {
            stm = cn.prepareStatement("UPDATE proposition_projet SET validation_pp=?,commentaire_pp=?  WHERE id_sujet=?");
            
         stm.setString(1,"Refusé");
         stm.setString(2,tfraison.getText());
            stm.setString(3,tfid.getText());
                 
//          stm.setInt(3, pp.getId_sujet());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
     
    
}
