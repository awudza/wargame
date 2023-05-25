package projet.view.events;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}