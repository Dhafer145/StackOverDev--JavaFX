/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ramzuss
 */
public class Myconnexion {
 
    public String url ="jdbc:mysql://localhost:3306/bdpfe";
    public String login="root";
    public String pwd ="";
    public Connection cnx;
    public static Myconnexion ct;

    private Myconnexion() {
        try {
           cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Cnx etablie");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());
        }
    
    }
    public Connection getConnection(){
        return cnx;
    }
    public static Myconnexion getInstance(){
        if(ct == null)
            ct = new Myconnexion();
        return ct;
        
    } 
}


