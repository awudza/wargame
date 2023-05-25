package projet.view.events;

import projet.modeles.Terrain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AnnulerListener implements ActionListener{
    private Terrain terrain;

    public AnnulerListener(Terrain terrain){
        this.terrain=terrain;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.terrain.annulerDeplacement();
    }
}
