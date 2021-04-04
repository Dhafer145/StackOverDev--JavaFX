/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javafx.collections.ObservableList;

/**
 *
 * @author dhiabenmabrouk
 */
public class rendez_vous {
   int id_rv;
   String login;
   String lieu;
   String date;
   String raison;
   Date date1;

    public rendez_vous(String login, String lieu, String date, String raison) {
        this.login = login;
        this.lieu = lieu;
        this.date = date;
        this.raison = raison;
    }
    

    public rendez_vous(int id_rv, String login, String lieu, String date, String raison) {
        this.id_rv = id_rv;
        this.login = login;
        this.lieu = lieu;
        this.date = date;
        this.raison = raison;
    }
    public rendez_vous(int id_rv, String login, String lieu, Date date, String raison) {
        this.id_rv = id_rv;
        this.login = login;
        this.lieu = lieu;
        this.date1 = date;
        this.raison = raison;
    }

    public rendez_vous(String lieu, String date, String raison) {
        this.lieu = lieu;
        this.date = date;
        this.raison = raison;
    }

    public rendez_vous(int id_rv) {
        this.id_rv = id_rv;
    }

    public rendez_vous() {
    }

 

   

   

    public int getId_rv() {
        return id_rv;
    }

    public void setId_rv(int id_rv) {
        this.id_rv = id_rv;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
    
    
    
     @Override
    public String toString() {
        return "rendez_vous{" + "id_rv=" + id_rv + ", login=" + login + ", lieu=" + lieu + ", date=" + date + ", raison=" + raison +'}';
    }
    
}

