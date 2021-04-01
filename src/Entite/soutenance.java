/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Objects;

/**
 *
 * @author usp
 */
public class soutenance {
    
    private int id_p ;
    private String non_etudiant;
    private String non_president;
    private String non_encadrant;
    private String date_soutenance;
    private String salle;

    public soutenance() {
    }

    public soutenance(int id_p, String non_etudiant, String non_president, String non_encadrant, String date_soutenance, String salle) {
        this.id_p = id_p;
        this.non_etudiant = non_etudiant;
        this.non_president = non_president;
        this.non_encadrant = non_encadrant;
        this.date_soutenance = date_soutenance;
        this.salle = salle;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getNon_etudiant() {
        return non_etudiant;
    }

    public void setNon_etudiant(String non_etudiant) {
        this.non_etudiant = non_etudiant;
    }

    public String getNon_president() {
        return non_president;
    }

    public void setNon_president(String non_president) {
        this.non_president = non_president;
    }

    public String getNon_encadrant() {
        return non_encadrant;
    }

    public void setNon_encadrant(String non_encadrant) {
        this.non_encadrant = non_encadrant;
    }

    public String getDate_soutenance() {
        return date_soutenance;
    }

    public void setDate_soutenance(String date_soutenance) {
        this.date_soutenance = date_soutenance;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "soutenance{" + "id_p=" + id_p + ", non_etudiant=" + non_etudiant + ", non_president=" + non_president + ", non_encadrant=" + non_encadrant + ", date_soutenance=" + date_soutenance + ", salle=" + salle + '}';
    }
    

}
    

    
