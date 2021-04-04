/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entities.CompteRendu;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class Consulter_crController implements Initializable {

    @FXML
    private TableColumn<CompteRendu, Integer> colid;
    @FXML
    private TableColumn<CompteRendu, Integer> coletudiant;
    @FXML
    private TableColumn<CompteRendu, String> colcr;
    
    ObservableList<CompteRendu> oblist = FXCollections.observableArrayList();
    @FXML
    private TableView<CompteRendu> tv_cr;
    @FXML
    private TableColumn<CompteRendu, String> colcomment;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btnrefuser;
    @FXML
    private TextField tfcom;
     Connection cn = Myconn.getInstance().getConnection();
    @FXML
    private Button btnVal;
    @FXML
    private Button btnaccueil;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
        loadTable();
    }    
      public void loadTable(){
        
        try {
            
            oblist.clear();
            Connection cnx = Myconn.getInstance().getConnection();
            
            ResultSet rs = cnx.createStatement().executeQuery("Select id_cr,id_user,fichier,commentaire from compte_rendu ");
            

            while(rs.next()){
                CompteRendu c=new CompteRendu();
                c.setId_cr(rs.getInt("id_cr"));
                c.setId_user(rs.getInt("id_user"));
                c.setFichier(rs.getString("fichier"));
                c.setCommentaire(rs.getString("commentaire"));
                oblist.add(c);
            
            }
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(CompteRenduController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id_cr"));
        coletudiant.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        colcr.setCellValueFactory(new PropertyValueFactory<>("fichier"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        
        tv_cr.setItems(oblist);
    
    }

    @FXML
    private void valider(ActionEvent event) throws SQLException {
        CompteRendu cr= tv_cr.getSelectionModel().getSelectedItem();
    
   
        PreparedStatement stm;

        try {
            stm = cn.prepareStatement("UPDATE compte_rendu SET validation_cr=?,commentaire_encadrant=?  WHERE id_cr=?");
            
         stm.setString(1,"Validé");
         stm.setString(2,tfcom.getText());
            
              
           
         stm.setInt(3, cr.getId_cr());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void refuser(ActionEvent event) {
        CompteRendu cr= tv_cr.getSelectionModel().getSelectedItem();
    
    
        PreparedStatement stm;
if  (tfcom.getText().length()==0) {

            JOptionPane.showMessageDialog(null, "veuillez saisir la raison du refus");
             }
else{
        try {
            stm = cn.prepareStatement("UPDATE compte_rendu SET validation_cr=?,commentaire_encadrant=?  WHERE id_cr=?");
            
         stm.setString(1,"Refusé");
         stm.setString(2,tfcom.getText());
            
                 
          stm.setInt(3, cr.getId_cr());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

    @FXML
    private void validationProp(ActionEvent event) throws IOException {
        
         btnVal.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Validation_proposition.fxml"));
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
