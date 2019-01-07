package data;

import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pauli
 */
public interface ActionsBD {
    public ResultSet getResultSet(String req);
    public ArrayList getProgrammeurs();
    public ProgrammeurBean getProgrammeur(String matricule);
    public String afficherProgrammeurs();
    public int modifierProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb);
    public int supprimerProgrammeur(String matricule);
    public int ajouterProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb);
    public void fermerRessources();
}
