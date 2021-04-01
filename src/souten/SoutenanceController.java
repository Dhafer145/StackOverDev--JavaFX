/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package souten;

import Entite.soutenance;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tools.myconnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import static sun.net.www.MimeTable.loadTable;

/**
 * FXML Controller class
 *
 * @author usp
 */
public class SoutenanceController implements Initializable {
    
    @FXML
    private Button btnEnvoyer;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField tnEncadrant;
    @FXML
    private TextField tnPresident;
    @FXML
    private ComboBox cb1;
    @FXML
    private TextField tnEtudiant;
    @FXML
    private TextField tnID;
    @FXML
    private TextField tdatesoutenance ;
     @FXML
    private TableColumn<soutenance, Integer> colids;
     @FXML
    private TableColumn<soutenance, String> Etudiant;
     @FXML
    private TableColumn<soutenance,String> colPresident;
     @FXML
    private TableColumn<soutenance,String> colEncadrant;
     @FXML
     private TableColumn<soutenance,String> colDate;
     @FXML
     private TableColumn<soutenance,String> colsalle;
    @FXML
    private TableView<soutenance> tvs;
     
     private String sl;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTable();
        ObservableList<String> opt = FXCollections.observableArrayList(
        "A01",
        "A02",
        "A02",
        "A03",
        "A04",
        "B01",
        "B02",
        "B03",
        "B04",
        "C01",
        "C02",
        "C03",
        "C04",
        "D01",
        "D02",
        "D03",
        "D04");
        
        cb1.setItems(opt);
        
    }    
    
    @FXML
    private void selectQ1(ActionEvent event) throws IOException{
        String SL = cb1.getSelectionModel().getSelectedItem().toString();
        
        sl = SL;         
    }
   

    
    @FXML
    public void AjouterSoutenance(){
        Connection cnx= myconnection.getInstance().getConnection();
        
        String d = (tdatesoutenance.getText());
        String salle= "\""+sl+"\"";
        boolean test=false;
        
        ObservableList<String> dates = FXCollections.observableArrayList();
        ResultSet rs;
        
        try {
            rs = cnx.createStatement().executeQuery("select * from presentation where salle ="+salle+"");
            while(rs.next()){
                
                if(d.equals(rs.getString("date_soutenance"))){test=true;}
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoutenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        PreparedStatement ste;
        if(test==false){
        try{
            ste=cnx.prepareStatement("insert into presentation(non_etudiant ,non_president,non_encadrant,date_soutenance,salle) values(?,?,?,?,?)");
            
            ste.setString(1,tnEtudiant.getText());
            ste.setString(2,tnPresident.getText());
            ste.setString(3,tnEncadrant.getText());
            ste.setString(4,tdatesoutenance.getText());
            
            tdatesoutenance.setText(null);
            ste.setString(5,sl);
            
            int i = ste.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        
    }}else{System.out.println("la salle est occupée");}
        
        loadTable();
}
    
    
    
    
    
    public ObservableList<soutenance> getoblist(){
         ObservableList<soutenance> oblist = FXCollections.observableArrayList();
         Connection cnx = myconnection.getInstance().getConnection();
         String query="Select  * from presentation";
         PreparedStatement preparedStatement;
         ResultSet resultSet;
         try{
            preparedStatement=myconnection.getInstance().getConnection().prepareStatement(query);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                 oblist.add(new soutenance(resultSet.getInt("id_p"),resultSet.getString("non_etudiant"),resultSet.getString("non_president"),resultSet.getString("non_encadrant"),resultSet.getString("date_soutenance"),resultSet.getString("salle")));

            }
         
         } catch (SQLException ex) {
            Logger.getLogger(SoutenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return oblist;


    }
    public void loadTable(){
        
        ObservableList<soutenance> oblist=getoblist();
        colids.setCellValueFactory(new PropertyValueFactory<soutenance, Integer>("id_p"));
        Etudiant.setCellValueFactory(new PropertyValueFactory<soutenance, String>("non_etudiant"));
        colPresident.setCellValueFactory(new PropertyValueFactory<soutenance, String>("non_president"));
        colEncadrant.setCellValueFactory(new PropertyValueFactory<soutenance, String>("non_encadrant"));
        colDate.setCellValueFactory(new PropertyValueFactory<soutenance, String>("date_soutenance"));
        colsalle.setCellValueFactory(new PropertyValueFactory<soutenance, String>("salle"));
       
        
        tvs.setItems(oblist);
    
    }

  
    
    
    
    @FXML
public void ModifierSo(ActionEvent Event) {
    Connection  cn=myconnection.getInstance().getConnection();
    String d = (tdatesoutenance.getText());
        String salle= "\""+sl+"\"";
        boolean test=false;
        
        ObservableList<String> dates = FXCollections.observableArrayList();
        ResultSet rs;
        
        try {
            rs = cn.createStatement().executeQuery("select * from presentation where salle ="+salle+"");
            while(rs.next()){
                
                if(d.equals(rs.getString("date_soutenance"))){test=true;}
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoutenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    PreparedStatement st;

   
      
  if(test==false){
  try{
      st = cn.prepareStatement("UPDATE presentation SET  non_etudiant=? ,non_president=? , non_encadrant=? , date_soutenance=? , salle=?   WHERE id_p=?"  );
      
           
            st.setString(1,tnEncadrant.getText());
            st.setString(2,tnPresident.getText());
            st.setString(3,tnEtudiant.getText());
            st.setString(4,tdatesoutenance.getText());
            
            tdatesoutenance.setText(null);
            
            st.setString(5, sl);
            st.setString(6, (tnID.getText()));
            
             int i= st.executeUpdate();
            System.out.println(i);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } }else{System.out.println("la salle est occupée");}
  loadTable();
}

    





     @FXML
    private void modifiers(MouseEvent event) {
          soutenance  s= tvs.getSelectionModel().getSelectedItem();
          tnID.setText(String.valueOf(s.getId_p()));
          tnEtudiant.setText(s.getNon_etudiant());
          tnPresident.setText(s.getNon_president());
          tnEncadrant.setText(s.getNon_encadrant());
          tdatesoutenance.setText(s.getDate_soutenance());
          
       //tdatesoutenance.setValue(LocalDate.parse(s.getDate_soutenance(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    
          cb1.setValue(s.getSalle());
          
    }

}

