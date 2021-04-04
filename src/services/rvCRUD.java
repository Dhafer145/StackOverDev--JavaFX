/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import tools.Myconn;
import entities.rendez_vous;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import tools.SendMail;
import tools.Sendmaill;




/**
 *
 * @author dhiabenmabrouk
 */
public class rvCRUD {
    private Statement statement;
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public rvCRUD() {
        connection = Myconn.getInstance().getConnection();
    }
    
    public void AjouterRv (rendez_vous rv) throws Exception{
                String request="INSERT INTO rendezvous(login,lieu,date,raison)"+"VALUES(?,?,?,?) ";
              
try {

            preparedStatement = connection.prepareStatement(request);
            
            preparedStatement.setString(1,rv.getLogin());
            preparedStatement.setString(2,rv.getLieu()); 
          
            preparedStatement.setString (3,rv.getDate());
            preparedStatement.setString (4,rv.getRaison());
            
            preparedStatement.executeUpdate();
            System.out.println ("succes"); 
            
        Sendmaill.sendMail("mohameddhafer.harbaoui@esprit.tn");
            


        } catch (SQLException throwables) {
           
            
         
      
            

            System.out.println ("Probleme ici");
        }
        
    }
    public void EditerRv (rendez_vous rv){
  String query = "UPDATE rendezvous SET lieu =\""+rv.getLieu()+"\",date=\""+rv.getDate()+"\",raison=\""+rv.getRaison()+"\"where id_rv="+rv.getId_rv()+"";    
  try {
            preparedStatement = connection.prepareStatement(query);
           
//            preparedStatement.setString(1, rv.getLieu());
//            preparedStatement.setString(2, rv.getDate());
//            preparedStatement.setString(3, rv.getRaison());
//            preparedStatement.setInt(4, id_rv);

     
            preparedStatement.executeUpdate();
             System.out.println("Update Done");
         } catch (SQLException ex) {
             System.out.println ("Probleme");
         }}
       
    public ObservableList<rendez_vous> readAllS() throws SQLException{
    ObservableList<rendez_vous> ClasseData = FXCollections.observableArrayList();
    statement=connection.createStatement();
    ResultSet rs=statement.executeQuery("select * from rendezvous");
    while (rs.next()) {                
               int id=rs.getInt(1);
               String login =rs.getString(2);
               String lieu = rs.getString(3);
               String date = rs.getString(4);
               String raison = rs.getString(5);
               rendez_vous rdv = new rendez_vous(id,login,lieu,date,raison);
               
     ClasseData.add(rdv);
     }
    return ClasseData;
    }
    
     public void SupprimerRv (int id_rv){
          
  String query = "DELETE FROM rendezvous where id_rv = "+id_rv;    
  try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Supprimer rendez vous");
                        alert1.setContentText("le rendez vous  " + id_rv + " a été supprimer avec succes");
                        Optional<ButtonType> answer1 = alert1.showAndWait();
             System.out.println("Delete Done");
         } catch (SQLException ex) {
             System.out.println ("Probleme");
         }
     }
     
      public List<rendez_vous> search(String t) throws SQLException {
        List<rendez_vous> rendez_vous = new ArrayList<>();
        rendez_vous = readAllS();
        List<rendez_vous> rv = rendez_vous.stream()
                .filter(a -> a.getLogin().contains(t))
                .collect(Collectors.toList());
        return rv;
      }

}

