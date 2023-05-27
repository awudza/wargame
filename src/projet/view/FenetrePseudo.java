package projet.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePseudo extends JFrame {
    public FenetrePseudo() {
        setTitle("WarGame joueurs");
        setSize(1300, 900);
        setLocationRelativeTo(null);

        BackgroundMenu backgroundPanel = new BackgroundMenu();
        setContentPane(backgroundPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new GridBagLayout());

        JLabel infoLabel = new JLabel("Veuillez entrer les pseudos des joueurs :");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel nameLabel = new JLabel("Pseudo du joueur 1 :");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setPreferredSize(new Dimension(200, 30));

        JLabel nameLabel2 = new JLabel("Pseudo du joueur 2:");
        nameLabel2.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField nameField2 = new JTextField();
        nameField2.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField2.setPreferredSize(new Dimension(200, 30));

        JButton saveButton = new JButton("Demarrer la partie!");
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton retour=new JButton("Retour au Menu");
        retour.setFont(new Font("Arial", Font.BOLD, 18));
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Effectuer les opérations de sauvegarde des noms des joueurs ici
                String pseudo1=nameField.getText();
                String pseudo2=nameField2.getText();

                if(pseudo1.isEmpty() || pseudo2.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Vous devez entrer les pseudos pour pouvoir commencer la partie");
                }else{
                    Home home = new Home(pseudo1,pseudo2);
                    home.main();
                    // Fermer l'interface du joueur
                    dispose();
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(infoLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(nameLabel, gbc);

        gbc.gridy = 2;
        mainPanel.add(nameField, gbc);

        gbc.gridy = 3;
        mainPanel.add(nameLabel2, gbc);

        gbc.gridy = 4;
        mainPanel.add(nameField2, gbc);

        gbc.gridy = 5;
        mainPanel.add(saveButton, gbc);

        gbc.gridy=6;
        mainPanel.add(retour,gbc);

        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1= new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        backgroundPanel.add(mainPanel, gbc);
    }
}
