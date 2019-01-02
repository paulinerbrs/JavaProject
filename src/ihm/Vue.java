/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import data.DataTransac;
import data.ProgrammeurBean;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jacques
 */
public class Vue extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuProgrammeur;
    private JMenu menuAfficher;
    private JMenu menuAction;
    private JMenu test2;
    private JMenuItem itemModifier;
    private JMenuItem itemSupprimer;
    private JMenuItem itemAjouter;
    private JMenuItem itemTous;
    private JMenuItem itemQuitter;

    // Déclaration des attributs
    // L'initialisation se fera "en local" dans des méthodes        
    private JButton btnAfficherTous;
    private JButton btnRecherche;
    private JButton btnAjouter;
    private JLabel labelMatr;
    private JTextField champMatr;
    private JTextArea zoneAffichageProgrammeurs;
    private JPanel pane;
    private JScrollPane scroll;
    private ProgrammeurBean progrBean;
    private String contenuTextArea;
    private DataTransac dt;
    
    //form ajout prog
    private JPanel panel;
    private JButton btnRechercher;
    private JButton btnReinitialiser;
    private JButton btnValider;
    private JButton btnAnnuler;
    private JLabel labelMatricule;
    private JTextField champMatricule; 
    private JLabel labelNom;
    private JTextField champNom; 
    private JLabel labelPrenom;
    private JTextField champPrenom; 
    private JLabel labelAdresse;
    private JTextField champAdresse; 
    private JLabel labelPseudo;
    private JTextField champPseudo; 
    private JLabel labelResponsable;
    private JTextField champResponsable; 
    private JLabel labelHobby;
    private JTextField champHobby; 
    private JLabel labelDate_naiss;
    private JTextField champDate_naiss; 
    private JLabel labelDate_emb;
    private JTextField champDate_emb;

    public void init(){ 
        menuBar = new JMenuBar();
        menuProgrammeur = new JMenu("Programmeur");
        menuAfficher = new JMenu("Afficher");
        menuAction = new JMenu("Action");
        itemModifier = new JMenuItem("Modifier");
        itemSupprimer = new JMenuItem("Supprimer");
        itemAjouter = new JMenuItem("Ajouter");
        itemTous = new JMenuItem("Tous");
        itemQuitter = new JMenuItem("Quitter");
        itemTous.addActionListener(this);
        itemModifier.addActionListener(this);
        itemSupprimer.addActionListener(this);
        itemAjouter.addActionListener(this);
        itemQuitter.addActionListener(this);
        this.menuAfficher.add(itemTous);
        this.menuProgrammeur.add(this.menuAfficher);
        this.menuProgrammeur.add(itemModifier);  
        this.menuProgrammeur.add(itemSupprimer);  
        this.menuProgrammeur.add(itemAjouter);
        this.menuAction.add(itemQuitter);
        this.menuBar.add(menuProgrammeur);
        this.menuBar.add(menuAction);
        this.setJMenuBar(menuBar);
        
        this.ajout();
        
        /**
         * Par défaut, notre frame n'est pas visible
         * Il faut donc forcer la visibilité à "true"
         */
        this.setVisible(true);
        this.setTitle("GesProg");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        setBounds(10, 10, 600, 300);
    }
    
    public void display(){        
        pane = new JPanel(); // Création d'un panel pour gérer les widgets
        btnAfficherTous = new JButton("Afficher Tous");
        btnRecherche = new JButton("Rechercher");
        btnAjouter = new JButton("Ajouter");
        labelMatr = new JLabel("matricule");
        champMatr = new JTextField();
        champMatr.setColumns(10);
        zoneAffichageProgrammeurs = new JTextArea();

        /** Tous les widgets sont placés sur le panel
         * Et après le panel est "posé" sur notre frame de base
         */        
        pane.add(btnAfficherTous);
        pane.add(labelMatr);
        pane.add(champMatr);
        pane.add(btnRecherche);
        pane.add(btnAjouter);

        zoneAffichageProgrammeurs = new JTextArea(10, 50);
        scroll = new JScrollPane(zoneAffichageProgrammeurs);
        pane.add(scroll);

        btnAfficherTous.addActionListener(this);
        btnRecherche.addActionListener(this);
        btnAjouter.addActionListener(this);

        this.add(pane); // Ajout du panel à notre frame de base
    }
    
    public void ajout(){
        panel = new JPanel();
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValider = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        labelMatricule = new JLabel("Matricule");
        champMatricule = new JTextField();
        champMatricule.setColumns(10);
        labelNom = new JLabel("Nom");
        champNom = new JTextField();
        champNom.setColumns(10);
        labelPrenom = new JLabel("Prénom");
        champPrenom = new JTextField();
        champPrenom.setColumns(10);
        labelAdresse = new JLabel("Adresse");
        champAdresse = new JTextField();
        champAdresse.setColumns(10);
        labelPseudo = new JLabel("Pseudo");
        champPseudo = new JTextField();
        champPseudo.setColumns(10);
        labelResponsable = new JLabel("Responsable");
        champResponsable = new JTextField();
        champResponsable.setColumns(10);
        labelHobby = new JLabel("Hobby");
        champHobby = new JTextField();
        champHobby.setColumns(10);
        labelDate_naiss = new JLabel("Date de naissance");
        champDate_naiss = new JTextField();
        champDate_naiss.setColumns(10);
        labelDate_emb = new JLabel("Date d'embauche");
        champDate_emb = new JTextField();
        champDate_emb.setColumns(10);
        
        /** Tous les widgets sont placés sur le panel
         * Et après le panel est "posé" sur notre frame de base
         */        
        panel.add(btnRechercher);
        panel.add(btnReinitialiser);
        panel.add(btnValider);
        panel.add(btnAnnuler);
        panel.add(labelMatricule);
        panel.add(champMatricule);
        panel.add(labelNom);
        panel.add(champNom);
        panel.add(labelPrenom);
        panel.add(champPrenom);
        panel.add(labelAdresse);
        panel.add(champAdresse);
        panel.add(labelPseudo);
        panel.add(champPseudo);
        panel.add(labelResponsable);
        panel.add(champResponsable);
        panel.add(labelHobby);
        panel.add(champHobby);
        panel.add(labelDate_naiss);
        panel.add(champDate_naiss);
        panel.add(labelDate_emb);
        panel.add(champDate_emb);
        
        btnValider.addActionListener(this);

        this.add(panel); // Ajout du panel à notre frame de base
    }
 
    @Override
    public void actionPerformed(ActionEvent event){
        dt = new DataTransac();
        if(event.getSource() == itemTous){
            this.display();
        } else if (event.getSource() == itemModifier){
            this.ajout();
            btnReinitialiser.setEnabled(false);
            btnValider.setEnabled(false);
        } else if (event.getSource() == itemSupprimer){
            this.ajout();
            btnRechercher.setEnabled(false);
            btnReinitialiser.setEnabled(false);
        } else if (event.getSource() == itemAjouter){
            this.ajout();
            btnRechercher.setEnabled(false);
        } else if (event.getSource() == itemQuitter){
            dt.fermerRessources();
        } else if (event.getSource() == btnAfficherTous){
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
        } else if (event.getSource() == btnRecherche){
            progrBean = dt.getProgrammeur(this.champMatr.getText());
            if (progrBean == null){
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                contenuTextArea = progrBean.toString();
                zoneAffichageProgrammeurs.setText(contenuTextArea);
            }
        }
        dt.fermerRessources();
    }

}
