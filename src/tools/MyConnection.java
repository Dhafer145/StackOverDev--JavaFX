/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Jihene
 */
public class MyConnection {
    public String url ="jdbc:mysql://localhost:3306/bd_pfe";
    public String login="root";
    public String pwd ="";
    public Connection cnx;
    public static MyConnection ct;

    private MyConnection() {
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
    public static MyConnection getInstance(){
        if(ct == null)
            ct = new MyConnection();
        return ct;
        
    } 
    
    
}