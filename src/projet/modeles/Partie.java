package projet.modeles;

import java.util.ArrayList;

public class Partie {
    private int numPartie;
    private Terrain terrain;
    private ArrayList<Joueur> joueurs;

    /**
     * Constructer de la partie
     * @param num
     * @param terrain
     */
    public Partie(int num,Terrain terrain){
        this.joueurs=new ArrayList<>(2);
        this.numPartie=num;
        this.terrain=terrain;
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
