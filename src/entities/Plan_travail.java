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
    private String backlog;
    private String sprints;
    
     public Plan_travail(){
    }
    
  public Plan_travail(int id_pt,String backlog, String sprints) {
        this.id_pt = id_pt;
        this.backlog = backlog;
        this.sprints = sprints;
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

    @Override
    public String toString() {
        return "Plan_travail{" + "id_pt=" + id_pt + ", backlog=" + backlog + ", sprints=" + sprints + '}';
    }
  
}
