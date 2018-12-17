/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jacques
 */
public class ProgrammeurBean {

    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String responsable;  
    private String hobby;
    private String date_naiss; // a modifier créer le type Date
    private String date_emb;
    
    public ProgrammeurBean() {
    }

    @Override
    public String toString() {
        String affichage = this.getMatricule() + " " + this.getNom() + " " + this.getPrenom()
                + " " + this.getAdresse() + " " + this.getPseudo() + " " + this.getResponsable()
                + " " + this.getHobby() + " " + this.getDate_naiss() + " " + this.getDate_emb() + "\n";
        return affichage;
    }
    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }
    
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
 
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getDate_emb() {
        return date_emb;
    }

    public void setDate_emb(String date_emb) {
        this.date_emb = date_emb;
    }

}
