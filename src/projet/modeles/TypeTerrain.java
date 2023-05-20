package projet.modeles;

public class TypeTerrain {
    private String nom;
    private float bonusAttaque;
    private float bonusDefense;
    private int pDeplacement;

    /**
     * Constructeur de typeterrain avec tous ses attributs
     * @param nom
     * @param bonusAttaque
     * @param bonusDefense
     * @param pDeplacement
     */
    TypeTerrain(String nom,float bonusAttaque,float bonusDefense, int pDeplacement){
        this.bonusAttaque=bonusAttaque;
        this.nom=nom;
        this.bonusDefense=bonusDefense;
        this.pDeplacement=pDeplacement;
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
     * @return le bonus de l'attaque
     */
    public float getBonusAttaque() {
        return bonusAttaque;
    }

    /**
     *
     * @return le bonus de defense
     */
    public float getBonusDefense() {
        return bonusDefense;
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
     * modifie le bonus de l'attaque
     * @param bonusAttaque
     */

    public void setBonusAttaque(float bonusAttaque) {
        this.bonusAttaque = bonusAttaque;
    }

    /**
     * modifie le bonus de defense
     * @param bonusDefense
     */

    public void setBonusDefense(float bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

}

