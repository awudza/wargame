package projet.modeles;

public class Compagnie {
    private int id;
    private String nom;

    /**
     * Constructeur de Compagnie avec tous ses attributs
     * @param id
     * @param nom
     */
    public Compagnie(int id,String nom){
        this.id=id;
        this.nom=nom;
    }

    /**
     *
     * @return le nom de la compagnie
     */

    public String getNom() {
        return nom;
    }

    /**
     *
     * @return l'id de la compagnie
     */

    public int getId() {
        return id;
    }

    /**
     * modifie le nom de la compagnie
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * modifie l'id de la compagnie
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }
}
