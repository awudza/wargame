package projet.modeles;

public class Unite {
    private String nom;
    private String etat;
    private int degat;

    /**
     * Constructeur permettant d'initialiser tous les attributs d'une unité
     * @param nom
     * @param etat
     * @param degat
     */
    public Unite(String nom, String etat, int degat){
        this.degat=degat;
        this.nom=nom;
        this.etat=etat;
    }

    /**
     *
     * @return le nom de l'unité
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return les points du degat causé
     */
    public int getDegat() {
        return degat;
    }

    /**
     *
     * @return l'etat de l'unité
     */
    public String getEtat() {
        return etat;
    }

    /**
     * mis à jour de l'attribut nom de l'unité
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;

    }

    /**
     * mis à jour de l'attribut degat de l'unité
     * @param degat
     */

    public void setDegat(int degat) {
        this.degat = degat;
    }

    /**
     * mis à jour de l'attribut etat de l'unité
     * @param etat
     */

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
