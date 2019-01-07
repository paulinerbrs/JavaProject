package ihm;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe gérant la vue de l'affichage des programmeurs 
 * @author Daouya-Pauline
 */
public class VueAffichage extends GestionVueAbstraite{
    private JScrollPane scroll;

    /**
     * Met en place le panel affichant les programmeurs
     */
    @Override
    protected void display() {
        paneAfficher = new JPanel();
        zoneAffichageProgrammeurs = new JTextArea();
        zoneAffichageProgrammeurs = new JTextArea(10, 50);
        scroll = new JScrollPane(zoneAffichageProgrammeurs);
        paneAfficher.add(scroll);
        this.setContentPane(paneAfficher);
    }
    /**
     * Gère les évènements engendré par l'utilisateur
     * @param event Evènement généré par l'utilisateur
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        /*if(event.getSource() == itemTous){
            //affichage du nouveau panel           
            getContentPane().removeAll();
            VueAffichage vueA = new VueAffichage();
            vueA.display();
            this.setContentPane(paneAfficher);
            this.revalidate();
            this.repaint();
            
            //récupération des données 
            dt = new DataTransac();
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
            dt.fermerRessources();   
        }*/
    }
}