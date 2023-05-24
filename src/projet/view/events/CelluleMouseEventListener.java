package projet.view.events;

import projet.modeles.Cellule;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import projet.modeles.Terrain;


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
//        System.out.println("Mouse clicked");
//        System.out.println("Point => "+e.getPoint());
//        System.out.println("Location => "+e.getLocationOnScreen());
    }


}
