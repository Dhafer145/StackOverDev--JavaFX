package tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Myconn {
public String url ="jdbc:mysql://localhost:3306/bd_pfe";
    public String login="root";
    public String pwd ="";
    public Connection cnx;
    public static Myconn ct;

    public Myconn() {
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
    public static Myconn getInstance(){
        if(ct == null)
            ct = new Myconn();
        return ct;
        
    }    


}
