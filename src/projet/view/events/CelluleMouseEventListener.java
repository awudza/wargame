package projet.view.events;

import projet.modeles.Cellule;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import projet.modeles.Terrain;
import projet.modeles.Unite;

import javax.swing.*;


public class CelluleMouseEventListener extends MouseAdapter {
    private Terrain terrain;

    public CelluleMouseEventListener(Terrain terrain){
        super();
        this.terrain = terrain;
        terrain.addMouseListener(this);
        terrain.addMouseMotionListener(this);
    }

    public void mouseMoved(MouseEvent e){
        Cellule cel = this.terrain.celluleContenant(e.getPoint().x,e.getPoint().y);
        if( cel != null){
            Terrain.mouseInsideCoord[0] = cel.getCenter().x;
            Terrain.mouseInsideCoord[1] = cel.getCenter().y;
            this.terrain.repaint();
        }

    }

    public void mouseClicked(MouseEvent e) {
        Cellule cel = this.terrain.celluleContenant(e.getPoint().x, e.getPoint().y);
        if (this.terrain.verifierDeplacement(cel, this.terrain.getUniteSelected().getPosX(), this.terrain.getUniteSelected().getPosY())) {
            this.terrain.getUniteSelected().setPos(cel.getCenter().x-14,cel.getCenter().y-25);
            this.terrain.deplacer(cel);
        }else{
            JOptionPane.showMessageDialog(terrain,"L'Unité ne dispose pas d'assez de point de vie pour effectuer ce déplacement");
        }
    }



}
