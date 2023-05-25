package projet.view.events;

import projet.view.Home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnregistrerPseudoListener implements ActionListener {

    private Frame frame;
    private String playerName;
    private String playerName2;


    public EnregistrerPseudoListener(Frame frame,String pseudo1, String pseudo2){
        this.frame=frame; this.playerName=pseudo1; this.playerName2=pseudo2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // Effectuer les opérations de sauvegarde des noms des joueurs ici

        Home home = new Home(playerName, playerName2,frame);
        home.main(null);
        // Fermer l'interface du joueur
    }
}
