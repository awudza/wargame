package projet.view.events;

import projet.modeles.Partie;
import projet.modeles.Terrain;
import projet.modeles.Unite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniteListener implements ActionListener {
    private Unite unite;
    private Frame frame;
    private Terrain terrain;

    public UniteListener(Unite unite,Frame frame,Terrain terrain, JButton bouton){
        this.unite=unite;
        this.frame=frame;
        this.terrain=terrain;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int option=JOptionPane.showConfirmDialog(frame,unite.toString());
        if(option==JOptionPane.YES_OPTION){
            terrain.setUniteSelected(unite);

        }



    }
}
