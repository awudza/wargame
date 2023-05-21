package projet.modeles.tests;

    import com.sun.jdi.ArrayReference;

    import java.awt.*;
    import java.io.IOException;

    import javax.swing.*;

    import javax.swing.JFrame;

public class Main {
    private static Background background;

    public static void main(String[] args) {
       JFrame frame=new JFrame("WARGAME");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLayeredPane pane=new JLayeredPane();

        background=new Background();
        frame.setContentPane(background);
        frame.setVisible(true);
    }
}

