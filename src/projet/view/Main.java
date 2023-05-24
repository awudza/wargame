package projet.view;

    import projet.modeles.Partie;
    import projet.modeles.Terrain;
    import projet.view.events.AnnulerListener;
    import projet.view.events.CelluleMouseEventListener;
    import projet.view.events.QuitterListener;

    import javax.swing.*;

public class Main{

            public static void main(String[] args) {


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
                    quitter.addActionListener(new QuitterListener());
                    fichier.add(quitter);
                    action.add(annuler);
                    action.add(valider);
                    menuBar.add(fichier);
                    menuBar.add(action);
                    frame.setJMenuBar(menuBar);
                Background background=new Background();
                frame.setLayout(new OverlayLayout(frame.getContentPane()));
                Terrain terrain = new Terrain(frame);
                    annuler.addActionListener(new AnnulerListener(terrain));
                new CelluleMouseEventListener(terrain);
                terrain.setOpaque(false);
                frame.add(terrain);
                frame.add(background);
                Partie partie=new Partie(1,terrain);
                frame.setVisible(true);

            }
        }
