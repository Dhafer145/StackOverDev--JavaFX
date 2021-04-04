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
public class Plan_travail {
    private int id_pt;
    private int id_user;
    private String backlog;
    private String sprints;
    private String validation_pt;
    private String commentaire_pt;
    
     public Plan_travail(){
    }
     
      public Plan_travail(int id_pt, int id_user, String backlog, String sprints) {
        this.id_pt = id_pt;
        this.id_user = id_user;
        this.backlog = backlog;
        this.sprints = sprints;
    }
    
  public Plan_travail(int id_pt,String backlog, String sprints) {
        this.id_pt = id_pt;
        this.backlog = backlog;
        this.sprints = sprints;
    }

   

    public Plan_travail(String validation_pt, String commentaire_pt) {
        this.validation_pt = validation_pt;
        this.commentaire_pt = commentaire_pt;
    }
  
  
  

    public int getId_pt() {
        return id_pt;
    }

    public void setId_pt(int id_pt) {
        this.id_pt = id_pt;
    }

    public String getBacklog() {
        return backlog;
    }

    public void setBacklog(String backlog) {
        this.backlog = backlog;
    }

    public String getSprints() {
        return sprints;
    }

    public void setSprints(String sprints) {
        this.sprints = sprints;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getValidation_pt() {
        return validation_pt;
    }

    public void setValidation_pt(String validation_pt) {
        this.validation_pt = validation_pt;
    }

    public String getCommentaire_pt() {
        return commentaire_pt;
    }

    public void setCommentaire_pt(String commentaire_pt) {
        this.commentaire_pt = commentaire_pt;
    }

    @Override
    public String toString() {
        return "Plan_travail{" + "id_pt=" + id_pt + ", id_user=" + id_user + ", backlog=" + backlog + ", sprints=" + sprints + ", validation_pt=" + validation_pt + ", commentaire_pt=" + commentaire_pt + '}';
    }

    
    

    
  
}
