package projet.modeles.tests;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends JLayeredPane {
    private Image backgroundImage;
    private ImageIcon ico;
    public Background() {
        super();
        ico=new ImageIcon(getClass().getResource("/map.png"));
        this.backgroundImage=this.ico.getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2=(Graphics2D) g;
        g2.drawImage(backgroundImage, 0, 0, this);
    }

}
