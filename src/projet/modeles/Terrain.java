package projet.modeles;

public class Terrain {
    private int id;
    private int largeur;
    private int hauteur;

    public Terrain(){

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
}
