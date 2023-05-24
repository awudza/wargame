package projet.modeles;

import projet.component.ComponentCellule;
import projet.view.events.UniteListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class Terrain extends JPanel {
    private int id;

    private final int DIST = 69;
    private Frame fenetre;

    public static int[] mouseInsideCoord = {-1, -1};
    private ArrayList<Cellule> listCellules;
    private int largeur = 1200;
    private int hauteur = 800;

    private Cellule celDep;

    private Unite uniteSelected;

    private final int W2 = largeur / 2;
    private final int H2 = hauteur / 2;

    private ArrayList<JButton> listBouton;


    public Terrain(){
        this.listBouton=new ArrayList<>();

    }

    public Terrain(Frame fenetre ){
        this.setLayout(null);
        listCellules=new ArrayList<>();
        setPreferredSize(new Dimension(largeur, hauteur));
        this.fenetre=fenetre;
        this.listBouton=new ArrayList<>();

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

    public Cellule getCelDep() {
        return celDep;
    }

    public void setCelDep(Cellule celDep) {
        this.celDep = celDep;
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
            g.setColor(new Color(255,255,255,255));
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

    public void afficherUnite(Joueur joueur) {
        Compagnie compagnie=joueur.getCompagnie();
        ArrayList<Unite> listUnite=compagnie.getListUnite();

        for (Unite unite:listUnite){
            afficheUniteItem(unite);
        }
    }

    public void afficheUniteItem(Unite unite){
        JButton bouton = new JButton();
        if(unite.getJoueur().getId()==1){
            bouton=unite.affichageUnite(Color.red);
        }else if(unite.getJoueur().getId()==2){
            bouton=unite.affichageUnite(Color.BLUE);
        }
        bouton.addActionListener(new UniteListener(unite,this.fenetre,this,bouton));
        this.add(bouton);
        unite.setBouton(bouton);
        this.listBouton.add(bouton);

    }

    public void setUniteSelected(Unite uniteSelected) {
        this.uniteSelected = uniteSelected;
    }

    public Unite getUniteSelected() {
        return uniteSelected;
    }

    public void deplacer(Cellule cel) {
        this.getUniteSelected().setBoutonPrec(this.getUniteSelected().getBouton());
        afficheUniteItem(this.getUniteSelected());
        this.remove(this.getUniteSelected().getBoutonPrec());
    }

    public void annulerDeplacement(){
        this.remove(this.getUniteSelected().getBouton());
        JButton bouton=this.getUniteSelected().getBoutonPrec();
        this.getUniteSelected().setPos(bouton.getX(), bouton.getY() );
        this.afficheUniteItem(this.getUniteSelected());
    }

    public void supprimerBoutonUnite(JButton bouton){
        this.remove(bouton);
    }

    /**
     *
     * @param cel
     * @param x
     * @param y
     * @return
     */
    public boolean verifierDeplacement(Cellule cel, int x, int y){
        int distance = (int) Math.sqrt(Math.pow(cel.getCenter().x-x,2) + Math.pow(cel.getCenter().y - y, 2));
        if(distance < this.getUniteSelected().getType().getpDeplacement() * DIST ){
            return true;
        }else{
            return false;
        }
    }
}
