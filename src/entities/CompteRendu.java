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
    private int id_cr;
    private int id_user;
    private String commentaire ;
    private String fichier;
    private String validation_cr;
    private String commentaire_encadrant;
    

//    public CompteRendu(String Commenataire, String fichier) {
//        this.commenataire = Commenataire;
//        this.fichier = fichier;
//    }

    public CompteRendu() {
    }

    public CompteRendu(int id_cr, int id_user, String fichier, String commentaire) {
        this.id_cr = id_cr;
        this.id_user = id_user;
        this.commentaire = commentaire;
        this.fichier = fichier;
        
    }

   







    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public int getId_cr() {
        return id_cr;
    }

    public void setId_cr(int id_cr) {
        this.id_cr = id_cr;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getValidation_cr() {
        return validation_cr;
    }

    public void setValidation_cr(String validation_cr) {
        this.validation_cr = validation_cr;
    }

    public String getCommentaire_encadrant() {
        return commentaire_encadrant;
    }

    public void setCommentaire_encadrant(String commentaire_encadrant) {
        this.commentaire_encadrant = commentaire_encadrant;
    }

    @Override
    public String toString() {
        return "CompteRendu{" + "id_cr=" + id_cr + ", id_user=" + id_user + ", commentaire=" + commentaire + ", fichier=" + fichier + ", validation_cr=" + validation_cr + ", commentaire_encadrant=" + commentaire_encadrant + '}';
    }

   
    
    

    

  

 


  


    
    


}
