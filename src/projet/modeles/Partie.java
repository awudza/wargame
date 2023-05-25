package projet.modeles;

public class Partie {
    private int numPartie;
    private Terrain terrain;
    private Joueur joueur1;
    private Joueur joueur2;

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
        AfficherUnite();
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

    public String enregistrer(){
        StringBuilder enregistrement=new StringBuilder();
        enregistrement.append(this.joueur1.enregistrer()+this.joueur2.enregistrer());

        return enregistrement.toString();
    }
}
