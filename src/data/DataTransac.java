/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myutil.Constantes;

/**
 *
 * @author Jacques
 */
public class DataTransac implements ActionsBD{

    private Connection dbConn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<ProgrammeurBean> listeProgrammeurs;
    private ProgrammeurBean prog;
    private int erreur;

    /**
     * Le constructeur permet d'initialiser la connexion
     */
    public DataTransac() {
        try {
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    /**
     * Lance la requête passée en paramètre et retourne le ResultSet
     * correspondant à cette requête
     *
     * @param req La requête SQL que l'on souhaite exécuter
     * @return rs Une variable de type ResultSet
     */
    public ResultSet getResultSet(String req) {
        try {
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(req);
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return rs;
    }

    /**
     * Cette méthode récupère toutes les infos d'un programmeur et retourne une
     * liste de l'ensemble des programmeurs
     *
     * @return listeProgrammeurs Une variable de type ArryList
     */
    public ArrayList getProgrammeurs() {
        rs = this.getResultSet(Constantes.SELECT_ALL);
        listeProgrammeurs = new ArrayList<>();
        try {
            while (rs.next()) {
                prog = new ProgrammeurBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDate_naiss(rs.getDate("DATE_NAISS"));
                prog.setDate_emb(rs.getDate("DATE_EMB"));
                listeProgrammeurs.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return listeProgrammeurs;
    }

    /**
     * Cette méthode récupère toutes les infos d'un programmeur et retourne ce
     * programmeur sous la forme d'un Java Bean Cette méthode est utilisée pour
     * rechercher un progammeur via son matricule
     *
     * @param matricule Le matricule saisi par l'utilisateur pour lancer la recherche
     * @return prog Une variable de type ProgrammeurBean
     *
     */
    public ProgrammeurBean getProgrammeur(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.SELECT_UNIQUE);
            pstmt.setString(1, matricule);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                prog = new ProgrammeurBean();
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setNom(rs.getString("NOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDate_naiss(rs.getDate("DATE_NAISS"));
                prog.setDate_emb(rs.getDate("DATE_EMB"));
            }
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return prog;
    }

    /**
     * Cette méthode permet de construire la chaîne de caractères qui sera
     * affichée lorsqu'on choisit Programmeur - Afficher - Tous
     *
     * @return listeProg Une variable de type String
     *
     */
    public String afficherProgrammeurs() {
        String listeProg = "";
        listeProgrammeurs = this.getProgrammeurs();
        for (ProgrammeurBean progr : listeProgrammeurs) {
            listeProg = listeProg + progr;
        }
        return listeProg;
    }
    
    public int modifierProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb){
        try {
            String date_naiss = Adate_naiss + "-" + Mdate_naiss + "-" + Jdate_naiss;
            String date_emb = Adate_emb + "-" + Mdate_emb + "-" + Jdate_emb;
            pstmt = dbConn.prepareStatement(Constantes.UPDATE_UNIQUE);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, adresse);
            pstmt.setString(4, pseudo);
            pstmt.setString(5, responsable);
            pstmt.setString(6, hobby);
            pstmt.setString(7, date_naiss);
            pstmt.setString(8, date_emb);            
            pstmt.setString(9, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur= 1 ;
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }
    
    public int supprimerProgrammeur(String matricule){
        try {
            pstmt = dbConn.prepareStatement(Constantes.DELETE_UNIQUE);
            pstmt.setString(1, matricule);
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }
    
    public int ajouterProgrammeur(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, String Jdate_naiss, String Mdate_naiss, String Adate_naiss, String Jdate_emb, String Mdate_emb, String Adate_emb){
        try {
            String date_naiss = Adate_naiss + "-" + Mdate_naiss + "-" + Jdate_naiss;
            String date_emb = Adate_emb + "-" + Mdate_emb + "-" + Jdate_emb;
            pstmt = dbConn.prepareStatement(Constantes.INSERT_UNIQUE);          
            pstmt.setString(1, matricule);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, adresse);
            pstmt.setString(5, pseudo);
            pstmt.setString(6, responsable);
            pstmt.setString(7, hobby);
            pstmt.setString(8, date_naiss);
            pstmt.setString(9, date_emb);  
            pstmt.executeUpdate();
            erreur = 0;
        } catch (SQLException ex) {
            erreur = 1;
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return erreur;
    }

    /**
     * Cette méthode permet de libérer les ressources liées à la base de données
     * *
     */
    public void fermerRessources() {
        if (dbConn != null) {
            try {
                dbConn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                dbConn = null;
            } catch (SQLException ex) {
                Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
