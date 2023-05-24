package projet.modeles;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Terrain extends JPanel {
    private int id;

    public static int[] mouseInsideCoord = {-1, -1};
    private ArrayList<Cellule> listCellules;

    private TypeTerrain plaine;
    private TypeTerrain eauProfonde;
    private TypeTerrain village;
    private TypeTerrain montagne;
    private TypeTerrain foret;
    private TypeTerrain colline;
    private TypeTerrain forteresse;

    private int largeur = 1200;
    private int hauteur = 800;

    private final int W2 = largeur / 2;
    private final int H2 = hauteur / 2;

    public Terrain(){
        listCellules=new ArrayList<>();
        setPreferredSize(new Dimension(largeur, hauteur));
        plaine = new TypeTerrain("Plaine", 1,20 );
        village = new TypeTerrain("Village", 1, 40);
        forteresse = new TypeTerrain("Forteresse", 1, 60);
        eauProfonde = new TypeTerrain("Eau profonde", 0,0);
        foret = new TypeTerrain("Forêt", 2, 40);
        colline = new TypeTerrain("Colline", 2, 50);
        montagne = new TypeTerrain("Montagne", 2, 60);
        this.initTypesTerrain();
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
        this.listCellules.add(addTypeTerrain(cellule));
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

    private void initTypesTerrain(){
        this.initColline();
        this.initForet();
        this.initPlaine();
        this.initEauProfonde();
        this.initMontagne();
        this.initForteresse();
    }
    private void initPlaine(){
        plaine.getListCoord().add(new Integer[]{1084,100});
        plaine.getListCoord().add(new Integer[]{ 703,160});
        plaine.getListCoord().add(new Integer[]{1119,160});
        plaine.getListCoord().add(new Integer[]{1154,220});
        plaine.getListCoord().add(new Integer[]{ 565,280});
        plaine.getListCoord().add(new Integer[]{1119,280});
        plaine.getListCoord().add(new Integer[]{ 530,340});
        plaine.getListCoord().add(new Integer[]{ 218,400});
        plaine.getListCoord().add(new Integer[]{ 565,400});
        plaine.getListCoord().add(new Integer[]{ 253,460});
        plaine.getListCoord().add(new Integer[]{ 218,520});
        plaine.getListCoord().add(new Integer[]{ 288,520});
        plaine.getListCoord().add(new Integer[]{ 911,520});
        plaine.getListCoord().add(new Integer[]{ 807,580});
        plaine.getListCoord().add(new Integer[]{ 877,580});
        plaine.getListCoord().add(new Integer[]{ 773,640});
        plaine.getListCoord().add(new Integer[]{ 842,640});
        plaine.getListCoord().add(new Integer[]{ 738,700});
        plaine.getListCoord().add(new Integer[]{ 807,700});
    }

    private void initMontagne(){
        montagne.getListCoord().add(new Integer[]{11,40});
        montagne.getListCoord().add(new Integer[]{80,40});
        montagne.getListCoord().add(new Integer[]{149,40});
        montagne.getListCoord().add(new Integer[]{773,40});
        montagne.getListCoord().add(new Integer[]{45,100});
        montagne.getListCoord().add(new Integer[]{115,100});
        montagne.getListCoord().add(new Integer[]{738,100});
        montagne.getListCoord().add(new Integer[]{807,100});
        montagne.getListCoord().add(new Integer[]{80,160});
        montagne.getListCoord().add(new Integer[]{773,160});
        montagne.getListCoord().add(new Integer[]{842,160});
        montagne.getListCoord().add(new Integer[]{11,400});
        montagne.getListCoord().add(new Integer[]{80,400});
        montagne.getListCoord().add(new Integer[]{45,460});
        montagne.getListCoord().add(new Integer[]{115,460});
        montagne.getListCoord().add(new Integer[]{11,520});
        montagne.getListCoord().add(new Integer[]{80,520});
        montagne.getListCoord().add(new Integer[]{1223,700});
        montagne.getListCoord().add(new Integer[]{1292,700});
        montagne.getListCoord().add(new Integer[]{1362,700});
        montagne.getListCoord().add(new Integer[]{565,759});
        montagne.getListCoord().add(new Integer[]{1188,759});
        montagne.getListCoord().add(new Integer[]{1258,759});
        montagne.getListCoord().add(new Integer[]{1327,759});
        montagne.getListCoord().add(new Integer[]{600,819});
        montagne.getListCoord().add(new Integer[]{1223,819});
        montagne.getListCoord().add(new Integer[]{1292,819});
        montagne.getListCoord().add(new Integer[]{1362,819});
    }

    private void initForet(){
        foret.getListCoord().add(new Integer[]{184,220});
        foret.getListCoord().add(new Integer[]{253,220});
        foret.getListCoord().add(new Integer[]{149,280});
        foret.getListCoord().add(new Integer[]{218,280});
        foret.getListCoord().add(new Integer[]{288,280});
        foret.getListCoord().add(new Integer[]{184,340});
        foret.getListCoord().add(new Integer[]{253,340});
        foret.getListCoord().add(new Integer[]{392,460});
        foret.getListCoord().add(new Integer[]{461,460});
        foret.getListCoord().add(new Integer[]{426,520});
        foret.getListCoord().add(new Integer[]{496,520});
        foret.getListCoord().add(new Integer[]{461,580});
        foret.getListCoord().add(new Integer[]{530,580});
        foret.getListCoord().add(new Integer[]{461,819});
        foret.getListCoord().add(new Integer[]{1084,819});
    }

    private void initEauProfonde(){
        eauProfonde.getListCoord().add(new Integer[]{218,40});
        eauProfonde.getListCoord().add(new Integer[]{253,100});
        eauProfonde.getListCoord().add(new Integer[]{946,100});
        eauProfonde.getListCoord().add(new Integer[]{288,160});
        eauProfonde.getListCoord().add(new Integer[]{911,160});
        eauProfonde.getListCoord().add(new Integer[]{981,160});
        eauProfonde.getListCoord().add(new Integer[]{322,220});
        eauProfonde.getListCoord().add(new Integer[]{877,220});
        eauProfonde.getListCoord().add(new Integer[]{946,220});
        eauProfonde.getListCoord().add(new Integer[]{357,280});
        eauProfonde.getListCoord().add(new Integer[]{392,340});
        eauProfonde.getListCoord().add(new Integer[]{1119,520});
        eauProfonde.getListCoord().add(new Integer[]{1015,580});
        eauProfonde.getListCoord().add(new Integer[]{1084,580});
        eauProfonde.getListCoord().add(new Integer[]{981,640});
        eauProfonde.getListCoord().add(new Integer[]{1050,640});
        eauProfonde.getListCoord().add(new Integer[]{877,700});
        eauProfonde.getListCoord().add(new Integer[]{946,700});
        eauProfonde.getListCoord().add(new Integer[]{842,759});
        eauProfonde.getListCoord().add(new Integer[]{911,759});
        eauProfonde.getListCoord().add(new Integer[]{807,819});
    }

    private void initColline(){
        colline.getListCoord().add(new Integer[]{1188, 40});
        colline.getListCoord().add(new Integer[]{1258, 40});
        colline.getListCoord().add(new Integer[]{1327, 40});
        colline.getListCoord().add(new Integer[]{1154, 100});
        colline.getListCoord().add(new Integer[]{1223, 100});
        colline.getListCoord().add(new Integer[]{1292, 100});
        colline.getListCoord().add(new Integer[]{1362, 100});
        colline.getListCoord().add(new Integer[]{1188, 160});
        colline.getListCoord().add(new Integer[]{1258, 160});
        colline.getListCoord().add(new Integer[]{1327, 160});
        colline.getListCoord().add(new Integer[]{392, 220});
        colline.getListCoord().add(new Integer[]{461, 220});
        colline.getListCoord().add(new Integer[]{530, 220});
        colline.getListCoord().add(new Integer[]{669, 220});
        colline.getListCoord().add(new Integer[]{1015, 220});
        colline.getListCoord().add(new Integer[]{1292, 220});
        colline.getListCoord().add(new Integer[]{1362, 220});
        colline.getListCoord().add(new Integer[]{703, 280});
        colline.getListCoord().add(new Integer[]{911, 280});
        colline.getListCoord().add(new Integer[]{981, 280});
        colline.getListCoord().add(new Integer[]{669, 340});
        colline.getListCoord().add(new Integer[]{877, 340});
        colline.getListCoord().add(new Integer[]{946, 340});
        colline.getListCoord().add(new Integer[]{1015, 340});
        colline.getListCoord().add(new Integer[]{634, 400});
        colline.getListCoord().add(new Integer[]{842, 400});
        colline.getListCoord().add(new Integer[]{911, 400});
        colline.getListCoord().add(new Integer[]{981, 400});
        colline.getListCoord().add(new Integer[]{669, 460});
        colline.getListCoord().add(new Integer[]{877, 460});
        colline.getListCoord().add(new Integer[]{946, 460});
        colline.getListCoord().add(new Integer[]{634, 520});
        colline.getListCoord().add(new Integer[]{703, 520});
        colline.getListCoord().add(new Integer[]{1362, 580});
        colline.getListCoord().add(new Integer[]{218, 640});
        colline.getListCoord().add(new Integer[]{288, 640});
        colline.getListCoord().add(new Integer[]{1327, 640});
        colline.getListCoord().add(new Integer[]{1327, 640});
        colline.getListCoord().add(new Integer[]{184, 700});
        colline.getListCoord().add(new Integer[]{253, 700});
        colline.getListCoord().add(new Integer[]{322, 700});
        colline.getListCoord().add(new Integer[]{218, 759});
        colline.getListCoord().add(new Integer[]{288, 759});
        colline.getListCoord().add(new Integer[]{357, 759});
        colline.getListCoord().add(new Integer[]{253, 819});
        colline.getListCoord().add(new Integer[]{322, 819});
        colline.getListCoord().add(new Integer[]{392, 819});
    }

    private void initForteresse(){
        forteresse.getListCoord().add(new Integer[]{426, 40});
        forteresse.getListCoord().add(new Integer[]{496, 40});
        forteresse.getListCoord().add(new Integer[]{568, 40});
        forteresse.getListCoord().add(new Integer[]{634, 40});
        forteresse.getListCoord().add(new Integer[]{392, 100});
        forteresse.getListCoord().add(new Integer[]{461, 100});
        forteresse.getListCoord().add(new Integer[]{530, 100});
        forteresse.getListCoord().add(new Integer[]{600, 100});
        forteresse.getListCoord().add(new Integer[]{669, 100});
        forteresse.getListCoord().add(new Integer[]{426, 160});
        forteresse.getListCoord().add(new Integer[]{496, 160});
        forteresse.getListCoord().add(new Integer[]{565, 160});
        forteresse.getListCoord().add(new Integer[]{634, 160});
        forteresse.getListCoord().add(new Integer[]{703, 160});
        forteresse.getListCoord().add(new Integer[]{1188, 280});
        forteresse.getListCoord().add(new Integer[]{1258, 280});
        forteresse.getListCoord().add(new Integer[]{1223, 340});
        forteresse.getListCoord().add(new Integer[]{1292, 340});
        forteresse.getListCoord().add(new Integer[]{1188, 400});
        forteresse.getListCoord().add(new Integer[]{1258, 400});
        forteresse.getListCoord().add(new Integer[]{1223, 460});
        forteresse.getListCoord().add(new Integer[]{1292, 460});
        forteresse.getListCoord().add(new Integer[]{1188, 520});
        forteresse.getListCoord().add(new Integer[]{1258, 520});
        forteresse.getListCoord().add(new Integer[]{45, 580});
        forteresse.getListCoord().add(new Integer[]{115, 580});
        forteresse.getListCoord().add(new Integer[]{11, 640});
        forteresse.getListCoord().add(new Integer[]{80, 640});
        forteresse.getListCoord().add(new Integer[]{149, 640});
        forteresse.getListCoord().add(new Integer[]{45, 700});
        forteresse.getListCoord().add(new Integer[]{115, 700});
        forteresse.getListCoord().add(new Integer[]{11, 759});
        forteresse.getListCoord().add(new Integer[]{80, 759});
        forteresse.getListCoord().add(new Integer[]{149, 759});
        forteresse.getListCoord().add(new Integer[]{45, 819});
        forteresse.getListCoord().add(new Integer[]{115, 819});
        forteresse.getListCoord().add(new Integer[]{184, 819});
    }

    /**
     *
     * @param cel
     * @return
     */
    private Cellule addTypeTerrain(Cellule cel){
        if(compare(this.plaine.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.plaine);
        }else if(compare(this.colline.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.colline);
        }else if(compare(this.forteresse.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.forteresse);
        }else if(compare(this.foret.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.foret);
        }else  if(compare(this.montagne.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.montagne);
        }else if(compare(this.eauProfonde.getListCoord(),cel.getCenter().x, cel.getCenter().y)){
            cel.setTypeTerrain(this.eauProfonde);
        }else{
            cel.setTypeTerrain(this.village);
        }
        return cel;
    }

    private boolean compare(ArrayList<Integer[]> liste, int x, int y){
        for (Integer[] coord : liste){
            if(coord[0] == x && coord[1] == y){
                return true;
            }
        }
        return false;
    }
}
