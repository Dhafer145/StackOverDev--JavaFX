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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author Jihene
 */
public class AfficherEvResponsableController implements Initializable {

    @FXML
    private TableView<EvaluationMi> table;
    @FXML
    private TableColumn<EvaluationMi, Integer> col_id;
    @FXML
    private TableColumn<EvaluationMi, Integer> col_enc;
    @FXML
    private TableColumn<EvaluationMi, Integer> col_etu;
    @FXML
    private TableColumn<EvaluationMi, String> col_etu1;
    @FXML
    private TableColumn<EvaluationMi, String> col_enc1;
    @FXML
    private TableColumn<EvaluationMi, Date> col_date;
    @FXML
    private TextField choose_id;
    @FXML
    private Button btnAff;
    
    private String nomE;
    private String nomEnc;
    
    ObservableList<EvaluationMi> oblist = FXCollections.observableArrayList();
    @FXML
    private Button logout;
    @FXML
    private Button btnaccueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTable();
        // TODO
    }    

    @FXML
    private void modifier(MouseEvent event) {
         
       EvaluationMi em= table.getSelectionModel().getSelectedItem();
       choose_id.setText(String.valueOf(em.getId_ev_mi()));
    }

    @FXML
    private void getConsView(ActionEvent event) {
        
        EvaluationMi.chosen = Integer.parseInt(choose_id.getText());
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("/Gui/ConsulterEv.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modifier evaluation");
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id,id_enc,id_etu,date_r from evaluation");


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
                
                oblist.add(new EvaluationMi(rs.getInt("id"),rs.getInt("id_etu"),rs.getInt("id_enc"),nomE,nomEnc,rs.getDate("date_r")));
               
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEvResponsableController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_ev_mi"));
        col_enc.setCellValueFactory(new PropertyValueFactory<>("id_enc"));
        col_etu.setCellValueFactory(new PropertyValueFactory<>("id_etu"));
        col_etu1.setCellValueFactory(new PropertyValueFactory<>("nom_etudiant"));
        col_enc1.setCellValueFactory(new PropertyValueFactory<>("nom_encadrant"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date_r"));
        
       
        
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

    
    
    @FXML
     public void Accueil () throws Exception{  
          PreparedStatement pst = null;
     ResultSet rs = null; 
    Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where id_user = ?  ";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1,LoginController.logged+"");
           
            
          
           
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
               
            String role =rs.getString(7);
                if(role.equals("responsable des stages"))
                {     
                    System.out.println("hahaha");
             String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("accueilResponsable.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        AccueilResponsableController acc=loader.getController();
        acc.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

               
            }  
                 if(role.equals("Etudiant"))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Accueil_etudiant.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Accueil_etudiantController acc=loader.getController();
        acc.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
            if(role.equals("Encadrant Académique "))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Accueil_encadrant.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Accueil_encadrantController aea=loader.getController();
        aea.seTtext(fullname,email);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
      btnaccueil.getScene().getWindow().hide();  //pour fermer interface login

                    
            }
                 
            } 
          
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }

    
    
}
