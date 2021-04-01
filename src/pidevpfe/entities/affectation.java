/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevpfe.entities;

/**
 *
 * @author ramzuss
 */
public class affectation {
    public String nomEtudiant;
    public String nomAcademique;
    public String nompro;

    public affectation(String nomEtudiant, String nomAcademique, String nompro) {
        this.nomEtudiant = nomEtudiant;
        this.nomAcademique = nomAcademique;
        this.nompro = nompro;
    }

    public affectation(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getNomAcademique() {
        return nomAcademique;
    }

    public void setNomAcademique(String nomAcademique) {
        this.nomAcademique = nomAcademique;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    
    @Override
    public String toString() {
        return "affectation{" + "nomEtudiant=" + nomEtudiant + ", nomAcademique=" + nomAcademique + ", nompro=" + nompro + '}';
    }
    
    
}
