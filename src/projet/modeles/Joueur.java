package projet.modeles;

public class Joueur {
    private int id;
    private String pseudo;
    private Compagnie compagnie;

    /**
     * cette fonction est le constructeur de joueur qui permet d'initialiser tous ses attributs
     * @param id
     * @param pseudo
     */
    public Joueur(int id, String pseudo){
        this.id=id;
        this.pseudo=pseudo;
        this.compagnie=new Compagnie(id,pseudo,this);

    }

    /**
     * constructeur vide de joueur
     */
    public Joueur(){}

    /**
     *
     * @return la compagnie du joueur
     */

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
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
     *  met à jour le pseudo du joueur
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String enregistrer() {
        StringBuilder enr=new StringBuilder();
        enr.append(this.pseudo+",");
        enr.append(getCompagnie().enregistrer());
        return enr.toString();
    }
}
