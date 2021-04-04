/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.Plan_travail;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Tableau_planController implements Initializable {

    @FXML
    private TableColumn<Plan_travail, Integer> colid;
    @FXML
    private TableColumn<Plan_travail, Integer> coletudiant;
    @FXML
    private TableColumn<Plan_travail, String> colbg;
    @FXML
    private TableColumn<Plan_travail, String> colsprint;
    @FXML
    private Button btnConsulter;
     ObservableList<Plan_travail> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<Plan_travail> tv_plan;
    @FXML
    private Button btnaccueil;
    @FXML
    private Button logout;
        

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      loadTable();   
    }  
    
    
    
     public void loadTable(){
        
        try {
            
            oblist.clear();
      Connection cnx = Myconn.getInstance().getConnection();
            ResultSet rs = cnx.createStatement().executeQuery("Select id_pt,id_user,backlog, sprints from plan_travail ");
            

            while(rs.next()){
                oblist.add(new Plan_travail(rs.getInt("id_pt"),rs.getInt("id_user"),rs.getString("backlog"),rs.getString("sprints")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(Tableau_planController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_pt"));
        coletudiant.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colbg.setCellValueFactory(new PropertyValueFactory<>("backlog"));
         colsprint.setCellValueFactory(new PropertyValueFactory<>("sprints"));
        
        tv_plan.setItems(oblist);
    
    }

    @FXML
    private void consultation(ActionEvent event) throws IOException, SQLException {
        
    Plan_travail pt= tv_plan.getSelectionModel().getSelectedItem();
    Plan_travail ptt=new Plan_travail();
    PreparedStatement stm;
    
    
    
 Connection cnx = Myconn.getInstance().getConnection();   
               ResultSet rs = cnx.createStatement().executeQuery("Select  id_pt,id_user,backlog,sprints from plan_travail where id_pt= "+pt.getId_pt());
               
               while(rs.next()){
                ptt.setId_pt(rs.getInt("id_pt"));
                ptt.setId_user(rs.getInt("id_user"));
                ptt.setBacklog(rs.getString("backlog"));
                ptt.setSprints(rs.getString("sprints"));
               
            
            }
               
               FXMLLoader loader = new FXMLLoader(getClass().getResource("Consulter_plan.fxml"));
            Scene scene = new Scene(loader.load());
            

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
               Consulter_planController cp=loader.getController();
               cp.initData(ptt);
               
// btnConsulter.getScene().getWindow().hide();
//                Parent root = FXMLLoader.load(getClass().getResource("Consulter_plan.fxml"));
//                Stage mainStage = new Stage();
//                Scene scene = new Scene(root);
//                mainStage.setScene(scene);
//                mainStage.show();

        }
 PreparedStatement pst = null;
     ResultSet rs = null;
    @FXML
     public void Accueil () throws Exception{  
          
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
                 
             if(role.equals("Encadrant Professionnel"))
                {     
                     String fullname=rs.getString(3);
             String email=rs.getString(4);
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("Acceuil_pro.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        Acceuil_proController aea=loader.getController();
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
