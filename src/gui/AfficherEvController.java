/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    
    
    
    
    ObservableList<EvaluationMi> oblist = FXCollections.observableArrayList();

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
        Connection cnx = MyConnection.getInstance().getConnection();
        PreparedStatement stmt;
        
            
        try {
            stmt = cnx.prepareStatement("DELETE FROM ev where id = ?");
            stmt.setInt(1, id_c);
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = MyConnection.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id,id_enc,id_etu,date_r from ev");
            
            while(rs.next()){
                oblist.add(new EvaluationMi(rs.getInt("id"),rs.getInt("id_enc"),rs.getInt("id_etu"),rs.getDate("date_r")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_ev_mi"));
        col_enc.setCellValueFactory(new PropertyValueFactory<>("id_enc"));
        col_etu.setCellValueFactory(new PropertyValueFactory<>("id_etu"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_r"));
        
       
        
        table.setItems(oblist);
    
    }
    
    
}
