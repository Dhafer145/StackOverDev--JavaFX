/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import pidevpfe.entities.Etudiant;
import pidevpfe.entities.affectation;
import pidevpfe.entities.user;
import pidevpfe.tools.Myconnexion;

/**
 * FXML Controller class
 *
 * @author ramzuss
 */
public class VisualiserEtudiantsController implements Initializable {

    @FXML
    private TableView<affectation> tvea;
    @FXML
    private TableColumn<affectation,String> coluser;
   
    @FXML
    private Label email;

    /**
     * Initializes the controller class.
     */
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      showUser();
    // email.setText(seTtext());
      
    }    
   public void email(){
      
   }
    
   
  public  String seTtext(String email){
    
      this.email.setText(email);
      
       System.out.println(this.email.getText());
  
    showUser();
    return this.email.getText(); 


    } 
   
  
   
       PreparedStatement st=null;
        ResultSet rs=null;
   public ObservableList<affectation> getuserList(){
        
       
       ObservableList<affectation> userList = FXCollections.observableArrayList();
        Connection cnx = Myconnexion.getInstance().getConnection();
        String req = "SELECT affectation.nom_etudiant ,user.full_name from affectation left join user on affectation.nom_encadrant_academique=user.full_name where user.email=?";
       
       
        try{
             
         
               st = cnx.prepareStatement(req);
            //st.setString(1,email.getText());
             st.setString(1,this.email.getText());
             
             System.out.println();
           
           
            //String s = cbrole.getSelectionModel().getSelectedItem().toString();
            //pst.setString(3,s);
           
            
            rs = st.executeQuery();
            
           
           affectation affect;
                
            
            
            while(rs.next()){
                System.err.println("ssss");
                affect = new affectation(rs.getString("nom_etudiant")); // depuis bd //
                
                userList.add(affect);
                
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return userList;
        
    }
    
     public void showUser(){
        ObservableList<affectation> list = getuserList();


         
        
         

coluser.setCellValueFactory(new PropertyValueFactory<affectation, String>("nomEtudiant"));


        
         //classe user.java

        tvea.setItems(list);
       

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    PreparedStatement pst = null;
     ResultSet rs = null;
    public void visualiser() {
     Connection cnx = Myconnexion.getInstance().getConnection();
    String sql = "SELECT affectation.nom_etudiant FROM `affectation` left JOIN `user`  on affectation.nom_encadrant_academique=user.full_name where email=? ";
     try {
            pst = cnx.prepareStatement(sql);
            pst.setString(1, email.getText());
             
            
            rs = pst.executeQuery();
            
            if(rs.next()){ 
               
               
            
                        
             coluser.setText("hahahahaha");
            }
   
       
     
      //button.getScene().getWindow().hide();  //pour fermer interface login
               
            
    
    
    
    
    }
     catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    
*/
}