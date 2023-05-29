package projet.modeles;

import javax.swing.*;
import java.util.ArrayList;


public class Partie {
    private int numPartie;
    private Terrain terrain;
    private Joueur joueur1;
    private Joueur joueur2;

    private int maxTour=5;
    private ArrayList<Unite> listUnite;
    private Joueur joueurActif;

    /**
     * Constructer de la partie
     * @param num
     * @param terrain
     */
    public Partie(int num,Terrain terrain,String pseudo1,String pseudo2){
        this.joueur1=new Joueur(1,pseudo1);
        this.joueur2=new Joueur(2,pseudo2);
        terrain.setPartie(this);

        this.numPartie=num;
        this.terrain=terrain;
        this.joueurActif=this.joueur1;
        AfficherUnite();
        this.joueurActif.jouer(joueur2);
        this.listUnite=new ArrayList<>();
    }

    public Partie(Joueur joueur1, Joueur joueur2){
        this.joueur1=joueur1;
        this.joueur2=joueur2;
        this.listUnite=new ArrayList<>();

    }

    /**
     * cette fonction permet de redemarer le jeu en appuyant sur le bouton continuer
     */
    public void resetDemarer(){
        this.joueurActif.resetPtDeDeplacement();
        if(joueurActif==joueur1){
            this.joueurActif.jouer(joueur2);
        }else{
            this.joueurActif.jouer(joueur1);
        }
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public void AfficherUnite(){
        this.terrain.afficherUnite(joueur1);
        this.terrain.afficherUnite(joueur2);
    }
    /**
     *
     * @return le terrain de la partie
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * permet de set le terrain de la partie
     * @param terrain
     */
    public void setTerrain(Terrain terrain) {

        this.terrain = terrain;
        this.terrain.setPartie(this);
    }

    public int getNumPartie() {
        return numPartie;
    }

    /**
     *
     * @return les elements de la partie qu'o veut enregistrer dans un fichier
     */
    public String enregistrer(){
        StringBuilder enregistrement=new StringBuilder();
        if(this.joueurActif==joueur1){
            enregistrement.append(this.joueur1.enregistrer()+this.joueur2.enregistrer()+"1");
        }else if(this.joueurActif==joueur2){
            enregistrement.append(this.joueur1.enregistrer()+this.joueur2.enregistrer()+"2");
        }

        return enregistrement.toString();
    }

    public void setJoueurActif(Joueur joueurActif) {
        this.joueurActif = joueurActif;
    }

    private int nbTour=0;
    private int tmp=0;

public void demarrer(){


if(nbTour<maxTour){
    if(joueurActif==joueur1){
        joueur2.jouer(joueur1);
        joueurActif=joueur2;
    }else{
        joueur1.jouer(joueur2);
        joueurActif=joueur1;
    }
    tmp++;
}else {
    JOptionPane.showMessageDialog(null,"Le jeu esst terminé");
}
    if(tmp%2==0){
        nbTour+=1;
    }
}

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    public ArrayList<Unite> getListUnite() {
    this.listUnite.clear();
    this.listUnite=this.joueur1.getCompagnie().getListUnite();
    for(Unite unite:this.joueur2.getCompagnie().getListUnite()){
        this.listUnite.add(unite);
    }
    return this.listUnite;

    }
}
