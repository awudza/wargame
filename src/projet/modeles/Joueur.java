package projet.modeles;

public class Joueur {
    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private int score;
    private Compagnie compagnie;

    /**
     * cette fonction est le constructeur de joueur qui permet d'initialiser tous ses attributs
     * @param id
     * @param nom
     * @param prenom
     * @param pseudo
     * @param score
     */
    public Joueur(int id,String nom, String prenom, String pseudo, int score,Compagnie compagnie){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.score=score;
        this.pseudo=pseudo;
        this.compagnie=compagnie;
    }

    /**
     *
     * @return l'id du joueur
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return le score du joueur
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return le prenom du joueur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * met à jour l'id du joueur
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  met à jour le nom du joueur
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *  met à jour le prenom du joueur
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *  met à jour le pseudo du joueur
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     *  met à jour le score du joueur
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
