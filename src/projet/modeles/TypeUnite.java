package projet.modeles;

public class TypeUnite {
    private String libelle;
    private int pAttaque;
    private int pDefense;
    private int pDeplacement;
    private int vision;
    private int pointDeVie;

    /**
     * constructeur de TypeUnite avec tous ses attributs
     * @param libelle
     * @param pAttaque
     * @param pDefense
     * @param pDeplacement
     * @param vision
     * @param pointDeVie
     */
    public TypeUnite(String libelle, int pAttaque,int pDefense,int pDeplacement,int vision,int pointDeVie){
        this.libelle=libelle;
        this.pAttaque=pAttaque;
        this.pDefense=pDefense;
        this.vision=vision;
        this.pDeplacement=pDeplacement;
        this.pointDeVie=pointDeVie;
    }

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

    /**
     * modifiez le libelle du type d'unite
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * modifiez le point d'attaque
     * @param pAttaque
     */
    public void setpAttaque(int pAttaque) {
        this.pAttaque = pAttaque;
    }

    /**
     * modifiez les points de defense
     * @param pDefense
     */
    public void setpDefense(int pDefense) {
        this.pDefense = pDefense;
    }

    /**
     * modifiez les points de deplacement
     * @param pDeplacement
     */

    public void setpDeplacement(int pDeplacement) {
        this.pDeplacement = pDeplacement;
    }

    /**
     * modifiez le point de vie de l'unité
     * @param pointDeVie
     */
    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    /**
     *  modifiez la vision du type d'unité
     * @param vision
     */
    public void setVision(int vision) {
        this.vision = vision;
    }
}
