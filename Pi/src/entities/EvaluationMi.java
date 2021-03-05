/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jihene
 */
public class EvaluationMi {
    
    private int id_ev_mi;
    private int id_user;
    
    private boolean ponctualite1;
    private boolean ponctualite2;
    
    private String commentaire1;
    
    private boolean integration1;
    private boolean integration2;
    private boolean integration3;
    
    private String commentaire2;
    
    private boolean travail1;
    private boolean travail2;
    private boolean travail3;
    private boolean travail4;
    
    private String commentaire3;
    
    private boolean competence1;
    private boolean competence2;
    private boolean competence3;
    private boolean competence4;
    private boolean competence5;
    private boolean competence6;
    
    private String commentaire4;
    
    private boolean evaluation_globale;
    
    private String commentaire5;

    public EvaluationMi() {
    }

    public EvaluationMi(int id_ev_mi, int id_user, boolean ponctualite1, boolean ponctualite2, String commentaire1, boolean integration1, boolean integration2, boolean integration3, String commentaire2, boolean travail1, boolean travail2, boolean travail3, boolean travail4, String commentaire3, boolean competence1, boolean competence2, boolean competence3, boolean competence4, boolean competence5, boolean competence6, String commentaire4, boolean evaluation_globale, String commentaire5) {
        this.id_ev_mi = id_ev_mi;
        this.id_user = id_user;
        this.ponctualite1 = ponctualite1;
        this.ponctualite2 = ponctualite2;
        this.commentaire1 = commentaire1;
        this.integration1 = integration1;
        this.integration2 = integration2;
        this.integration3 = integration3;
        this.commentaire2 = commentaire2;
        this.travail1 = travail1;
        this.travail2 = travail2;
        this.travail3 = travail3;
        this.travail4 = travail4;
        this.commentaire3 = commentaire3;
        this.competence1 = competence1;
        this.competence2 = competence2;
        this.competence3 = competence3;
        this.competence4 = competence4;
        this.competence5 = competence5;
        this.competence6 = competence6;
        this.commentaire4 = commentaire4;
        this.evaluation_globale = evaluation_globale;
        this.commentaire5 = commentaire5;
    }

    public EvaluationMi(boolean ponctualite1, boolean ponctualite2, String commentaire1, boolean integration1, boolean integration2, boolean integration3, String commentaire2, boolean travail1, boolean travail2, boolean travail3, boolean travail4, String commentaire3, boolean competence1, boolean competence2, boolean competence3, boolean competence4, boolean competence5, boolean competence6, String commentaire4, boolean evaluation_globale, String commentaire5) {
        this.ponctualite1 = ponctualite1;
        this.ponctualite2 = ponctualite2;
        this.commentaire1 = commentaire1;
        this.integration1 = integration1;
        this.integration2 = integration2;
        this.integration3 = integration3;
        this.commentaire2 = commentaire2;
        this.travail1 = travail1;
        this.travail2 = travail2;
        this.travail3 = travail3;
        this.travail4 = travail4;
        this.commentaire3 = commentaire3;
        this.competence1 = competence1;
        this.competence2 = competence2;
        this.competence3 = competence3;
        this.competence4 = competence4;
        this.competence5 = competence5;
        this.competence6 = competence6;
        this.commentaire4 = commentaire4;
        this.evaluation_globale = evaluation_globale;
        this.commentaire5 = commentaire5;
    }
    
    
    
    

    public int getId_ev_mi() {
        return id_ev_mi;
    }

