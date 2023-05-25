package projet.modeles;

import java.util.ArrayList;

public class TypeTerrain {
    private String nom;
//    private float bonusAttaque;
    private int bonusDefense;
    private int pDeplacement;

    private ArrayList<Integer[]> listCoord;

    /**
     * Constructeur de typeterrain avec tous ses attributs
     * @param nom
     * @param bonusDefense
     * @param pDeplacement
     */
    TypeTerrain(String nom,int pDeplacement, int  bonusDefense){
        this.nom=nom;
        this.bonusDefense=bonusDefense;
        this.pDeplacement=pDeplacement;
        listCoord = new ArrayList<>();
    }

    /**
     *
     * @return les points de deplacement
     */
    public int getpDeplacement() {
        return pDeplacement;
    }

    /**
     *
     * @return le nom du Type de terrain
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return le bonus de defense
     */
    public float getBonusDefense() {
        return bonusDefense;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer[]> getListCoord() {
        return listCoord;
    }

    /**
     * modifie les points de deplacement
     * @param pDeplacement
     */
    public void setpDeplacement(int pDeplacement) {
        this.pDeplacement = pDeplacement;
    }

    /**
     * modifie le nom du type de terrain
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * modifie le bonus de defense
     * @param bonusDefense
     */

    public void setBonusDefense(int bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    /**
     *
     * @param listCoord
     */
    public void setListCoord(ArrayList<Integer[]> listCoord) {
        this.listCoord = listCoord;
    }

    @Override
    public String toString() {
        return "TypeTerrain{" +
                "nom='" + nom + '\'' +
                ", bonusDefense=" + bonusDefense +
                ", pDeplacement=" + pDeplacement +
                ", listCoord=" + listCoord +
                '}';
    }
}

