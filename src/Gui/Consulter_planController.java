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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Consulter_planController implements Initializable {

    @FXML
    private TextField tfbl;
    @FXML
    private TextField tfsprint;
    @FXML
    private TextField tfidp;
    @FXML
    private Button btnvalid;
    
    @FXML
    private Button btnrefus;
    @FXML
    private TextField tfraison;
    Connection cn = Myconn.getInstance().getConnection();
    @FXML
    private TextField tfetudiant;
    Plan_travail ptr;
    @FXML
    private Button btnaccueil;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void initData(Plan_travail ptr){
        this.ptr=ptr;
        tfidp.setText(""+this.ptr.getId_pt());
        tfetudiant.setText(""+this.ptr.getId_user());
        tfbl.setText(this.ptr.getBacklog());
        tfsprint.setText(this.ptr.getSprints());
          
    }

    @FXML
    private void Valider(ActionEvent event) {
        PreparedStatement stm;

        try {
            stm = cn.prepareStatement("UPDATE plan_travail SET validation_pt=?,commentaire_pt=?  WHERE id_pt=?");
            
         stm.setString(1,"Validé");
         stm.setString(2,tfraison.getText());
            
//             Int id=  ValueOf.tfid.getText();
          stm.setString(3,tfidp.getText());
         


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void Refuser(ActionEvent event) {
           Proposition_projet pp= new Proposition_projet() ;
        PreparedStatement stm;
if  (tfraison.getText().length()==0) {

            JOptionPane.showMessageDialog(null, "veuillez saisir la raison du refus");
             }
else{
        try {
            stm = cn.prepareStatement("UPDATE plan_travail SET validation_pt=?,commentaire_pt=?  WHERE id_pt=?");
            
         stm.setString(1,"Refusé");
         stm.setString(2,tfraison.getText());
            
                 
          stm.setString(3,tfidp.getText());
           
           
            


              int i = stm.executeUpdate();

            System.out.println(i);
            

        }catch (Exception e){
            e.printStackTrace();
        }
    }
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
