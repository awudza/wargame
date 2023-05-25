package projet.modeles;

import java.util.ArrayList;

public class Compagnie {
    private int id;
    private String nom;

    private Joueur joueur;

    private ArrayList<Unite> listUnite;

    /**
     * Constructeur de Compagnie avec tous ses attributs
     * @param id
     * @param nom
     */
    public Compagnie(int id,String nom,Joueur joueur){
        this.listUnite=new ArrayList<>();
        this.id=id;
        this.nom=nom;
        this.joueur=joueur;
        this.creerUnites(joueur);
    }

    public Compagnie(Joueur joueur){
        this.listUnite=new ArrayList<>();
        this.id= joueur.getId();
        this.nom=joueur.getPseudo();
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

    public void creerUnites(Joueur joueur){
        TypeUnite types=new TypeUnite();
        ArrayList<TypeUnite> typeUnites=types.getTypesUnites();
        if(joueur.getId()==1) {
            Unite infanterie = new Unite("Soldat", true, typeUnites.get(0),joueur);
            infanterie.setPos(1244,375);
            this.listUnite.add(infanterie);
            Unite infanterieL = new Unite("Goliath", true, typeUnites.get(1),joueur);
            infanterieL.setPos(1070,315);
            this.listUnite.add(infanterieL);
            Unite caval = new Unite("Chevalier", true, typeUnites.get(2),joueur);
            caval.setPos(1140,435);
            this.listUnite.add(caval);
            Unite mage = new Unite("Poter", true, typeUnites.get(3),joueur);
            mage.setPos(1070,195);
            this.listUnite.add(mage);
            Unite archer = new Unite("Archer1", true, typeUnites.get(4),joueur);
            archer.setPos(1140,95);
            this.listUnite.add(archer);
            Unite archer2 = new Unite("Archer2", true, typeUnites.get(4),joueur);
            archer2.setPos(932,315);
            this.listUnite.add(archer2);
            Unite infanterie2 = new Unite("Soldat2", true, typeUnites.get(0),joueur);
            infanterie2.setPos(932,435);
            this.listUnite.add(infanterie2);
            Unite caval2 = new Unite("Chevalier2", true, typeUnites.get(0),joueur);
            caval2.setPos(1105,615);
            this.listUnite.add(caval2);
        }else if(joueur.getId()==2){
            Unite infanterie = new Unite("Soldat", true, typeUnites.get(0),joueur);
            infanterie.setPos(101,686);
            this.listUnite.add(infanterie);
            Unite infanterieL = new Unite("Goliath", true, typeUnites.get(1),joueur);
            infanterieL.setPos(239,675);
            this.listUnite.add(infanterieL);
            Unite caval = new Unite("Chevalier", true, typeUnites.get(2),joueur);
            this.listUnite.add(caval);
            caval.setPos(202,595);
            Unite mage = new Unite("Poter", true, typeUnites.get(3),joueur);
            mage.setPos(308,806);
            this.listUnite.add(mage);
            Unite archer = new Unite("Archer1", true, typeUnites.get(4),joueur);
            archer.setPos(447,675);
            this.listUnite.add(archer);
            Unite archer2 = new Unite("Archer2", true, typeUnites.get(4),joueur);
            archer2.setPos(204,495);
            this.listUnite.add(archer2);
            Unite infanterie2 = new Unite("Soldat2", true, typeUnites.get(0),joueur);
            infanterie2.setPos(343,615);
            this.listUnite.add(infanterie2);
            Unite caval2 = new Unite("Chevalier2", true, typeUnites.get(0),joueur);
            caval2.setPos(308,435);
            this.listUnite.add(caval2);
        }
    }

    public String enregistrer() {
        StringBuilder enr=new StringBuilder();
        for (Unite unite: listUnite){
            enr.append(unite.enregistrer());
        }
        return enr.toString();
    }
}
