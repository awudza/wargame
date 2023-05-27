package projet.modeles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TypeUnite {
    private String libelle;
    private int pAttaque;
    private int pDefense;
    private int pDeplacement;
    private int vision;
    private int pointDeVie;

    private ImageIcon imageIcon;


    public TypeUnite(){

    }
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
     *
     * @return l'image du type
     */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    /**
     * set l'image Icon
     * @param imageIcon
     */
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
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

    /**
     *
     * @return une liste des types d'unité qu'il y a dans le jeu
     */
    public ArrayList<TypeUnite> getTypesUnites(){
        ArrayList listTypeUnite=new ArrayList();
        TypeUnite infanterie=new TypeUnite("Infanterie",5,3,6,4,28);
        TypeUnite infanterieL=new TypeUnite("Infanterie Lourde",10,10,4,4,38);
        TypeUnite cavalerie=new TypeUnite("Cavalerie",8,3,8,6,38);
        TypeUnite mage=new TypeUnite("Mage",5,1,5,5,24);
        TypeUnite archer=new TypeUnite("Archer",6,2,5,7,33);

        listTypeUnite.add(infanterie);
        listTypeUnite.add(infanterieL);
        listTypeUnite.add(cavalerie);
        listTypeUnite.add(mage);
        listTypeUnite.add(archer);
        return listTypeUnite;
    }

    @Override
    public String toString() {
        return
                "Points d'attaque: " + pAttaque + "\n"+
                        "Points de defense: " + pDefense + "\n"+
                        "Points de deplacement maximum:" + pDeplacement + "\n"+
                        "Vision: " + vision + "\n";
    }

    public String enregistrer() {
        StringBuilder enr=new StringBuilder();
        enr.append(getLibelle()+","+getpDeplacement()+","+getpDefense()+","+getpAttaque()+","+getPointDeVie()+","+getVision());
        return enr.toString();
    }
}
