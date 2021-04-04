/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.EvaluationMi;
import tools.Myconn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jihene
 */
public class EvaluationMiCRUD {
    
    private final Connection cnx;
    private PreparedStatement ste;
    
     public EvaluationMiCRUD() {
        cnx = Myconn.getInstance().getConnection();
    }
    
     public void ajouterEvaluationMi(EvaluationMi evaluation){
        String req ="INSERT INTO evaluation (id_enc,id_etu,ponctualite,comm1,integration,comm2,travail,comm3,competence,comm4,eg,comm5)"
                +"values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            
            ste.setInt(1, evaluation.getId_enc());
            ste.setInt(2, evaluation.getId_etu());
            ste.setBoolean(3, evaluation.isPonctualite());
            ste.setString(4, evaluation.getComm1());
            ste.setBoolean(5, evaluation.isIntegration());
            ste.setString(6, evaluation.getComm2());
            ste.setBoolean(7, evaluation.isTravail());
            ste.setString(8, evaluation.getComm3());
            ste.setBoolean(9, evaluation.isCompetence());
            ste.setString(10, evaluation.getComm4());
            ste.setBoolean(11, evaluation.isEg());
            ste.setString(12, evaluation.getComm5());
            
            
            ste.executeUpdate();
            System.out.println("evaluation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme ajout");
            System.out.println(ex.getMessage());
            
        }
        
}
     
     public void modifierEvaluationMi(EvaluationMi evaluation, int idEvaluation){
        String req = "UPDATE evaluation SET ponctualite=?,comm1=?,integration=?,comm2=?,travail=?,"
                + "comm3=?,competence=?,comm4=?,eg=?,comm5=? WHERE id= ?";
       try {
            ste = cnx.prepareStatement(req);
            ste.setBoolean(1, evaluation.isPonctualite());
            ste.setString(2, evaluation.getComm1());
            ste.setBoolean(3, evaluation.isIntegration());
            ste.setString(4, evaluation.getComm2());
            ste.setBoolean(5, evaluation.isTravail());
            ste.setString(6, evaluation.getComm3());
            ste.setBoolean(7, evaluation.isCompetence());
            ste.setString(8, evaluation.getComm4());
            ste.setBoolean(9, evaluation.isEg());
            ste.setString(10, evaluation.getComm5());
            ste.setInt(11, idEvaluation);
            
            ste.executeUpdate();
            System.out.println("evaluation modifiée");
         } catch (SQLException ex) {
            System.out.println("Probléme modif");
            System.out.println(ex.getMessage());
         }
        
    }
     
     public EvaluationMi consulterEvaluationMi() throws SQLException{
        EvaluationMi ev = null;
       int id = EvaluationMi.chosen;
           
           ResultSet rs = cnx.createStatement().executeQuery("Select * from evaluation where id="+id+"");
           
           if(rs.next()){
                ev =new EvaluationMi(rs.getInt("id"),rs.getInt("id_enc"),
                        rs.getInt("id_etu"),rs.getDate("date_r"),rs.getBoolean("ponctualite"),
                        rs.getString("comm1"),rs.getBoolean("integration"),rs.getString("comm2"),
                        rs.getBoolean("travail"),rs.getString("comm3"),rs.getBoolean("competence"),
                        rs.getString("comm4"),rs.getBoolean("eg"),rs.getString("comm5") );     
              
           }
             System.out.println("evaluation consultée");
         
        
    
           return ev;
        
     }
}