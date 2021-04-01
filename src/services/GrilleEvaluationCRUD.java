/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.EvaluationMi;
import entities.GrilleEvaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.MyConnection;

/**
 *
 * @author Jihene
 */
public class GrilleEvaluationCRUD {
    
    private final Connection cnx;
    private PreparedStatement ste;
    
     public GrilleEvaluationCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
     
     public void ajouterGrilleEvaluation(GrilleEvaluation grille){
        String req ="INSERT INTO grille (id_enc,id_etu,mention,note,q1,q2,q3,q4,q5,q6,q7,q8)"
                +"values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            
            ste.setInt(1, grille.getId_enc());
            ste.setInt(2, grille.getId_etu());
            ste.setString(3, grille.getMention());
            ste.setInt(4, grille.getNote());
            ste.setString(5, grille.getQ1());
            ste.setString(6, grille.getQ2());
            ste.setString(7, grille.getQ3());
            ste.setString(8, grille.getQ4());
            ste.setString(9, grille.getQ5());
            ste.setString(10, grille.getQ6());
            ste.setString(11, grille.getQ7());
            ste.setString(12, grille.getQ8());
            
            
            ste.executeUpdate();
            System.out.println("grille ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme ajout grille");
            System.out.println(ex.getMessage());
            
        }
        
}
     
     
     public GrilleEvaluation consulterGrilleEvaluation() throws SQLException{
        GrilleEvaluation ge = null;
       int id = EvaluationMi.chosen;
           
           ResultSet rs = cnx.createStatement().executeQuery("Select * from grille where id="+id+"");
           
           if(rs.next()){
                ge =new GrilleEvaluation(rs.getInt("id"),rs.getInt("id_enc"),
                        rs.getInt("id_etu"),rs.getDate("date_r"),rs.getString("mention"),
                        rs.getInt("note"),rs.getString("q1"),rs.getString("q2"),
                        rs.getString("q3"),rs.getString("q4"),rs.getString("q5"),
                        rs.getString("q6"),rs.getString("q7"),rs.getString("q8") );     
              
           }
             System.out.println("grille consultée");
         
        
    
           return ge;
        
     }
     
     public void modifierGrilleEvaluatin(GrilleEvaluation grille, int idGrille){
        String req = "UPDATE grille SET mention=?,note=?,q1=?,q2=?,q3=?,"
                + "q4=?,q5=?,q6=?,q7=?,q8=? WHERE id= "+idGrille+"";
       try {
            ste = cnx.prepareStatement(req);
            ste.setString(1, grille.getMention());
            ste.setInt(2, grille.getNote());
            ste.setString(3, grille.getQ1());
            ste.setString(4, grille.getQ2());
            ste.setString(5, grille.getQ3());
            ste.setString(6, grille.getQ4());
            ste.setString(7, grille.getQ5());
            ste.setString(8, grille.getQ6());
            ste.setString(9, grille.getQ7());
            ste.setString(10, grille.getQ8());
            
            

            
            ste.executeUpdate();
            System.out.println("grille modifiée");
         } catch (SQLException ex) {
            System.out.println("Probléme modif");
            System.out.println(ex.getMessage());
         }
        
    }
     
    
}
