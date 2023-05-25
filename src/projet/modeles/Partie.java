package projet.modeles;

import java.util.ArrayList;

public class Partie {
    private int numPartie;
    private Terrain terrain;
    private ArrayList<Joueur> joueurs;
    private Joueur joueur1;
    private Joueur joueur2;

    /**
     * Constructer de la partie
     * @param num
     * @param terrain
     */
    public Partie(int num,Terrain terrain,String pseudo1,String pseudo2){
        this.joueurs=new ArrayList<>(2);
        this.joueur1=new Joueur(1,pseudo1);
        this.joueur2=new Joueur(2,pseudo2);

        this.numPartie=num;
        this.terrain=terrain;
        AfficherUnite();
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

    /***
     * ajout des joueur à la partie
     * @param joueur
     */
    public void addJoueur(Joueur joueur){
        this.joueurs.add(joueur);
    }

    /**
     *
     * @return la liste des joueurs
     */
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNumPartie() {
        return numPartie;
    }
}
