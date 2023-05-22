package projet.component;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import projet.modeles.Cellule;

public class ComponentCellule extends JPanel implements MouseListener{
        private Cellule cellule;

        public ComponentCellule(Cellule cellule){
            this.cellule = cellule;
            this.addMouseListener(this);
        }

        public Cellule getCellule() {
            return cellule;
        }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked tstrsgdgdy");
        System.out.println("Point => "+e.getPoint());
        System.out.println("Location => "+e.getLocationOnScreen());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entryyyyyyyyyyyyyyyyy");
    }

    @Override
    public void mouseExited(MouseEvent e) {
            
    }
}
