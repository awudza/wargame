package projet.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BackgroundMenu extends JPanel {
    private Image backgroundImage;

    public BackgroundMenu() {
        try {
            backgroundImage = ImageIO.read(getClass().getResource("../../background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1300, 900);
    }
}
