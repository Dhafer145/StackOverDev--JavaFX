/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package services;
import Entite.soutenance;
import tools.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author usp
 */
public class SoutenCRUD {
    
    private Connection cnx;
    private PreparedStatement ste;
    
   public void SoutenCRUD(soutenance so){
       cnx = myconnection.getInstance().getConnection();
       String req ="INSERT INTO presentation (non_president,non_encadrant,date_soutenance,salle)"+"values(?,?,?,?)";
       try {
           ste=cnx.prepareStatement(req);
           ste.setString(1,so.getNon_president());
           ste.setString(2,so.getNon_encadrant());
           ste.setString(3,so.getDate_soutenance());
           ste.setString(4,so.getSalle());
           ste.executeUpdate();
           System.out.println("soutenance ajoutée");
           
       }catch (SQLException e) {
           System.out.println("il y'a un problème");
           System.out.println(e.getMessage());
       }
   }
   
   
    
}
