package projet.modeles;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class Unite {
    private String nom;
    private boolean etat;
    private int degat;
    private boolean deplacer;

    private Cellule cel;

    private TypeUnite type;

    private int posX;
    private int posY;
    private Terrain terrain;

    private JButton boutonPrec;

    private JButton bouton;
    private Joueur joueur;
    private int pDeplacement;

    private boolean initialize;
  private  int pDeVie;



    public Unite(){

    }

    /**
     * Constructeur permettant d'initialiser tous les attributs d'une unité
     * @param nom
     * @param etat
     * @param type
     */
    public Unite(String nom, boolean etat,TypeUnite type){
        this.degat=0;
        this.nom=nom;
        this.etat=etat;
        this.type=type;
        this.pDeplacement=type.getpDeplacement();
        this.pDeVie=this.type.getPointDeVie();
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Unite(String nom, boolean etat, TypeUnite type, Joueur joueur){
        this.degat=0;
        this.nom=nom;
        this.etat=etat;
        this.type=type;
        this.joueur=joueur;
        this.pDeplacement=this.type.getpDeplacement();
        this.pDeVie=this.type.getPointDeVie();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY=posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     *
     * @return le nom de l'unité
     */
    public String getNom() {
        return nom;
    }

    public int getpDeplacement() {
        return pDeplacement;
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
    public boolean getEtat() {
        return etat;
    }

    /**
     * mis à jour de l'attribut nom de l'unité
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setpDeVie(int pDeVie) {
        this.pDeVie = pDeVie;
    }

    public int getpDeVie() {
        return pDeVie;
    }

    /**
     *
     * @return
     */
    public boolean getDeplacer() {
        return deplacer;
    }

    /**
     *
     * @param deplacer
     */
    public void setDeplacer(boolean deplacer) {
        this.deplacer = deplacer;
    }

    /**
     *
     * @ cellule
     */

    public Cellule getCel() {
        return cel;
    }

    /**
     *setCellule
     * @param cel
     */

    public void setCel(Cellule cel) {
        this.cel = cel;
    }

    /**
     *
     * @return le type de l'unite
     */

    public TypeUnite getType() {
        return type;
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

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * modifiez le type de l'unite
     * @param type
     */
    public void setType(TypeUnite type) {
        this.type = type;
    }

    public JButton affichageUnite(Color color) {
        this.bouton = new JButton();
        bouton.setBounds(this.posX, this.posY, 30, 55);
        bouton.setBorder(new LineBorder(color, 2));
        String libelle = this.type.getLibelle();
        String tooltip = "";
        String imagePath = "";

        switch (libelle) {
            case "Infanterie":
                tooltip = "Infanterie";
                imagePath = "../../resources/infanterie.png";
                break;
            case "Infanterie Lourde":
                tooltip = "Infanterie Lourde";
                imagePath = "../../resources/infanteLourde.png";
                break;
            case "Cavalerie":
                tooltip = "Cavalerie";
                imagePath = "../../resources/cavalerie.png";
                break;
            case "Mage":
                tooltip = "Mage";
                imagePath = "../../resources/mage.png";
                break;
            case "Archer":
                tooltip = "Archer";
                imagePath = "../../resources/archer.png";
                break;
        }

        bouton.setToolTipText(tooltip);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        this.type.setImageIcon(imageIcon);
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(bouton.getWidth(), bouton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        bouton.setIcon(resizedIcon);
        return bouton;
    }

    @Override
    public String toString() {
        StringBuilder info=new StringBuilder();
        info.append("Nom: "+this.getNom()+"\n");
        info.append("Type: "+this.getType().getLibelle()+"\n");
        info.append("Point de deplacement restant: "+this.getpDeplacement()+"\n");
        info.append(this.getType().toString());
        info.append("Point de vie :"+this.pDeVie+"\n");
        info.append("Degat subit: \n");
        info.append("Deplacer ?");

        return info.toString();
    }

    public JButton getBouton() {
        return bouton;
    }

    public JButton getBoutonPrec() {
        return boutonPrec;
    }

    public void setBoutonPrec(JButton boutonPrec) {
        this.boutonPrec = boutonPrec;
    }

    public void setBouton(JButton bouton) {
        this.bouton = bouton;

    }

    /**
     * set le point de deplacement
     * @param pDeplacement
     */
    public void setpDeplacement(int pDeplacement) {
        this.pDeplacement = pDeplacement;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String enregistrer() {
        StringBuilder enr=new StringBuilder();
        enr.append(getNom()+","+etat+","+getType().enregistrer()+","+getPosX()+","+getPosY()+","+getpDeplacement()+","+getpDeVie()+",");
        return enr.toString();
    }

    public int attaquer(Unite unite, Cellule cellule){
        Random random = new Random();
        int pDefense = unite.getType().getpDefense() + (int)((unite.getType().getpDefense() * cellule.getTypeTerrain().getBonusDefense())/100);
        int dBrute = this.getType().getpAttaque() - pDefense;
        int degat = dBrute + (random.nextInt((int)(0.5*dBrute) - (int)(-0.5*dBrute)) + (int)(-0.5*dBrute));
        int pv = unite.getpDeVie()-degat;
        unite.setDegat(degat);
        unite.setpDeVie(pv);
        return pv;
    }

}
