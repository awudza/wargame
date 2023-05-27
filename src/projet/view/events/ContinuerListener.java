package projet.view.events;

import projet.modeles.*;
import projet.view.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class ContinuerListener implements ActionListener {
    Frame frame;

    public  ContinuerListener(Frame frame){
        this.frame=frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = "src/resources/enregistrement.txt";

        try {
            // Création d'un objet Scanner pour lire le fichier
            Scanner scanner = new Scanner(new File(filePath));

            // Définition de la virgule comme délimiteur
            scanner.useDelimiter(",");
            int i=0;
               ArrayList<String> lecture=new ArrayList<>();
            // Lecture des éléments un par un
            while (scanner.hasNext()) {
                String element=scanner.next();
                lecture.add(element);
            }
            //fermeture du scanner

            scanner.close();
            //recuperation des pseudos des joueurs
            Joueur joueur1=new Joueur(1,lecture.get(0));
            Joueur joueur2=new Joueur(2,lecture.get(97));

            //creation de nouvelles compagnies
            Compagnie compagnie1=new Compagnie(joueur1);
            Compagnie compagnie2=new Compagnie(joueur2);


            //compagnie du joueur 1
            int index=0;
        while(index<96){
            TypeUnite type=new TypeUnite(lecture.get(index+3),Integer.valueOf(lecture.get(index+4)),Integer.valueOf(lecture.get(index+5)),Integer.valueOf(lecture.get(index+6)),Integer.valueOf(lecture.get(index+7)),Integer.valueOf(lecture.get(index+8)));
            boolean b;
            if(lecture.get(index+2).equals("true")){
                b=true;
            }else{
                b=false;
            }
            Unite unite1=new Unite(lecture.get(index+1),b,type,joueur1);
            unite1.setPos(Integer.valueOf(lecture.get(index+9)),Integer.valueOf(lecture.get(index+10)));
            unite1.setpDeplacement(Integer.valueOf(index+11));
            unite1.setpDeplacement(Integer.valueOf(index+12));
            compagnie1.addUnite(unite1);
            index=index+12;
        }
        joueur1.setCompagnie(compagnie1);

        int ind= 97;
            while(ind<192){
              TypeUnite type=new TypeUnite(lecture.get(ind+3),Integer.valueOf(lecture.get(ind+4)),Integer.valueOf(lecture.get(ind+5)),Integer.valueOf(lecture.get(ind+6)),Integer.valueOf(lecture.get(ind+7)),Integer.valueOf(lecture.get(ind+8)));

                boolean b;
                if(lecture.get(ind+2).equals("true")){
                    b=true;
                }else{
                    b=false;
                }
                Unite unite2=new Unite(lecture.get(ind+1),b,type,joueur2);
                unite2.setPos(Integer.valueOf(lecture.get(ind+9)),Integer.valueOf(lecture.get(ind+10)));
                unite2.setpDeplacement(Integer.valueOf(ind+11));
                unite2.setpDeVie(Integer.valueOf(ind+12));
                compagnie2.addUnite(unite2);
                ind=ind+12;
            }


            joueur2.setCompagnie(compagnie2);

            System.out.println(joueur2.enregistrer());
            System.out.println(joueur1.enregistrer());
            Partie partie=new Partie(joueur1,joueur2);


          if(lecture.get(lecture.size()-1)=="1"){
                partie.setJoueurActif(joueur1);
            }else{
                partie.setJoueurActif(joueur2);
            }

            Home home=new Home();
            home.main2(partie);



        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(frame,"Désolé Vous n'avez pas de partie en cours");
        }
    }
}
