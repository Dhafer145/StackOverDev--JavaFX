/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class Journal_projet {
    private int id_user;
    private int id_jp;
    private String date;
    private String tache;
    private String avis;
   
    
    public Journal_projet(){
    }

    public Journal_projet(int id_jp, String date, String tache, String avis) {
        this.id_jp = id_jp;
        this.date = date;
        this.tache = tache;
        this.avis = avis;
       
    }

    public Journal_projet(int id_user, int id_jp, String date, String tache, String avis) {
        this.id_user = id_user;
        this.id_jp = id_jp;
        this.date = date;
        this.tache = tache;
        this.avis = avis;
    }

    
    
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_jp() {
        return id_jp;
    }

    public void setId_jp(int id_jp) {
        this.id_jp = id_jp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Journal_projet{" + "id_user=" + id_user + ", id_jp=" + id_jp + ", date=" + date + ", tache=" + tache + ", avis=" + avis + '}';
    }
    


    
    
    

    
}
