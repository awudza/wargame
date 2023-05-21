package projet.modeles.tests;

    import javax.swing.*;

    import javax.swing.JFrame;

public class Main {
    private static PlateauDeJeu plateau;

    public static void main(String[] args) {
       JFrame frame=new JFrame("WARGAME");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Background background=new Background();
        frame.setLayout(new OverlayLayout(frame.getContentPane()));

        plateau=new PlateauDeJeu();
        plateau.setOpaque(false);
        frame.add(plateau);
        frame.add(background);
        frame.setVisible(true);
    }
}

