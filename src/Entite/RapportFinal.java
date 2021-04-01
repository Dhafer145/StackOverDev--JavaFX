/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author usp
 */
public class RapportFinal {
      private int id_RF ;
      
      private int id_encadrant;
      private int id_etudiant;
      private String nom_etudiant;
      private String fichier;
      private String plagiat ;

      
      
      
    public int getId_encadrant() {
        return id_encadrant;
    }

    public void setId_encadrant(int id_encadrant) {
        this.id_encadrant = id_encadrant;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public RapportFinal(int id_RF, int id_encadrant, int id_etudiant, String nom_etudiant, String fichier, String plagiat) {
        this.id_RF = id_RF;
        this.id_encadrant = id_encadrant;
        this.id_etudiant = id_etudiant;
        this.nom_etudiant = nom_etudiant;
        this.fichier = fichier;
        this.plagiat = plagiat;
    }

    
    
    public RapportFinal(int id_encadrant, int id_etudiant, String nom_etudiant, String fichier, String plagiat) {
        this.id_encadrant = id_encadrant;
        this.id_etudiant = id_etudiant;
        this.nom_etudiant = nom_etudiant;
        this.fichier = fichier;
        this.plagiat = plagiat;
    }
      
     

    public RapportFinal(int id_encadrant, int id_etudiant, String fichier, String plagiat) {
        this.id_encadrant = id_encadrant;
        this.id_etudiant = id_etudiant;
        this.fichier = fichier;
        this.plagiat = plagiat;
    }

    public RapportFinal(int id_RF, int id_encadrant, int id_etudiant, String fichier, String plagiat) {
        this.id_RF = id_RF;
        this.id_encadrant = id_encadrant;
        this.id_etudiant = id_etudiant;
        this.fichier = fichier;
        this.plagiat = plagiat;
    }

  

   public RapportFinal( String fichier, String plagiat) {
       
       this.fichier = fichier;
        this.plagiat = plagiat;
    }

    public RapportFinal(int id_RF, String fichier, String plagiat) {
        this.id_RF = id_RF;
        this.fichier = fichier;
        this.plagiat = plagiat;
    }

    public RapportFinal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

 

    public int getId_RF() {
        return id_RF;
    }

    public String getFichier() {
        return fichier;
    }

    public String getPlagiat() {
        return plagiat;
    }

    public void setId_RF(int id_RF) {
        this.id_RF = id_RF;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public void setPlagiat(String plageat) {
        this.plagiat = plageat;
    }

    @Override
    public String toString() {
        return "RapportFinal{" + "id_RF=" + id_RF + ", fichier=" + fichier + ", plagiat=" + plagiat + '}';
    }

  
      
    
}
