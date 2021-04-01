/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javafx.scene.control.TextField;

/**
 *
 * @author Jihene
 */
public class GrilleEvaluation {
    
    private int id_grille;
    private int id_enc;
    private int id_etu;
    public String nom_etudiant;
    public String nom_encadrant;

    
    private Date date_r;
    
    private String mention;
    private int note;
    
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;

    public GrilleEvaluation() {
    }

    public GrilleEvaluation(int id_grille, int id_enc, int id_etu, String nom_etudiant, String nom_encadrant, Date date_r, String mention, int note) {
        this.id_grille = id_grille;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.nom_etudiant = nom_etudiant;
        this.nom_encadrant = nom_encadrant;
        this.date_r = date_r;
        this.mention = mention;
        this.note = note;
    }

    
    
    public GrilleEvaluation(int id_grille, int id_enc, int id_etu, Date date_r, String mention, int note, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.id_grille = id_grille;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
        this.mention = mention;
        this.note = note;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

    public GrilleEvaluation(int id_grille, int id_enc, int id_etu, String nom_etudiant, Date date_r, String mention, int note) {
        this.id_grille = id_grille;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.nom_etudiant = nom_etudiant;
        this.date_r = date_r;
        this.mention = mention;
        this.note = note;
    }

    public GrilleEvaluation(int id_grille, int id_enc, int id_etu, Date date_r, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.id_grille = id_grille;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

    public GrilleEvaluation(int id_enc, int id_etu, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

    public GrilleEvaluation(int id_enc, int id_etu, String mention, int note, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.mention = mention;
        this.note = note;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

    public GrilleEvaluation(String mention, int note, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.mention = mention;
        this.note = note;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

   
    
    

    public int getId_grille() {
        return id_grille;
    }

    public void setId_grille(int id_grille) {
        this.id_grille = id_grille;
    }

    public int getId_enc() {
        return id_enc;
    }

    public void setId_enc(int id_enc) {
        this.id_enc = id_enc;
    }

    public int getId_etu() {
        return id_etu;
    }

    public String getNom_encadrant() {
        return nom_encadrant;
    }

    public void setNom_encadrant(String nom_encadrant) {
        this.nom_encadrant = nom_encadrant;
    }

    public void setId_etu(int id_etu) {
        this.id_etu = id_etu;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public Date getDate_r() {
        return date_r;
    }

    public void setDate_r(Date date_r) {
        this.date_r = date_r;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    
    
    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8;
    }
    
    
    
    
    
}
