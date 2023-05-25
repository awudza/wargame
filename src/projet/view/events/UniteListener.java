package projet.view.events;


import projet.modeles.Partie;
import projet.modeles.Terrain;
import projet.modeles.Unite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniteListener implements ActionListener {
    private Unite unite;
    private Frame frame;
    private Terrain terrain;

    private JOptionPane jOptionPane;

    public UniteListener(Unite unite,Frame frame,Terrain terrain, JButton bouton){
        this.unite=unite;
        this.frame=frame;
        this.terrain=terrain;
        this.jOptionPane = new JOptionPane();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int option=jOptionPane.showConfirmDialog(frame,unite.toString());
        if(option==JOptionPane.YES_OPTION){
            this.unite.setDeplacer(true);
            terrain.setUniteSelected(unite);
            JOptionPane.showMessageDialog(frame,"Vous devez ramener la souris sur l'unité à déplacer et à partir de là indiquer le chemin avec la souris.");
        }
    }

}