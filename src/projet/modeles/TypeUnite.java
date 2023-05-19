package projet.modeles;

public class TypeUnite {
    private String libelle;
    private int pAttaque;
    private int pDefense;
    private int pDeplacement;
    private int vision;
    private int pointDeVie;

    /**
     *
     * @return le nombre de points de l'attaque
     */
    public int getpAttaque() {
        return pAttaque;
    }

    /**
     *
     * @return le nombre de points de la defense
     */

    public int getpDefense() {
        return pDefense;
    }

    /**
     *
     * @return le nombre de points du deplacement
     */

    public int getpDeplacement() {
        return pDeplacement;
    }

    /**
     *
     * @return le nombre de points de vie
     */

    public int getPointDeVie() {
        return pointDeVie;
    }

    /**
     *
     * @return
     */

    public int getVision() {
        return vision;
    }

    /**
     *
     * @return le libelle
     */

    public String getLibelle() {
        return libelle;
    }
}
