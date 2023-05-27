package projet.view;

import projet.modeles.Joueur;
import projet.modeles.Partie;
import projet.modeles.Terrain;
import projet.view.events.AnnulerListener;
import projet.view.events.CelluleMouseEventListener;
import projet.view.events.EnregistrerPartieListener;
import projet.view.events.QuitterListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    private String pseudo1;
    private String pseudo2;


    public Home(String pseudo1, String pseudo2) {
        this.pseudo1 = pseudo1;
        this.pseudo2 = pseudo2;
    }

    public Home() {

    }

    public void main() {

        JFrame frame = new JFrame();
        frame.setSize(1300, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Terrain terrain = new Terrain(frame);
        Partie partie = new Partie(1, terrain, this.pseudo1, this.pseudo2);



        JMenuBar menuBar = new JMenuBar();
        JMenu fichier = new JMenu("Fichier");
        JMenu action = new JMenu("Action");
        JMenuItem annuler = new JMenuItem("Annler mouvement");
        JMenuItem valider = new JMenuItem("Valider");
        JMenuItem quitter = new JMenuItem("Quitter");
        JMenuItem retour = new JMenuItem("Retour au Menu");
        JMenuItem enregistrer = new JMenuItem("Enregistrer la partie");


        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option=JOptionPane.showConfirmDialog(frame,"Voulez vous Enregistrer la partie en cours ?");
                if(option==JOptionPane.YES_OPTION){
                    new EnregistrerPartieListener(partie);
                    frame.dispose();
                }else {
                    frame.dispose();
                }
            }

        });
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                partie.demarrer();
            }
        });
        quitter.addActionListener(new QuitterListener());
        fichier.add(enregistrer);
        fichier.add(retour);
        fichier.add(quitter);
        action.add(annuler);

        action.add(valider);



        menuBar.add(fichier);
        menuBar.add(action);
        frame.setJMenuBar(menuBar);
        BackgroundTerrain background = new BackgroundTerrain();
        frame.setLayout(new OverlayLayout(frame.getContentPane()));

        annuler.addActionListener(new AnnulerListener(terrain));
        new CelluleMouseEventListener(terrain);
        terrain.setOpaque(false);
        frame.add(terrain);
        frame.add(background);
        enregistrer.addActionListener(new EnregistrerPartieListener(partie));
        frame.setVisible(true);
    }

    public void main2(Partie partie) {
        JFrame frame = new JFrame();
        frame.setSize(1300, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Terrain terrain = new Terrain(frame);
        partie = partie;
        partie.setTerrain(terrain);
        partie.AfficherUnite();


        JMenuBar menuBar = new JMenuBar();
        JMenu fichier = new JMenu("Fichier");
        JMenu action = new JMenu("Action");
        JMenuItem annuler = new JMenuItem("Annler mouvement");
        JMenuItem valider = new JMenu("Valider");
        JMenuItem quitter = new JMenuItem("Quitter");
        JMenuItem retour = new JMenuItem("Retour au Menu");
        JMenuItem enregistrer = new JMenuItem("Enregistrer la partie");



        Partie finalPartie = partie;
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option=JOptionPane.showConfirmDialog(frame,"Voulez vous Enregistrer la partie en cours ?");
                if(option==JOptionPane.YES_OPTION){
                    new EnregistrerPartieListener(finalPartie);
                    frame.dispose();
                }else {
                    frame.dispose();
                }
            }

        });

        finalPartie.resetDemarer();
        quitter.addActionListener(new QuitterListener());
        fichier.add(enregistrer);
        fichier.add(retour);
        fichier.add(quitter);
        action.add(annuler);
        action.add(valider);
        menuBar.add(fichier);
        menuBar.add(action);
        frame.setJMenuBar(menuBar);
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                finalPartie.demarrer();
            }
        });
        BackgroundTerrain background = new BackgroundTerrain();
        frame.setLayout(new OverlayLayout(frame.getContentPane()));
        annuler.addActionListener(new AnnulerListener(terrain));
        new CelluleMouseEventListener(terrain);
        terrain.setOpaque(false);
        frame.add(terrain);
        frame.add(background);
        enregistrer.addActionListener(new EnregistrerPartieListener(partie));
        frame.setVisible(true);
    }

}

