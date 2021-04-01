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
      private String fichier;
      private String plagiat ;

  

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
