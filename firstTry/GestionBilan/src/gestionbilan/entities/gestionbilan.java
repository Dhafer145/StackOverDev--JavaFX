/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbilan.entities;

import java.sql.Date;

/**
 *
 * @author Islem Oueslati
 */
public class gestionbilan {
    private int Id_Bilan;
    private int Id_Question;
    private int Id_Reponse;
    private String Titre_Descriptif;
    private Date Periode;
    private String Question;
    private String Reponse;

    public gestionbilan() {
    }

    public gestionbilan(int Id_Bilan, int Id_Question, int Id_Reponse, String Titre_Descriptif, Date Periode, String Question, String Reponse) {
        this.Id_Bilan = Id_Bilan;
        this.Id_Question = Id_Question;
        this.Id_Reponse = Id_Reponse;
        this.Titre_Descriptif = Titre_Descriptif;
        this.Periode = Periode;
        this.Question = Question;
        this.Reponse = Reponse;
    }

    public int getId_Bilan() {
        return Id_Bilan;
    }

    public void setId_Bilan(int Id_Bilan) {
        this.Id_Bilan = Id_Bilan;
    }

    public int getId_Question() {
        return Id_Question;
    }

    public void setId_Question(int Id_Question) {
        this.Id_Question = Id_Question;
    }

    public int getId_Reponse() {
        return Id_Reponse;
    }

    public void setId_Reponse(int Id_Reponse) {
        this.Id_Reponse = Id_Reponse;
    }

    public String getTitre_Descriptif() {
        return Titre_Descriptif;
    }

    public void setTitre_Descriptif(String Titre_Descriptif) {
        this.Titre_Descriptif = Titre_Descriptif;
    }

    public Date getPeriode() {
        return Periode;
    }

    public void setPeriode(Date Periode) {
        this.Periode = Periode;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String Reponse) {
        this.Reponse = Reponse;
    }

    @Override
    public String toString() {
        return "gestionbilan{" + "Id_Bilan=" + Id_Bilan + ", Id_Question=" + Id_Question + ", Id_Reponse=" + Id_Reponse + ", Titre_Descriptif=" + Titre_Descriptif + ", Periode=" + Periode + ", Question=" + Question + ", Reponse=" + Reponse + '}';
    }
    
    
}
