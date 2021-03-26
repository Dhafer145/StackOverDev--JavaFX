package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CompteRendu {
    private String Commenataire ;
    private String fichier;

    public CompteRendu(String Commenataire, String fichier) {
        this.Commenataire = Commenataire;
        this.fichier = fichier;
    }







    public String getCommenataire() {
        return Commenataire;
    }

    public void setCommenataire(String Commenataire) {
        this.Commenataire = Commenataire;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "CompteRendu{" + "Commenataire=" + Commenataire + ", fichier=" + fichier + '}';
    }

 


  


    
    


}
