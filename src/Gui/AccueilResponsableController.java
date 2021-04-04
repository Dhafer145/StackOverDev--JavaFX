/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import entities.Etudiant;
import entities.user;
import tools.Myconn;

/**
 * FXML Controller class
 *
 * @author ramzuss
 */
public class AccueilResponsableController implements Initializable {


    @FXML
    private Button lgereruser;
    
    @FXML
    private Button lgererprofile;
    
    @FXML
    private Button laffecter;
    
    @FXML
    private Button changepassword;
    
    @FXML
    public  Label lnom;
    @FXML
    public  Label lemail;
    @FXML
    private PieChart pie;
    @FXML
    private Button btnConstEv;
    @FXML
    private Button btnConstG;
    @FXML
    private Button ButtonConsulterBilan;
    @FXML
    private Button ajtsouten;
    @FXML
    private Button logout;
    
   
    
   
   
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    loadchart();
    }    
  
    
    @FXML 
  public void loadchart() {
         Connection cnx = Myconn.getInstance().getConnection();
        Statement st;
        ResultSet rs;  
         String sql = "select full_name ,role from user";
            int i=0;
            int j=0;
            int k=0;
            
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
         while (rs.next()){
             if (rs.getString(2).equals("Etudiant")){
                 i++;
             }
             else if (rs.getString(2).equals("Encadrant Académique ")){
                 j++;
             }
             else if (rs.getString(2).equals("Encadrant professionnel ")){
                 k++;
             }
         }
       
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        ObservableList valuelist = FXCollections.observableArrayList(
                new PieChart.Data("Etudiant",i),
                new PieChart.Data("Encadrant Académique",j),
                new PieChart.Data("Encadrant professionnel",k));
        pie.getData().addAll(valuelist);
        
    }  
    
     
    
   
     public void seTtext(String fullname,String email){
    this.lnom.setText(fullname);
    this.lemail.setText(email);
    }
   
    @FXML
    public void changepassword() throws IOException{
    
     changepassword.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    @FXML
     public void gererUser() throws IOException{
    
     lgereruser.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("GererUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
     
    @FXML
     public void affecterEncadrant() throws IOException{
    
     laffecter.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AffecterEncadrant.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
     
     PreparedStatement pst = null;
     ResultSet rs = null;
    
     @FXML
     public void gererProfile() throws Exception{
         
      Connection cnx = Myconn.getInstance().getConnection();
    String sql = "Select * from user where email=?";
        
    try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, lemail.getText());
            
            
            
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
               
           
                     
                    
             String username=rs.getString(2);
             String fullname=rs.getString(3);
             String adresse=rs.getString(8);
             
   FXMLLoader loader=new FXMLLoader();
   loader.setLocation(getClass().getResource("GererProfile.fxml"));
        try {
            loader.load();
        } catch (Exception e) {
        }
        
        GererProfileController gp=loader.getController();
        gp.seTtext(username,fullname,adresse,lemail.getText());
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.show();
     
     lgererprofile.getScene().getWindow().hide();  //pour fermer interface login

       
  
                
               
            
                
            
            } 
          
                } 
    catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }

    @FXML
     public void getConstEv() throws IOException{
    
     btnConstEv.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AfficherEvResponsable.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
     
   @FXML
     public void getConstG() throws IOException{
    
     btnConstG.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("AfficherGrilleResponsable.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void ConsultBilan(MouseEvent event) throws IOException {
         ButtonConsulterBilan.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("SuiviBilans.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    public void ajouters(MouseEvent event) throws IOException {
    
     ajtsouten.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Soutenance.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
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
     
     