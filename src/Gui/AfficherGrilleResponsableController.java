/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.EvaluationMi;
import entities.GrilleEvaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AfficherGrilleResponsableController implements Initializable {

    @FXML
    private TableView<GrilleEvaluation> table;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_id;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_etu;
    @FXML
    private TableColumn<GrilleEvaluation, String> col_etu1;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_enc;
    @FXML
    private TableColumn<GrilleEvaluation, String> col_enc1;
    @FXML
    private TableColumn<GrilleEvaluation, String> col_mention;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_note;
    @FXML
    private TableColumn<GrilleEvaluation, Date> col_date;
    @FXML
    private TextField choose_id;
    @FXML
    private Button btnAff;
    
    ObservableList<GrilleEvaluation> oblist = FXCollections.observableArrayList();
    
     private String nomE;
    private String nomEnc;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTable();
    }    

    @FXML
    private void modifier(MouseEvent event) {
        
         GrilleEvaluation em= table.getSelectionModel().getSelectedItem();
       choose_id.setText(String.valueOf(em.getId_grille()));
    }

    @FXML
    private void getConsView(ActionEvent event) {
        
         EvaluationMi.chosen = Integer.parseInt(choose_id.getText());
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/ConsulterGrille.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier grille");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherGrilleResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void loadTable() {
        
         try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id,id_enc,id_etu,date_r,mention,note from grille");


            while(rs.next()){
                Connection cnx1 = Myconn.getInstance().getConnection();
                
                int i= rs.getInt("id_etu");
                int j= rs.getInt("id_enc");
                
                System.out.println(i);
                ResultSet rs1=cnx1.createStatement().executeQuery("Select * from user where id_user="+i+"");
                ResultSet rs2=cnx1.createStatement().executeQuery("Select * from user where id_user="+j+"");
                
                
                while(rs1.next()){
//                    System.out.println(rs1.getString("full_name"));
                    nomE=rs1.getString("full_name");
                    System.out.println(nomE);
                
                }
                
                while(rs2.next()){
//                    System.out.println(rs1.getString("full_name"));
                    nomEnc=rs2.getString("full_name");
                    System.out.println(nomEnc);
                
                 }
                
         oblist.add(new GrilleEvaluation(rs.getInt("id"),rs.getInt("id_enc"),rs.getInt("id_etu"),nomE,nomEnc,rs.getDate("date_r"),rs.getString("mention"),rs.getInt("note")));

            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherGrilleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_ev_mi"));
        col_enc.setCellValueFactory(new PropertyValueFactory<>("id_enc"));
        col_etu.setCellValueFactory(new PropertyValueFactory<>("id_etu"));
        col_etu1.setCellValueFactory(new PropertyValueFactory<>("nom_etudiant"));
        col_enc1.setCellValueFactory(new PropertyValueFactory<>("nom_encadrant"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_r"));
        col_mention.setCellValueFactory(new PropertyValueFactory<>("mention"));
        col_note.setCellValueFactory(new PropertyValueFactory<>("note"));
       
        
        table.setItems(oblist);
    
        
    }

     
    @FXML
    public void logout() throws IOException{
    
     logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
}
