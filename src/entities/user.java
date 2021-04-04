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
public class user {
    protected int id_user;
    protected String user_name;
    protected String full_name;
     protected String email;
    protected String password;
      protected String confirm_p;
    protected String role;
    protected String adress;
   

    public user( String user_name, String full_name, String email, String password, String confirm_p, String role, String adress) {
        
        this.user_name = user_name;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.confirm_p = confirm_p;
        this.role = role;
        this.adress = adress;
       
    }

    public user() {
    }
    

    public user(String full_name) {
        this.full_name = full_name;
    }
    
    

    public user(String user_name, String email, String confirm_p) {
        this.user_name = user_name;
        this.email = email;
        this.confirm_p = confirm_p;
    }

    
    
   

   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_p() {
        return confirm_p;
    }

    public void setConfirm_p(String confirm_p) {
        this.confirm_p = confirm_p;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return   full_name ;
    }

    
     

    

   

  
   
   


}
