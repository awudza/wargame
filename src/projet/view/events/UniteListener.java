package projet.view.events;


import projet.modeles.Partie;
import projet.modeles.Terrain;
import projet.modeles.Unite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        //recuperer l'image pour l'afficher sur le confirmDialogue
        ImageIcon imageIcon= unite.getType().getImageIcon();
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);


        int option=JOptionPane.showConfirmDialog(null, unite.toString(), "Informations sur l'unité", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,resizedIcon);
        if(option==JOptionPane.YES_OPTION){
            this.unite.setDeplacer(true);
            terrain.setUniteSelected(unite);
        }
    }

}