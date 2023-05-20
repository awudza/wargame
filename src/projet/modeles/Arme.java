package projet.modeles;

public class Arme {
    private int id;
    private String nom;
    private int pAttaque;

    /**
     * Constructeur de Arme aves tous ses attributs
     * @param id
     * @param nom
     * @param pAttaque
     */

    public Arme(int id,String nom,int pAttaque){
        this.id=id;
        this.nom=nom;
        this.pAttaque=pAttaque;
    }

    /**
     *
     * @return l'id de l'arme
     */

    public int getId() {
        return id;
    }

    /**
     *
     * @return le nom de l'arme
     */

    public String getNom() {
        return nom;
    }

    /**
     *
     * @return le point d'attaque de l'arme
     */

    public int getpAttaque() {
        return pAttaque;
    }

    /**
     * modifie le nom de l'arme
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * modifie le point d'attaque de l'arme
     * @param pAttaque
     */

    public void setpAttaque(int pAttaque) {
        this.pAttaque = pAttaque;
    }

    /**
     * modifie l'id de l'arme
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }
}
