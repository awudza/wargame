package projet.modeles;

import java.lang.reflect.Type;

public class Cellule {
    private int id;
    private int largeur;
    private int hauteur;
    private int longueur;
    private int cote;
    private boolean etat;
    private Terrain terrain;
    private TypeTerrain typeTerrain;

    /**
     * Constructeur de cellule
     * @param id
     * @param largeur
     * @param longueur
     * @param cote
     * @param hauteur
     * @param terrain
     * @param typeTerrain
     */
    public Cellule(int id, int largeur,int longueur,int cote,int hauteur,Terrain terrain,TypeTerrain typeTerrain){
        this.cote=cote;
        this.id=id;
        this.hauteur=hauteur;
        this.etat=false;
        this.terrain=terrain;
        this.longueur=longueur;
        this.largeur=largeur;
    }

    /**
     *
     * @return le terrain
     */

    public Terrain getTerrain() {
        return terrain;
    }

    /**
     *
     * @return l'id
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @return le coté de la cellule
     */

    public int getCote() {
        return cote;
    }

    /**
     *
     * @return la hauteur de la cellule
     */

    public int getHauteur() {
        return hauteur;
    }

    /**
     *
     * @return la largeur de la cellule
     */

    public int getLargeur() {
        return largeur;
    }

    /**
     *
     * @return la longueyr de la cellule
     */

    public int getLongueur() {
        return longueur;
    }

    /**
     *
     * @return le type du terrain
     */

    public TypeTerrain getTypeTerrain() {
        return typeTerrain;
    }

    /**
     *
     * @param terrain
     */

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     *
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     *
     * @param cote
     */

    public void setCote(int cote) {
        this.cote = cote;
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

    /**
     *
     * @param longueur
     */

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    /**
     *
     * @param typeTerrain
     */

    public void setTypeTerrain(TypeTerrain typeTerrain) {
        this.typeTerrain = typeTerrain;
    }
}
