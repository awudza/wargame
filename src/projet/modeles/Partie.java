package projet.modeles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Partie {
    private int numPartie;
    private Terrain terrain;
    private Joueur joueur1;
    private Joueur joueur2;

    private int maxTour=1;

    private Joueur joueurActif;

    /**
     * Constructer de la partie
     * @param num
     * @param terrain
     */
    public Partie(int num,Terrain terrain,String pseudo1,String pseudo2){
        this.joueur1=new Joueur(1,pseudo1);
        this.joueur2=new Joueur(2,pseudo2);

        this.numPartie=num;
        this.terrain=terrain;
        this.joueurActif=this.joueur1;
        AfficherUnite();
        this.joueurActif.jouer(joueur2);
    }

    public Partie(Joueur joueur1, Joueur joueur2){
        this.joueur1=joueur1;
        this.joueur2=joueur2;

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
        enregistrement.append(this.joueur1.enregistrer()+this.joueur2.enregistrer());

        return enregistrement.toString();
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
}
