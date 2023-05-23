package projet.modeles;

import java.util.ArrayList;

public class Compagnie {
    private int id;
    private String nom;

    private ArrayList<Unite> listUnite;

    /**
     * Constructeur de Compagnie avec tous ses attributs
     * @param id
     * @param nom
     */
    public Compagnie(int id,String nom){
        this.listUnite=new ArrayList<>();
        this.id=id;
        this.nom=nom;
        this.creerUnites();
    }

    /**
     * supprime l'unite de la liste
     * @param unite
     */
    public void removeUnite(Unite unite){
        this.listUnite.remove(unite);
    }

    /**
     * foction qui permet d'ajouter ne unite à la liste
     * @param unite
     */
    public void addUnite(Unite unite){
        this.listUnite.add(unite);
    }

    /**
     *
     * @return la liste des unités de la compagnie
     */
    public ArrayList<Unite> getListUnite() {
        return listUnite;
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

    public void creerUnites(){
        TypeUnite types=new TypeUnite();
        ArrayList<TypeUnite> typeUnites=types.getTypesUnites();
        Unite infanterie =new Unite("Soldat",true,typeUnites.get(0));
        this.listUnite.add(infanterie);
        Unite infanterieL=new Unite("Goliath",true,typeUnites.get(1));
        this.listUnite.add(infanterieL);
        Unite caval=new Unite("Chevalier",true,typeUnites.get(2));
        this.listUnite.add(caval);
        Unite mage=new Unite("Poter",true,typeUnites.get(3));
        this.listUnite.add(mage);
        Unite archer=new Unite("Archer1",true,typeUnites.get(4));
        this.listUnite.add(archer);
        Unite archer2=new Unite("Archer2",true,typeUnites.get(4));
        this.listUnite.add(archer2);
        Unite infanterie2=new Unite("Soldat2",true,typeUnites.get(0));
        this.listUnite.add(infanterie2);
        Unite caval2=new Unite("Chevalier2",true,typeUnites.get(0));
        this.listUnite.add(caval2);


    }
}
