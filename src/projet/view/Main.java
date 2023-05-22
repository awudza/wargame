package projet.view;

    import projet.modeles.Terrain;
    import projet.view.events.CelluleMouseEventListener;

    import javax.swing.*;

public class Main{

            public static void main(String[] args) {
                JFrame frame = new JFrame();
                frame.setSize(1300, 900);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                Background background=new Background();
                frame.setLayout(new OverlayLayout(frame.getContentPane()));
                Terrain terrain = new Terrain();
                new CelluleMouseEventListener(terrain);
                terrain.setOpaque(false);
                frame.add(terrain);
                frame.add(background);
                frame.setVisible(true);
            }
        }
