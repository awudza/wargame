package projet.view.events;

import projet.modeles.Cellule;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

import projet.modeles.Terrain;
import projet.modeles.Unite;

import javax.swing.*;


public class CelluleMouseEventListener extends MouseAdapter {
    private Terrain terrain;

    private ArrayList<Cellule> chemin;
    boolean dep = false;

    public CelluleMouseEventListener(Terrain terrain){
        super();
        this.terrain = terrain;
        terrain.addMouseListener(this);
        terrain.addMouseMotionListener(this);
        chemin = new ArrayList<>();
    }

    public void mouseMoved(MouseEvent e) {
        Cellule cel = this.terrain.celluleContenant(e.getPoint().x, e.getPoint().y);
        if (cel != null) {
            Terrain.mouseInsideCoord[0] = cel.getCenter().x;
            Terrain.mouseInsideCoord[1] = cel.getCenter().y;
            this.terrain.repaint();
//            if (this.terrain.getUniteSelected() != null) {
//                if (this.terrain.getUniteSelected().getDeplacer()) {
//                    if (cel.getCenter().x == (this.terrain.getUniteSelected().getPosX()+14) && cel.getCenter().y == (this.terrain.getUniteSelected().getPosY()+25)) {
//                        dep = true;
//                    }
//                }
//            }
        }

    }

    public void mouseClicked(MouseEvent e) {
        Cellule cel = this.terrain.celluleContenant(e.getPoint().x, e.getPoint().y);
        if(terrain.verifierPossibiliteDeDeplacer(cel,this.terrain.getUniteSelected())==true || this.terrain.verifierLesPointsDeDeplacement(cel,this.terrain.getUniteSelected())==true) {
            this.terrain.getUniteSelected().setPos(cel.getCenter().x - 14, cel.getCenter().y - 25);
            this.terrain.deplacer(cel);
            this.terrain.getUniteSelected().setpDeplacement(this.terrain.getUniteSelected().getpDeplacement() -cel.getTypeTerrain().getpDeplacement() );
        }else {
            if(terrain.verifierPossibiliteDeDeplacer(cel,this.terrain.getUniteSelected())==false){
                JOptionPane.showMessageDialog(null,"Vous devez deplacer les unités de case en case");

            }else{
                JOptionPane.showMessageDialog(null,"Vous n'avez pas assez de point de deplacement pour effectuer ce deplacement");

            }
        }

    }

    private void initDeplacement(Unite unite, Cellule cel){
       if(Objects.equals(cel.getTypeTerrain().getNom(), "Eau profonde")){
           JOptionPane.showMessageDialog(terrain,"Pas de déplacement dans l'eau");
       }else{
           this.chemin.add(cel);
       }
    }

    private boolean contient( Cellule cellule){
        for(Cellule cel : this.chemin){
            if(cel.equals(cellule)){
                return true;
            }
        }
        return false;
    }

}
