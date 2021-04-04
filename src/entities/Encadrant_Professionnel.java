/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ramzuss
 */
public class Encadrant_Professionnel extends user {
     private String nom_entreprise;

    public Encadrant_Professionnel(String user_name, String full_name, String email, String password, String confirm_p, String role, String adress) {
        super(user_name, full_name, email, password, confirm_p, role, adress);
    }

    public Encadrant_Professionnel(String nom_entreprise, String user_name, String full_name, String email, String password, String confirm_p, String role, String adress) {
        super(user_name, full_name, email, password, confirm_p, role, adress);
        this.nom_entreprise = nom_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    @Override
    public String toString() {
        return "Encadrant_Professionnel{"+super.toString() + "nom_entreprise=" + nom_entreprise + '}';
    }
   
    
}
