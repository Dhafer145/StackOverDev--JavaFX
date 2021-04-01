/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.EvaluationMi;
import entities.GrilleEvaluation;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.GrilleEvaluationCRUD;
import tools.MyConnection;
import static tools.Print.printNode;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class ConsulterGrilleController implements Initializable {

    @FXML
    private TextField noteF;
    @FXML
    private TextField mentionF;
    @FXML
    private TextField c1;
    @FXML
    private TextField c2;
    @FXML
    private TextField c3;
    @FXML
    private TextField c4;
    @FXML
    private TextField c5;
    @FXML
    private TextField c6;
    @FXML
    private TextField c7;
    @FXML
    private TextField c8;
    @FXML
    private TextField nom_etudiant;

    private String nomE;
    
    @FXML
    private AnchorPane anchor;
    
     @FXML
     private Button btnPrint;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterGrilleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void loadData() throws SQLException {
        
        GrilleEvaluationCRUD gec = new GrilleEvaluationCRUD();
        GrilleEvaluation ge = new GrilleEvaluation();
        ge=gec.consulterGrilleEvaluation();
        
        Connection cnx1 = MyConnection.getInstance().getConnection();
                
                int i= ge.getId_etu();
                System.out.println(i);
                ResultSet rs1=cnx1.createStatement().executeQuery("Select * from user where id_user="+i+"");
                
                
                while(rs1.next()){
//                    System.out.println(rs1.getString("full_name"));
                    nomE=rs1.getString("full_name");
                    System.out.println(nomE);
                }

        c1.setText(ge.getQ1());
        c2.setText(ge.getQ2());
        c3.setText(ge.getQ3());
        c4.setText(ge.getQ4());
        c5.setText(ge.getQ5());
        c6.setText(ge.getQ6());
        c7.setText(ge.getQ7());
        c8.setText(ge.getQ8());
        Integer n = ge.getNote();
        noteF.setText(n.toString());
        mentionF.setText(ge.getMention());
        nom_etudiant.setText(nomE);
        
        
        
        
    }
    
    @FXML
    private void print(ActionEvent event) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        

           printNode(anchor);

        
    }
    
}
