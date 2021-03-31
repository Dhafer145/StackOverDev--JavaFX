/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.Plan_travail;
import entities.Proposition_projet;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Consulter_planController implements Initializable {

    @FXML
    private TextField tfbl;
    @FXML
    private TextField tfsprint;
    @FXML
    private TextField tfidp;
    @FXML
    private Button btnvalid;
    
    @FXML
    private Button btnrefus;
    @FXML
    private TextField tfraison;
    Connection cn = Myconn.getInstance().getConnection();
    @FXML
    private TextField tfetudiant;
    Plan_travail ptr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void initData(Plan_travail ptr){
        this.ptr=ptr;
        tfidp.setText(""+this.ptr.getId_pt());
        tfetudiant.setText(""+this.ptr.getId_user());
        tfbl.setText(this.ptr.getBacklog());
        tfsprint.setText(this.ptr.getSprints());
          
    }

    @FXML
    private void Valider(ActionEvent event) {
        PreparedStatement stm;

        try {
            stm = cn.prepareStatement("UPDATE plan_travail SET validation_pt=?,commentaire_pt=?  WHERE id_pt=?");
            
         stm.setString(1,"Validé");
         stm.setString(2,tfraison.getText());
            
//             Int id=  ValueOf.tfid.getText();
          stm.setString(3,tfidp.getText());
         


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
            stm = cn.prepareStatement("UPDATE plan_travail SET validation_pt=?,commentaire_pt=?  WHERE id_pt=?");
            
         stm.setString(1,"Refusé");
         stm.setString(2,tfraison.getText());
            
                 
          stm.setString(3,tfidp.getText());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }
    
}
