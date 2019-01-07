/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import data.DataTransac;
import data.ProgrammeurBean;
import java.sql.Date;
import java.util.Calendar;
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
    
    //Panel .................................
    private JPanel paneAfficher;
    private JPanel paneGenerique;
    private JButton btnValiderEcranAjouter;
    private JButton btnValiderEcranSupprimer;
    private JButton btnValiderEcranModifier;
    private int gestionErreur;
    private int choixPopUp;
    
    //form ajout prog
    private JButton btnRechercher;
    private JButton btnReinitialiser;
    //private JButton btnValider;
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
    private JTextField champJourDate_naiss; 
    private JComboBox comboMoisDate_naiss; 
    private JTextField champAnneeDate_naiss; 
    private JLabel labelDate_emb;
    private JTextField champJourDate_emb;
    private JComboBox comboMoisDate_emb;
    private JTextField champAnneeDate_emb;

    public void init(){ 
        // Le menu programmeur et action 
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
                
        /**
         * Par défaut, notre frame n'est pas visible
         * Il faut donc forcer la visibilité à "true"
         */
        this.setVisible(true);
        this.setTitle("GesProg");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        this.setBounds(10, 10, 600, 300);
        this.setResizable(false);
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
    
    public void displayAfficherTous(){        
        paneAfficher = new JPanel(); // Création d'un panel pour gérer les widgets
        zoneAffichageProgrammeurs = new JTextArea();
        zoneAffichageProgrammeurs = new JTextArea(10, 50);
        scroll = new JScrollPane(zoneAffichageProgrammeurs);
        paneAfficher.add(scroll);
    }

    public void displayModifier(){
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranModifier = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranModifier);
        paneGenerique.add(btnAnnuler);
       
        btnRechercher.addActionListener(this);
        btnAnnuler.addActionListener(this);
        
        btnReinitialiser.setEnabled(false);
        btnValiderEcranModifier.setEnabled(false);
    }

    public void displayModifierFinal(){
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranModifier = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranModifier);
        paneGenerique.add(btnAnnuler);
       
        btnRechercher.addActionListener(this);
        btnValiderEcranModifier.addActionListener(this);
        btnReinitialiser.setEnabled(false);
        btnAnnuler.addActionListener(this);
    }

    public void displayGenerique(){        
        paneGenerique = new JPanel(); 

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
        champJourDate_naiss = new JTextField();
        champJourDate_naiss.setColumns(10);
        Object[] mois = new Object[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        comboMoisDate_naiss = new JComboBox(mois);
        champAnneeDate_naiss = new JTextField();
        champAnneeDate_naiss.setColumns(10);
        labelDate_emb = new JLabel("Date d'embauche");
        champJourDate_emb = new JTextField();
        champJourDate_emb.setColumns(10);
        comboMoisDate_emb = new JComboBox(mois);
        champAnneeDate_emb = new JTextField();
        champAnneeDate_emb.setColumns(10);
       
        paneGenerique.add(labelMatricule);
        paneGenerique.add(champMatricule);
        paneGenerique.add(labelNom);
        paneGenerique.add(champNom);
        paneGenerique.add(labelPrenom);
        paneGenerique.add(champPrenom);
        paneGenerique.add(labelAdresse);
        paneGenerique.add(champAdresse);
        paneGenerique.add(labelPseudo);
        paneGenerique.add(champPseudo);
        paneGenerique.add(labelResponsable);
        paneGenerique.add(champResponsable);
        paneGenerique.add(labelHobby);
        paneGenerique.add(champHobby);
        paneGenerique.add(labelDate_naiss);
        paneGenerique.add(champJourDate_naiss);
        paneGenerique.add(comboMoisDate_naiss);
        paneGenerique.add(champAnneeDate_naiss);
        paneGenerique.add(labelDate_emb);
        paneGenerique.add(champJourDate_emb);
        paneGenerique.add(comboMoisDate_emb);
        paneGenerique.add(champAnneeDate_emb);
    }
    
    public void displayAjouter(){        
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranAjouter = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
       
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranAjouter);
        paneGenerique.add(btnAnnuler);
       
        btnRechercher.setEnabled(false);
        
        btnReinitialiser.addActionListener(this);
        btnValiderEcranAjouter.addActionListener(this);
        btnAnnuler.addActionListener(this);        
    }
    
     public void displaySupprimer(){        
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranSupprimer = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranSupprimer);
        paneGenerique.add(btnAnnuler);
       
        labelNom.setEnabled(false);
        champNom.setEnabled(false);
        labelPrenom.setEnabled(false);
        champPrenom.setEnabled(false);
        labelAdresse.setEnabled(false);
        champAdresse.setEnabled(false);
        labelPseudo.setEnabled(false);
        champPseudo.setEnabled(false);
        labelResponsable.setEnabled(false);
        champResponsable.setEnabled(false);
        labelHobby.setEnabled(false);
        champHobby.setEnabled(false);
        labelDate_naiss.setEnabled(false);
        champJourDate_naiss.setEnabled(false);
        comboMoisDate_naiss.setEnabled(false);
        champAnneeDate_naiss.setEnabled(false);
        labelDate_emb.setEnabled(false);
        champJourDate_emb.setEnabled(false);
        comboMoisDate_emb.setEnabled(false);
        champAnneeDate_emb.setEnabled(false);
        btnRechercher.setEnabled(false);
        btnReinitialiser.setEnabled(false);
        
        btnValiderEcranSupprimer.addActionListener(this);
        btnAnnuler.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == itemTous){
            //affichage du nouveau panel           
            getContentPane().removeAll();
            this.displayAfficherTous();
            this.setContentPane(paneAfficher);
            this.revalidate();
            this.repaint();
            
            //récupération des données 
            dt = new DataTransac();
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
            dt.fermerRessources();   
        } else if (event.getSource() == itemModifier){
            getContentPane().removeAll();
            this.displayGenerique();
            this.displayModifier();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();
        } else if (event.getSource() == itemSupprimer){
            getContentPane().removeAll();
            this.displayGenerique();
            this.displaySupprimer();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();  
        } else if (event.getSource() == itemAjouter || event.getSource() == btnReinitialiser ){
            getContentPane().removeAll();
            this.displayGenerique();
            this.displayAjouter();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();  
        } else if (event.getSource() == itemQuitter){
            choixPopUp = JOptionPane.showConfirmDialog(this,"Vérification", "Voulez-vous vraiment quitter?", JOptionPane.YES_NO_OPTION);
            if (choixPopUp == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        } else if (event.getSource() == btnAfficherTous){
            dt = new DataTransac();
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
            dt.fermerRessources();
        } else if (event.getSource() == btnRechercher){
            dt = new DataTransac();
            progrBean = dt.getProgrammeur(this.champMatricule.getText());
            if (progrBean == null){
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {                
                getContentPane().removeAll();
                this.displayGenerique();
                this.displayModifierFinal();
                this.setContentPane(paneGenerique);
                this.revalidate();
                this.repaint();
                
                this.champMatricule.setText(progrBean.getMatricule());
                this.champNom.setText(progrBean.getNom());
                this.champPrenom.setText(progrBean.getPrenom());
                this.champAdresse.setText(progrBean.getAdresse());
                this.champPseudo.setText(progrBean.getPseudo());
                this.champResponsable.setText(progrBean.getResponsable());
                this.champHobby.setText(progrBean.getHobby());
                Date date_naiss = progrBean.getDate_naiss();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date_naiss);
                this.champJourDate_naiss.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
                this.comboMoisDate_naiss.setSelectedIndex(cal.get(Calendar.MONTH));
                this.champAnneeDate_naiss.setText(Integer.toString(cal.get(Calendar.YEAR)));
                Date date_emb = progrBean.getDate_emb();
                cal.setTime(date_emb);
                this.champJourDate_emb.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH))); 
                this.comboMoisDate_emb.setSelectedIndex(cal.get(Calendar.MONTH)); 
                this.champAnneeDate_emb.setText(Integer.toString(cal.get(Calendar.YEAR))); 
            }
            dt.fermerRessources();
        } if (event.getSource() == btnValiderEcranModifier){            
            if (this.champMatricule.getText().isEmpty() || this.champNom.getText().isEmpty() || this.champPrenom.getText().isEmpty() || this.champAdresse.getText().isEmpty() || this.champPseudo.getText().isEmpty() || this.champResponsable.getText().isEmpty() || this.champHobby.getText().isEmpty() || this.champJourDate_naiss.getText().isEmpty() || this.comboMoisDate_naiss.getSelectedItem().toString().isEmpty()  || this.champAnneeDate_naiss.getText().isEmpty() || this.champJourDate_emb.getText().isEmpty() || this.comboMoisDate_emb.getSelectedItem().toString().isEmpty() || this.champAnneeDate_emb.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis", "Echec", JOptionPane.ERROR_MESSAGE);
            }else {
                dt = new DataTransac();
                gestionErreur = dt.modifierProgrammeur(this.champMatricule.getText(), this.champNom.getText(), this.champPrenom.getText(), this.champAdresse.getText(), this.champPseudo.getText(), this.champResponsable.getText(), this.champHobby.getText(), this.champJourDate_naiss.getText(), this.comboMoisDate_naiss.getSelectedItem().toString(), this.champAnneeDate_naiss.getText(), this.champJourDate_emb.getText(), this.comboMoisDate_emb.getSelectedItem().toString(), this.champAnneeDate_emb.getText());
                dt.fermerRessources();

                if (gestionErreur == 0){
                    JOptionPane.showMessageDialog(this, "Modification réussie !", "Succès!", JOptionPane.INFORMATION_MESSAGE);   
                }
                else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                }            
            }
        }
        if (event.getSource() == btnValiderEcranAjouter){ 
             if (this.champMatricule.getText().isEmpty() || this.champNom.getText().isEmpty() || this.champPrenom.getText().isEmpty() || this.champAdresse.getText().isEmpty() || this.champPseudo.getText().isEmpty() || this.champResponsable.getText().isEmpty() || this.champHobby.getText().isEmpty() || this.champJourDate_naiss.getText().isEmpty() || this.comboMoisDate_naiss.getSelectedItem().toString().isEmpty()  || this.champAnneeDate_naiss.getText().isEmpty() || this.champJourDate_emb.getText().isEmpty() || this.comboMoisDate_emb.getSelectedItem().toString().isEmpty() || this.champAnneeDate_emb.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis", "Echec", JOptionPane.ERROR_MESSAGE);
            }else {
                dt = new DataTransac();
                progrBean = dt.getProgrammeur(this.champMatricule.getText());
                dt.fermerRessources();
                if (progrBean != null){
                    JOptionPane.showMessageDialog(this, "Attention ce matricule existe déjà ", "Echec", JOptionPane.ERROR_MESSAGE);
                } else {
                    dt = new DataTransac();
                    gestionErreur = dt.ajouterProgrammeur(this.champMatricule.getText(), this.champNom.getText(), this.champPrenom.getText(), this.champAdresse.getText(), this.champPseudo.getText(), this.champResponsable.getText(), this.champHobby.getText(), this.champJourDate_naiss.getText(), this.comboMoisDate_naiss.getSelectedItem().toString(), this.champAnneeDate_naiss.getText(), this.champJourDate_emb.getText(), this.comboMoisDate_emb.getSelectedItem().toString(), this.champAnneeDate_emb.getText());
                    dt.fermerRessources(); 
                    if (gestionErreur == 0){
                        JOptionPane.showMessageDialog(this, "Ajouté avec succès !", "Succès!", JOptionPane.INFORMATION_MESSAGE);   
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }if (event.getSource() == btnValiderEcranSupprimer){ 
            dt = new DataTransac();
            progrBean = dt.getProgrammeur(this.champMatricule.getText());
            dt.fermerRessources();
            if (progrBean == null){
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                dt = new DataTransac();
                gestionErreur = dt.supprimerProgrammeur(this.champMatricule.getText());
                dt.fermerRessources();   
                if (gestionErreur == 0){
                    JOptionPane.showMessageDialog(this, "Suppression réussie !", "Succès!", JOptionPane.INFORMATION_MESSAGE);   
                }
                else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (event.getSource() == btnAnnuler){ 
            getContentPane().removeAll();
            this.revalidate();
            this.repaint();   
        }
    }
}