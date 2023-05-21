package projet.modeles.tests;

    import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JPanel;

        public class Main{

            public static void main(String[] args) {
                JFrame f = new JFrame();
               PlateauDeJeu p = new PlateauDeJeu();

                f.setContentPane(p);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        }
