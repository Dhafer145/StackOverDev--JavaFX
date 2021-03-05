/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.EvaluationMi;
import tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jihene
 */
public class EvaluationMiCRUD {
    
    private Connection cnx;
    private PreparedStatement ste;
    
     public EvaluationMiCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
     public void ajouterEvaluationMi(EvaluationMi ev){
        String req ="INSERT INTO evaluation_miparcour (ponctualite1,ponctualite2,commentaire1,"
                + "integration1,integration2,integration3,commentaire2,travail1,travail2,travail3,travail4,"
                + "commentaire3,competence1,competence2,competence3,competence4,competence5,competence6,"
                + "commentaire4,evaluation_globale,commentaire5)"
                +"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setBoolean(1, ev.isPonctualite1());
            ste.setBoolean(2, ev.isPonctualite2());
            ste.setString(3, ev.getCommentaire1());
            ste.setBoolean(4, ev.isIntegration1());
            ste.setBoolean(5, ev.isIntegration2());
            ste.setBoolean(6, ev.isIntegration3());
            ste.setString(7, ev.getCommentaire2());
            ste.setBoolean(8, ev.isTravail1());
            ste.setBoolean(9, ev.isTravail2());
            ste.setBoolean(10, ev.isTravail3());
            ste.setBoolean(11, ev.isTravail4());
            ste.setString(12, ev.getCommentaire3());
            ste.setBoolean(13, ev.isCompetence1());
            ste.setBoolean(14, ev.isCompetence2());
            ste.setBoolean(15, ev.isCompetence3());
            ste.setBoolean(16, ev.isCompetence4());
            ste.setBoolean(17, ev.isCompetence5());
            ste.setBoolean(18, ev.isCompetence6());
            ste.setString(19, ev.getCommentaire4());
            ste.setBoolean(20, ev.isEvaluation_globale());
            ste.setString(21, ev.getCommentaire5());
            
            
            ste.executeUpdate();
            System.out.println("evaluation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
}
     
     
     
}
