/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.Journal_projet;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Validation_propositionController implements Initializable {

    @FXML
    private AnchorPane AnO;
    @FXML
    private TableColumn<Proposition_projet, Integer> colid;
    @FXML
    private TableColumn<Proposition_projet, String> colnom;
    @FXML
    private TableColumn<Proposition_projet, String> colsujet;
    ObservableList<Proposition_projet> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<Proposition_projet> tv_prop;
    @FXML
    private Button btnConsulter;
    @FXML
    private Button btncr;
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
            
            ResultSet rs = cnx.createStatement().executeQuery("Select  id_sujet,id_user,nom_sujet from proposition_projet ");
            

            while(rs.next()){
                oblist.add(new Proposition_projet(rs.getInt("id_sujet"),rs.getInt("id_user"),rs.getString("nom_sujet")));
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(JournalStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_sujet"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colsujet.setCellValueFactory(new PropertyValueFactory<>("nom_sujet"));
        
        tv_prop.setItems(oblist);
    
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException, SQLException {
    Proposition_projet pp= tv_prop.getSelectionModel().getSelectedItem();
    Proposition_projet pj=new Proposition_projet();
    PreparedStatement stm;
    
    Connection cnx = Myconn.getInstance().getConnection();
               ResultSet rs = cnx.createStatement().executeQuery("Select  id_sujet,id_user,nom_sujet,cahier_charge,description from proposition_projet where id_sujet= "+pp.getId_sujet());
               
               while(rs.next()){
                pj.setId_sujet(rs.getInt("id_sujet"));
                pj.setId_user(rs.getInt("id_user"));
                pj.setNom_sujet(rs.getString("nom_sujet"));
                pj.setCahier_charge(rs.getString("cahier_charge"));
                pj.setDescription(rs.getString("description"));
            
            }
               FXMLLoader loader = new FXMLLoader(getClass().getResource("Details_proposition.fxml"));
            Scene scene = new Scene(loader.load());
            

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
               Details_propositionController dp=loader.getController();
               dp.initData(pj);
               

        }

    @FXML
    private void validationCr(ActionEvent event) throws IOException {
        
        btncr.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("consulter_cr.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
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
    

