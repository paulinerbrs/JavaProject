/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jacques
 */
public class VueAffichage extends GestionVueAbstraite{
    private JScrollPane scroll;

    @Override
    protected void display() {
        paneAfficher = new JPanel();
        zoneAffichageProgrammeurs = new JTextArea();
        zoneAffichageProgrammeurs = new JTextArea(10, 50);
        scroll = new JScrollPane(zoneAffichageProgrammeurs);
        paneAfficher.add(scroll);
        this.setContentPane(paneAfficher);
    }

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

