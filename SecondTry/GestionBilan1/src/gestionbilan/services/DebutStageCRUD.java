/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbilan.services;

import gestionbilan.entities.DebutStage;
import gestionbilan.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Islem Oueslati
 */
public class DebutStageCRUD {
    private Connection cnx;
    private PreparedStatement ste;

     public DebutStageCRUD() {
        cnx = MyConnection.getInstance().getConnection();
    }
    public void remplirBilan(DebutStage b) throws SQLException{
        String req ="INSERT INTO debutstage (Id_Debut,Motivation,Situation,Problematique,Apprentissages,Deadline,Talents,Ex1,Equipe,Ex2,Autonomie,Ex3,Resistance,Ex4,Organisation,Ex5,Initiative,Ex6,Qualité,Ex7,Contact,Moyen)"+"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try{
                ste = cnx.prepareStatement(req);
                ste.setInt(1, b.getId_Debut());
                ste.setString(2, b.getMotivation());
                ste.setString(1, b.getSituation());
                ste.setString(2, b.getProblematique());
                ste.setString(1, b.getApprentissages());
                ste.setString(2, b.getDeadline());
                ste.setString(1, b.getTalents());
                ste.setString(2, b.getEx1());
                ste.setString(1, b.getEquipe());
                ste.setString(2, b.getEx2());
                ste.setString(1, b.getAutonomie());
                ste.setString(2, b.getEx3());
                ste.setString(1, b.getResistance());
                ste.setString(2, b.getEx4());
                ste.setString(1, b.getOrganisation());
                ste.setString(2, b.getEx5());
                ste.setString(1, b.getInitiative());
                ste.setString(2, b.getEx6());
                ste.setString(1, b.getQualite());
                ste.setString(2, b.getEx7());
                ste.setString(1, b.getContact());
                ste.setString(2, b.getMoyen());
                ste.executeUpdate();
                System.out.println("Bilan Rempli");
            }
        
            catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
}}
