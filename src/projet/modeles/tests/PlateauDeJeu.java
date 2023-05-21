package projet.modeles.tests;

import javax.swing.*;
import java.awt.*;

public class PlateauDeJeu extends JPanel {
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    private final int W2 = WIDTH / 2;
    private final int H2 = HEIGHT / 2;

    public PlateauDeJeu() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));

        drawHexGridAdvanced(g2d, 60, 40);
    }

    private void drawHexGridAdvanced(Graphics g, int n, int r) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * r;
        double yOff = Math.sin(ang30) * r;
        int h = n / 2; //la moitié du nombre de rangée
        int cols = 0;
        int row = 0;
        int col = 0;

        for (row = 0; row < h; row ++) {
            cols = h + row + 1;
            for (col = 0; col < cols; col++) {
                int x=(int) (W2 + xOff * (-cols + (col * 2 + 1)));
                int y=(int) (H2 - yOff * (n - cols) * 3);
                drawHex(g,x,y, r);
            }
        }
        for (row = h; row < n; row++) {
            cols = n - row + h;
            for (col = 0; col < cols; col++) {
                int x=(int) (W2 + xOff * (-cols + (col * 2 + 1)));
                int y=(int) (H2 + yOff * (n - cols) * 3);
                drawHex(g,x,y, r);
            }
        }
    }

    private void drawHex(Graphics g, int x, int y, int r) {
        Hexagone hex = new Hexagone(x, y, r);

        g.setColor(new Color(0xFFFFFF));
        g.fillPolygon(hex);
        g.setColor(new Color(0,0,0));
        g.drawPolygon(hex);
        g.setColor(new Color(0xFFFFFF));
    }
}
