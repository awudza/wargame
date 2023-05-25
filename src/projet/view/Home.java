package projet.view;

import projet.modeles.Partie;
import projet.modeles.Terrain;
import projet.view.events.AnnulerListener;
import projet.view.events.CelluleMouseEventListener;
import projet.view.events.QuitterListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home{

    private String pseudo1;
    private String pseudo2;

    private Frame frameprec;

    public Home(String pseudo1,String pseudo2,Frame f){
        this.pseudo1=pseudo1;
        this.pseudo2=pseudo2;
        this.frameprec=f;
    }

            public void main(String[] args) {

                JFrame frame = new JFrame();
                frame.setSize(1300, 900);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                JMenuBar menuBar=new JMenuBar();
                JMenu fichier=new JMenu("Fichier");
                JMenu action=new JMenu("Action");
                JMenuItem annuler=new JMenuItem("Annler mouvement");
                JMenuItem valider=new JMenu("Valider");
                JMenuItem quitter=new JMenuItem("Quitter");
                JMenuItem retour=new JMenuItem("Retour au Menu");
                JMenuItem enregistrer=new JMenuItem("Enregistrer la partie");



                retour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        frameprec.dispose();
                    }
                });
                quitter.addActionListener(new QuitterListener());
                fichier.add(quitter);
                fichier.add(enregistrer);
                fichier.add(retour);
                action.add(annuler);
                action.add(valider);
                menuBar.add(fichier);
                menuBar.add(action);
                frame.setJMenuBar(menuBar);
                BackgroundTerrain background=new BackgroundTerrain();
                frame.setLayout(new OverlayLayout(frame.getContentPane()));
                Terrain terrain = new Terrain(frame);
                annuler.addActionListener(new AnnulerListener(terrain));
                new CelluleMouseEventListener(terrain);
                terrain.setOpaque(false);
                frame.add(terrain);
                frame.add(background);
                Partie partie=new Partie(1,terrain,this.pseudo1,this.pseudo2);
                frame.setVisible(true);
            }
        }
