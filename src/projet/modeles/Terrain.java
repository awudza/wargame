package projet.modeles;

import projet.component.ComponentCellule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Terrain extends JPanel {
    private int id;

    public static int[] mouseInsideCoord = {-1, -1};
    private ArrayList<Cellule> listCellules;
    private int largeur = 1200;
    private int hauteur = 800;

    private final int W2 = largeur / 2;
    private final int H2 = hauteur / 2;

    public Terrain(){
        listCellules=new ArrayList<>();
        setPreferredSize(new Dimension(largeur, hauteur));
    }

    /**
     *
     * @return largeur du terrain
     */

    public int getLargeur() {
        return largeur;
    }

    /**
     *
     * @return hauteur du terrain
     */

    public int getHauteur() {
        return hauteur;
    }

    /**
     *
     * @param hauteur
     */

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     *
     * @param largeur
     */

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        ImageIcon imageIcon = new ImageIcon("map.png");
        Image image = imageIcon.getImage();
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));

        dessinerGrilleHexagone(g2d, 60, 40);
    }

    private void dessinerGrilleHexagone(Graphics g, int n, int r) {
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
                dessinerHexagone(g,x,y, r);
            }
        }
        for (row = h; row < n; row++) {
            cols = n - row + h;
            for (col = 0; col < cols; col++) {
                int x=(int) (W2 + xOff * (-cols + (col * 2 + 1)));
                int y=(int) (H2 + yOff * (n - cols) * 3);
                dessinerHexagone(g,x,y, r);
            }
        }
    }

    private void dessinerHexagone(Graphics g, int x, int y, int r) {
        Cellule cellule = new Cellule(x, y, r);
        this.listCellules.add(cellule);
        g.setColor(new Color(255,255,255,0));
        g.fillPolygon(cellule);
        if(mouseInsideCoord[0] == x && mouseInsideCoord[1] == y){
            g.setColor(new Color(51,0,0));
            g.drawPolygon(cellule);
        }else{
            g.setColor(new Color(255,255,255,50));
            g.drawPolygon(cellule);
        }
        g.setColor(new Color(0xFFFFFF));
        // Coordonnées de la case
        String coordinates =  x + ", " + y ;

        // Déterminer les positions x et y pour afficher le texte
        int textX = x - r/2; // Modifier ces valeurs selon vos besoins
        int textY = y + r/2; // Modifier ces valeurs selon vos besoins

        // Définir la couleur et la police du texte
        g.setColor(new Color(0, 0, 0)); // Noir
        g.setFont(new Font("Arial", Font.PLAIN, 12)); // Modifier la police et la taille selon vos besoins

        // Afficher les coordonnées de la case
        g.drawString(coordinates, textX, textY);
    }

    /**
     * fonction qui renvoir l'hexagon contenant le point
     * @param x
     * @param y
     * @return
     */
    public Cellule celluleContenant(int x,int y){
        for(Cellule cel: this.listCellules)
            if (cel.contain(x,y))return cel;
        return null;
    }
}