    public void setId_ev_mi(int id_ev_mi) {
        this.id_ev_mi = id_ev_mi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean isPonctualite1() {
        return ponctualite1;
    }

    public void setPonctualite1(boolean ponctualite1) {
        this.ponctualite1 = ponctualite1;
    }

    public boolean isPonctualite2() {
        return ponctualite2;
    }

    public void setPonctualite2(boolean ponctualite2) {
        this.ponctualite2 = ponctualite2;
    }

    public String getCommentaire1() {
        return commentaire1;
    }

    public void setCommentaire1(String commentaire1) {
        this.commentaire1 = commentaire1;
    }

    public boolean isIntegration1() {
        return integration1;
    }

    public void setIntegration1(boolean integration1) {
        this.integration1 = integration1;
    }

    public boolean isIntegration2() {
        return integration2;
    }

    public void setIntegration2(boolean integration2) {
        this.integration2 = integration2;
    }

    public boolean isIntegration3() {
        return integration3;
    }

    public void setIntegration3(boolean integration3) {
        this.integration3 = integration3;
    }

    public String getCommentaire2() {
        return commentaire2;
    }

    public void setCommentaire2(String commentaire2) {
        this.commentaire2 = commentaire2;
    }

    public boolean isTravail1() {
        return travail1;
    }

    public void setTravail1(boolean travail1) {
        this.travail1 = travail1;
    }

    public boolean isTravail2() {
        return travail2;
    }

    public void setTravail2(boolean travail2) {
        this.travail2 = travail2;
    }

    public boolean isTravail3() {
        return travail3;
    }

    public void setTravail3(boolean travail3) {
        this.travail3 = travail3;
    }

    public boolean isTravail4() {
        return travail4;
    }

    public void setTravail4(boolean travail4) {
        this.travail4 = travail4;
    }

    public String getCommentaire3() {
        return commentaire3;
    }

    public void setCommentaire3(String commentaire3) {
        this.commentaire3 = commentaire3;
    }

    public boolean isCompetence1() {
        return competence1;
    }

    public void setCompetence1(boolean competence1) {
        this.competence1 = competence1;
    }

    public boolean isCompetence2() {
        return competence2;
    }

    public void setCompetence2(boolean competence2) {
        this.competence2 = competence2;
    }

    public boolean isCompetence3() {
        return competence3;
    }

    public void setCompetence3(boolean competence3) {
        this.competence3 = competence3;
    }

    public boolean isCompetence4() {
        return competence4;
    }

    public void setCompetence4(boolean competence4) {
        this.competence4 = competence4;
    }

    public boolean isCompetence5() {
        return competence5;
    }

    public void setCompetence5(boolean competence5) {
        this.competence5 = competence5;
    }

    public boolean isCompetence6() {
        return competence6;
    }

    public void setCompetence6(boolean competence6) {
        this.competence6 = competence6;
    }

    public String getCommentaire4() {
        return commentaire4;
    }

    public void setCommentaire4(String commentaire4) {
        this.commentaire4 = commentaire4;
    }

    public boolean isEvaluation_globale() {
        return evaluation_globale;
    }

    public void setEvaluation_globale(boolean evaluation_globale) {
        this.evaluation_globale = evaluation_globale;
    }

    public String getCommentaire5() {
        return commentaire5;
    }

    public void setCommentaire5(String commentaire5) {
        this.commentaire5 = commentaire5;
    }

    @Override
    public String toString() {
        return "EvaluationMi{" + "id_ev_mi=" + id_ev_mi + ", id_user=" + id_user + ", ponctualite1=" + ponctualite1 + ", ponctualite2=" + ponctualite2 + ", commentaire1=" + commentaire1 + ", integration1=" + integration1 + ", integration2=" + integration2 + ", integration3=" + integration3 + ", commentaire2=" + commentaire2 + ", travail1=" + travail1 + ", travail2=" + travail2 + ", travail3=" + travail3 + ", travail4=" + travail4 + ", commentaire3=" + commentaire3 + ", competence1=" + competence1 + ", competence2=" + competence2 + ", competence3=" + competence3 + ", competence4=" + competence4 + ", competence5=" + competence5 + ", competence6=" + competence6 + ", commentaire4=" + commentaire4 + ", evaluation_globale=" + evaluation_globale + ", commentaire5=" + commentaire5 + '}';
    }

    
    
    
    
    

   
    
}
