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
public class Etudiant extends user {
    
    private String debut_stage;
    private String nom_faculte;

   
    public Etudiant(String debut_stage) {
       
        this.debut_stage = debut_stage;
    }
    
    public Etudiant(String user_name, String full_name, String email, String password, String confirm_p, String role, String adress) {
        super(user_name, full_name, email, password, confirm_p, role, adress);
    }

    public Etudiant(String debut_stage, String nom_faculte, String user_name, String full_name, String email, String password, String confirm_p, String role, String adress) {
        super(user_name, full_name, email, password, confirm_p, role, adress);
        this.debut_stage = debut_stage;
        this.nom_faculte = nom_faculte;
    }

   

    
    
    public String getDebut_stage() {
        return debut_stage;
    }

    public void setDebut_stage(String debut_stage) {
        this.debut_stage = debut_stage;
    }

    public String getNom_faculte() {
        return nom_faculte;
    }

    public void setNom_faculte(String nom_faculte) {
        this.nom_faculte = nom_faculte;
    }

    @Override
    public String toString() {
        
        return "Etudiant{" +super.toString()+ "debut_stage=" + debut_stage + ", nom_faculte=" + nom_faculte + '}';
    }
    

    
  
    
    
    
}
