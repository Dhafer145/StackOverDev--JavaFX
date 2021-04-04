/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.EvaluationMi;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tools.Myconn;

import javafx.scene.control.SelectionModel;


/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AfficherEvController implements Initializable {

    @FXML
    private TableView<EvaluationMi> table;
    @FXML
    private TableColumn<EvaluationMi,Integer> col_id;
    @FXML
    private TableColumn<EvaluationMi, Integer> col_enc;
    @FXML
    private TableColumn<EvaluationMi, Integer> col_etu;
    @FXML
    private TableColumn<EvaluationMi, String> col_etu1;
    @FXML
    private TableColumn<EvaluationMi, Date> col_date;
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
    @FXML
    private TextField choose_id;
    
    private int id_encadrant=LoginController.logged;
    
    
    
    
    ObservableList<EvaluationMi> oblist = FXCollections.observableArrayList();
    
//    TableViewSelectionModel selectionModel = table.getSelectionModel();
    
//    selectionModel.setSelectionMode(SelectionMode.SINGLE);
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
    private void getAddView(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/AjoutEvMi.fxml"));
            Scene scene = new Scene(parent);
            Stage stage =  new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter evaluation");
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
            
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/ModifierEvMi.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier evaluation");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void getConsView(ActionEvent event) {
        EvaluationMi.chosen = Integer.parseInt(choose_id.getText());
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/ConsulterEv.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier evaluation");
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
        Connection cnx = Myconn.getInstance().getConnection();
        PreparedStatement stmt;
        
            
        try {
            stmt = cnx.prepareStatement("DELETE FROM evaluation where id = ?");
            stmt.setInt(1, id_c);
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadTable();
        
    }
    
    
    @FXML
    public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id,id_enc,id_etu,date_r from evaluation where id_enc="+id_encadrant+"");


            while(rs.next()){
                Connection cnx1 = Myconn.getInstance().getConnection();
                
                int i= rs.getInt("id_etu");
                System.out.println(i);
                ResultSet rs1=cnx1.createStatement().executeQuery("Select * from user where id_user="+i+"");
                
                
                while(rs1.next()){
//                    System.out.println(rs1.getString("full_name"));
                    String nomE=rs1.getString("full_name");
                    System.out.println(nomE);
                
                oblist.add(new EvaluationMi(rs.getInt("id"),rs.getInt("id_enc"),rs.getInt("id_etu"),nomE,rs.getDate("date_r")));
                }
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_ev_mi"));
        col_enc.setCellValueFactory(new PropertyValueFactory<>("id_enc"));
        col_etu.setCellValueFactory(new PropertyValueFactory<>("id_etu"));
        col_etu1.setCellValueFactory(new PropertyValueFactory<>("nom_etudiant"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_r"));
        
       
        
        table.setItems(oblist);
    
    }
    
    @FXML
    private void modifier(MouseEvent event) {
        
       EvaluationMi em= table.getSelectionModel().getSelectedItem();
       choose_id.setText(String.valueOf(em.getId_ev_mi()));
//       text_tache.setText(jp.getTache());
//       text_avis.setText(jp.getAvis());
       
       
       
     
       
      
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
