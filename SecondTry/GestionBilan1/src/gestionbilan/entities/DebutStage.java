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
public class DebutStage {
    private int Id_Debut;
    private String motivation;
    private String situation;
    private String problematique;
    private String apprentissages;
    private String deadline;
    private String talents;
    private String Ex1;
    private String Equipe;
    private String Ex2;
    private String Autonomie;
    private String Ex3;
    private String Resistance;
    private String Ex4;
    private String Organisation;
    private String Ex5;
    private String Initiative;
    private String Ex6;
    private String Qualite;
    private String Ex7;
    private String Contact;
    private String Moyen;

    public DebutStage() {
    }

    public DebutStage(int Id_Debut, String motivation, String situation, String problematique, String apprentissages, String deadline, String talents, String Ex1, String Equipe, String Ex2, String Autonomie, String Ex3, String Resistance, String Ex4, String Organisation, String Ex5, String Initiative, String Ex6, String Qualite, String Ex7, String Contact, String Moyen) {
        this.Id_Debut = Id_Debut;
        this.motivation = motivation;
        this.situation = situation;
        this.problematique = problematique;
        this.apprentissages = apprentissages;
        this.deadline = deadline;
        this.talents = talents;
        this.Ex1 = Ex1;
        this.Equipe = Equipe;
        this.Ex2 = Ex2;
        this.Autonomie = Autonomie;
        this.Ex3 = Ex3;
        this.Resistance = Resistance;
        this.Ex4 = Ex4;
        this.Organisation = Organisation;
        this.Ex5 = Ex5;
        this.Initiative = Initiative;
        this.Ex6 = Ex6;
        this.Qualite = Qualite;
        this.Ex7 = Ex7;
        this.Contact = Contact;
        this.Moyen = Moyen;
    }

    public int getId_Debut() {
        return Id_Debut;
    }

    public void setId_Debut(int Id_Debut) {
        this.Id_Debut = Id_Debut;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getProblematique() {
        return problematique;
    }

    public void setProblematique(String problematique) {
        this.problematique = problematique;
    }

    public String getApprentissages() {
        return apprentissages;
    }

    public void setApprentissages(String apprentissages) {
        this.apprentissages = apprentissages;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTalents() {
        return talents;
    }

    public void setTalents(String talents) {
        this.talents = talents;
    }

    public String getEx1() {
        return Ex1;
    }

    public void setEx1(String Ex1) {
        this.Ex1 = Ex1;
    }

    public String getEquipe() {
        return Equipe;
    }

    public void setEquipe(String Equipe) {
        this.Equipe = Equipe;
    }

    public String getEx2() {
        return Ex2;
    }

    public void setEx2(String Ex2) {
        this.Ex2 = Ex2;
    }

    public String getAutonomie() {
        return Autonomie;
    }

    public void setAutonomie(String Autonomie) {
        this.Autonomie = Autonomie;
    }

    public String getEx3() {
        return Ex3;
    }

    public void setEx3(String Ex3) {
        this.Ex3 = Ex3;
    }

    public String getResistance() {
        return Resistance;
    }

    public void setResistance(String Resistance) {
        this.Resistance = Resistance;
    }

    public String getEx4() {
        return Ex4;
    }

    public void setEx4(String Ex4) {
        this.Ex4 = Ex4;
    }

    public String getOrganisation() {
        return Organisation;
    }

    public void setOrganisation(String Organisation) {
        this.Organisation = Organisation;
    }

    public String getEx5() {
        return Ex5;
    }

    public void setEx5(String Ex5) {
        this.Ex5 = Ex5;
    }

    public String getInitiative() {
        return Initiative;
    }

    public void setInitiative(String Initiative) {
        this.Initiative = Initiative;
    }

    public String getEx6() {
        return Ex6;
    }

    public void setEx6(String Ex6) {
        this.Ex6 = Ex6;
    }

    public String getQualite() {
        return Qualite;
    }

    public void setQualite(String Qualite) {
        this.Qualite = Qualite;
    }

    public String getEx7() {
        return Ex7;
    }

    public void setEx7(String Ex7) {
        this.Ex7 = Ex7;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getMoyen() {
        return Moyen;
    }

    public void setMoyen(String Moyen) {
        this.Moyen = Moyen;
    }

    @Override
    public String toString() {
        return "DebutStage{" + "Id_Debut=" + Id_Debut + ", motivation=" + motivation + ", situation=" + situation + ", problematique=" + problematique + ", apprentissages=" + apprentissages + ", deadline=" + deadline + ", talents=" + talents + ", Ex1=" + Ex1 + ", Equipe=" + Equipe + ", Ex2=" + Ex2 + ", Autonomie=" + Autonomie + ", Ex3=" + Ex3 + ", Resistance=" + Resistance + ", Ex4=" + Ex4 + ", Organisation=" + Organisation + ", Ex5=" + Ex5 + ", Initiative=" + Initiative + ", Ex6=" + Ex6 + ", Qualite=" + Qualite + ", Ex7=" + Ex7 + ", Contact=" + Contact + ", Moyen=" + Moyen + '}';
    }

    public String Autonomie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}