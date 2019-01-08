package ihm;

import data.DataTransac;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Classe abstraite contenant la signature des méthodes liées à la gestion de la vue
 * @author Daouya-Pauline
 */
public abstract class GestionVueAbstraite extends JFrame implements ActionListener{ // public ou protected     //non instantiable
    protected JMenuBar menuBar;
    protected JMenu menuProgrammeur;
    protected JMenu menuAfficher;
    protected JMenu menuAction;
    protected JMenuItem itemModifier;
    protected JMenuItem itemSupprimer;
    protected JMenuItem itemAjouter;
    protected JMenuItem itemTous;
    protected JMenuItem itemQuitter;
    protected DataTransac dt;
    
    protected JTextArea zoneAffichageProgrammeurs;
    protected String contenuTextArea;
    protected JPanel paneAfficher;    
    protected JPanel paneGenerique;
    protected int choixPopUp;
    
    /**
     * Initialise le menu de l'application
     */
    protected void init(){ 
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
        this.setVisible(true);
        this.setTitle("GesProg");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        this.setBounds(10, 10, 600, 300);
        this.setResizable(false);        
    }
    
    /**
     * Méthode abstraite affichant le panel désiré
     */
    protected abstract void display();
}
