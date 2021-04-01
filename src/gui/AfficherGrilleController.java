/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.EvaluationMi;
import entities.GrilleEvaluation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AfficherGrilleController implements Initializable {

    @FXML
    private TableView<GrilleEvaluation> table;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_id;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_enc;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_etu;
    @FXML
    private TableColumn<GrilleEvaluation, String> col_etu1;
    @FXML
    private TableColumn<GrilleEvaluation, Integer> col_note;
    @FXML
    private TableColumn<GrilleEvaluation, String> col_mention;
    @FXML
    private TableColumn<GrilleEvaluation, Date> col_date;
    @FXML
    private TextField choose_id;
    @FXML
    private Button btnA;
    @FXML
    private Button btnS;
    @FXML
    private Button btnM;
    @FXML
    private Button btnAct;
    @FXML
    private Button btnAff;
    
    
    private int id_encadrant=90;
    
    
    ObservableList<GrilleEvaluation> oblist = FXCollections.observableArrayList();

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
    private void getAddView(ActionEvent event) {
        
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/AjoutGrille.fxml"));
            Scene scene = new Scene(parent);
            Stage stage =  new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter grille d'evaluation");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void deleteEv(ActionEvent event) {
        
         int id_c;
        id_c =Integer.parseInt(choose_id.getText());
        Connection cnx = MyConnection.getInstance().getConnection();
        PreparedStatement stmt;
        
            
        try {
            stmt = cnx.prepareStatement("DELETE FROM grille where id = ?");
            stmt.setInt(1, id_c);
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadTable();
        
    }

   

    @FXML
    private void loadTable() {
        
         try {
            
            oblist.clear();
            Connection cnx = MyConnection.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id,id_enc,id_etu,date_r,mention,note from grille where id_enc="+id_encadrant+"");


            while(rs.next()){
                Connection cnx1 = MyConnection.getInstance().getConnection();
                
                int i= rs.getInt("id_etu");
                System.out.println(i);
                ResultSet rs1=cnx1.createStatement().executeQuery("Select * from user where id_user="+i+"");
                
                
                while(rs1.next()){
//                    System.out.println(rs1.getString("full_name"));
                    String nomE=rs1.getString("full_name");
                    System.out.println(nomE);
                
                oblist.add(new GrilleEvaluation(rs.getInt("id"),rs.getInt("id_enc"),rs.getInt("id_etu"),nomE,rs.getDate("date_r"),rs.getString("mention"),rs.getInt("note")));
                }
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherGrilleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_ev_mi"));
        col_enc.setCellValueFactory(new PropertyValueFactory<>("id_enc"));
        col_etu.setCellValueFactory(new PropertyValueFactory<>("id_etu"));
        col_etu1.setCellValueFactory(new PropertyValueFactory<>("nom_etudiant"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_r"));
        col_mention.setCellValueFactory(new PropertyValueFactory<>("mention"));
        col_note.setCellValueFactory(new PropertyValueFactory<>("note"));
       
        
        table.setItems(oblist);
    
        
    }

    @FXML
    private void getConsView(ActionEvent event) {
        
         EvaluationMi.chosen = Integer.parseInt(choose_id.getText());
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/ConsulterGrille.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier grille");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     @FXML
    private void getModView(ActionEvent event) {
        
        EvaluationMi.chosen = Integer.parseInt(choose_id.getText());
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/ModifierGrille.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier grille d'evaluation");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
