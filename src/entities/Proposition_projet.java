/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Proposition_projet {
    
    private int id_sujet;
    private int id_user;
    private String nom_sujet;
    private String cahier_charge;
    private String validation_pp;
    private String description;
    private String commentaire_pp;
    
    public Proposition_projet(){
    }

    public Proposition_projet(String validation_pp, String commentaire_pp) {
        this.validation_pp = validation_pp;
        this.commentaire_pp = commentaire_pp;
    }

   
    
    
  public  Proposition_projet(int id_sujet, String nom_sujet, String cahier_charge ) {
        this.id_sujet = id_sujet;
        this.nom_sujet = nom_sujet;
        this.cahier_charge = cahier_charge; 
        this.validation_pp= validation_pp;
        this.description=description;
        this.id_user=id_user;
    }

    public Proposition_projet(int id_sujet, int id_user, String nom_sujet) {
        this.id_sujet = id_sujet;
        this.id_user = id_user;
        this.nom_sujet = nom_sujet;
    }
  
  

    public int getId_sujet() {
        return id_sujet;
    }

    public void setId_sujet(int id_sujet) {
        this.id_sujet = id_sujet;
    }

    public String getNom_sujet() {
        return nom_sujet;
    }

    public void setNom_sujet(String nom_sujet) {
        this.nom_sujet = nom_sujet;
    }

    public String getCahier_charge() {
        return cahier_charge;
    }

    public void setCahier_charge(String cahier_charge) {
        this.cahier_charge = cahier_charge;
    }

    public String getValidation_pp() {
        return validation_pp;
    }

    public void setValidation_pp(String validation_pp) {
        this.validation_pp = validation_pp;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCommentaire_pp() {
        return commentaire_pp;
    }

    public void setCommentaire_pp(String commentaire_pp) {
        this.commentaire_pp = commentaire_pp;
    }

    @Override
    public String toString() {
        return "Proposition_projet{" + "id_sujet=" + id_sujet + ", id_user=" + id_user + ", nom_sujet=" + nom_sujet + ", cahier_charge=" + cahier_charge + ", validation_pp=" + validation_pp + ", description=" + description + ", commentaire_pp=" + commentaire_pp + '}';
    }
    

    

    

   
    
    

}
