package projet.view.events;

import projet.modeles.Partie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnregistrerPartieListener implements ActionListener {
    private Partie partie;

    public EnregistrerPartieListener(Partie partie){
        this.partie=partie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = "src/resources/enregistrement.txt";
        File file=new File(filePath);

        try {
                if(file.exists()){
                    file.delete();

                }
                file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.write(partie.enregistrer());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
