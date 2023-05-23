package projet.modeles;

import projet.component.ComponentCellule;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        this.setLayout(null);
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
            g.setColor(new Color(255,255,255,0));
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
        //g.drawString(coordinates, textX, textY);
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


    public void afficherUnite1(Joueur joueur1) {
        Compagnie compagnie=joueur1.getCompagnie();
        ArrayList<Unite> listUnite=compagnie.getListUnite();

        for (Unite unite:listUnite){
            JButton bouton = new JButton();


            switch (unite.getNom()) {
                case "Soldat":
                    unite.setPos(1244,375);
                    bouton=   unite.affichageUnite(Color.GREEN);
                    break;
                case "Goliath":
                    unite.setPos(1070,315);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;

                case "Chevalier":
                    unite.setPos(1140,435);
                    bouton=unite.affichageUnite(Color.GREEN);

                    break;
                case "Poter":
                   unite.setPos(1070,195);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;
                case "Archer1":
                    unite.setPos(1140,95);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;
                case "Archer2":
                    unite.setPos(932,315);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;
                case "Soldat2" :
                    unite.setPos(932,435);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;
                case "Chevalier2":
                    unite.setPos(1105,615);
                    bouton=unite.affichageUnite(Color.GREEN);
                    break;
            }
            this.add(bouton);
        }

    }

    public void afficherUnite2(Joueur joueur2) {
        Compagnie compagnie=joueur2.getCompagnie();
        ArrayList<Unite> listUnite=compagnie.getListUnite();

        for (Unite unite:listUnite){
            JButton bouton = new JButton();


            switch (unite.getNom()) {
                case "Soldat":
                    unite.setPos(101,686);
                    bouton=unite.affichageUnite(Color.red);
                    break;
                case "Goliath":
                    unite.setPos(239,675);
                    bouton=unite.affichageUnite(Color.red);
                    break;

                case "Chevalier":
                    unite.setPos(202,595);
                    bouton=unite.affichageUnite(Color.red);

                    break;
                case "Poter":
                    unite.setPos(308,806);
                    bouton=unite.affichageUnite(Color.red);
                    break;
                case "Archer1":
                    unite.setPos(447,675);
                    bouton=unite.affichageUnite(Color.red);
                    break;
                case "Archer2":
                    unite.setPos(204,495);
                    bouton=unite.affichageUnite(Color.red);
                    break;
                case "Soldat2" :
                    unite.setPos(343,615);
                    bouton=unite.affichageUnite(Color.red);
                    break;
                case "Chevalier2":
                    unite.setPos(308,435);
                    bouton=unite.affichageUnite(Color.red);
                    break;
            }
            this.add(bouton);
        }
    }
}
