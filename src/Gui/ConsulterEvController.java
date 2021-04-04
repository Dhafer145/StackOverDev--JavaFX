/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Tools.Print.printNode;
import entities.EvaluationMi;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import services.EvaluationMiCRUD;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class ConsulterEvController implements Initializable {
    
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
    private TextField nomEtudiant;
     
     private String nomE;
     
     @FXML
     private Button btnPrint;
     
     @FXML
     private AnchorPane anchor;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    private void loadData() throws SQLException {
        
        EvaluationMiCRUD emc = new EvaluationMiCRUD();
        EvaluationMi ev = new EvaluationMi();
        ev=emc.consulterEvaluationMi();
        
        
        
        Connection cnx1 = Myconn.getInstance().getConnection();
                
                int i= ev.getId_etu();
                System.out.println(i);
                ResultSet rs1=cnx1.createStatement().executeQuery("Select * from user where id_user="+i+"");
                
                
                while(rs1.next()){
//                    System.out.println(rs1.getString("full_name"));
                    nomE=rs1.getString("full_name");
                    System.out.println(nomE);
                }
        
        
                
        nomEtudiant.setText(nomE);
        
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

    @FXML
    private void print(ActionEvent event) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        

           printNode(anchor);

        
    }
    
    
    
}
