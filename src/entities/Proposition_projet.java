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
    private String nom_sujet;
    private byte[] cahier_charge;
    private Boolean validation_pp;
    private String description;
    
    public Proposition_projet(){
    }
    
  public  Proposition_projet(int id_sujet, String nom_sujet, byte[] cahier_charge ) {
        this.id_sujet = id_sujet;
        this.nom_sujet = nom_sujet;
        this.cahier_charge = cahier_charge; 
        this.validation_pp= validation_pp;
        this.description=description;
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

    public byte[] getCahier_charge() {
        return cahier_charge;
    }

    public void setCahier_charge(byte[] cahier_charge) {
        this.cahier_charge = cahier_charge;
    }

    public Boolean getValidation_pp() {
        return validation_pp;
    }

    public void setValidation_pp(Boolean validation_pp) {
        this.validation_pp = validation_pp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Proposition_projet{" + "id_sujet=" + id_sujet + ", nom_sujet=" + nom_sujet + ", cahier_charge=" + cahier_charge + ", description=" + description + '}';
    }
    
    

}
