/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;
import controls.*;

/**
 *
 * @author Mickaël
 */
public class Users {
    
    public String nom;
    private String prenom;
    private String datenaiss;
    
    private String pseudo ;
    
    Random r = new Random();
    int password1 = 1 + r.nextInt(100 - 1);
   
    private String password;
    private String defaultpass;
    
    public Users(String nom, String prenom, String datenaiss)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.datenaiss=datenaiss;
        
        this.pseudo= prenom.substring(0, 1).toLowerCase() + this.nom.replace(" ", "").toLowerCase();
        this.defaultpass= nom.replace(" ", "").toLowerCase()+prenom.replace(" ", "").toLowerCase()+password1++;
        this.password = controls.fonctions.encryptPassword(this.defaultpass);
    }

    public String getDefaultpass() {
        return defaultpass;
    }

    public void setDefaultpass(String defaultpass) {
        this.defaultpass = defaultpass;
    }

     /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the datenaiss
     */
    public String getDatenaiss() {
        return datenaiss;
    }

    /**
     * @param datenaiss the datenaiss to set
     */
    public void setDatenaiss(String datenaiss) {
        this.datenaiss = datenaiss;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the password1
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password1 the password1 to set
     */
  /*  public void setPassword(String password1) {
        this.password = password;
    }*/
    
    
}
