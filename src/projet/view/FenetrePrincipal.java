package projet.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePrincipal extends JFrame {

    public FenetrePrincipal() {
        setTitle("WarGame");
        setSize(1300, 900);
        setLocationRelativeTo(null);

        BackgroundMenu backgroundPanel = new BackgroundMenu();
        setContentPane(backgroundPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("WarGame");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jouerButton = new JButton("Jouer");
        jouerButton.setFont(new Font("Arial", Font.BOLD, 30));
        jouerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton continuerButton = new JButton("Continuer");
        continuerButton.setFont(new Font("Arial", Font.BOLD, 30));
        continuerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton optionButton = new JButton("Options");
        optionButton.setFont(new Font("Arial", Font.BOLD, 30));
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton aideButton = new JButton("Aide");
        aideButton.setFont(new Font("Arial", Font.BOLD, 30));
        aideButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jouerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FenetrePseudo playerInfoFrame = new FenetrePseudo();
                playerInfoFrame.setVisible(true);
            }
        });
        OptionsFrame optionsFrame = new OptionsFrame();

        optionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionsFrame.setVisible(true);
            }
        });

        aideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bienvenue dans WarGame !\n\n" +
                        "- Cliquez sur le bouton \"Jouer\" pour commencer le jeux et remplissez les informations du joueur." +
                        "\n\n- Déplacez vos unités sur le plateau pour obtenir des positions avantageuses et éviter les pièges ennemis. " +
                        "\n\n- Chaque unité a une limite de déplacement par tour. " +
                        "\n\n- Les combats se déclenchent lorsque vos unités rencontrent des unités ennemies et sont résolus en comparant leurs capacités d'attaque et de défense. " +
                        "\n\n- Utilisez vos unités avec une attaque plus élevée pour attaquer les unités ennemies plus faibles.." +
                        "\n\n- Le terrain a un impact sur le mouvement et les combats." +
                        "\n\n- Certaines zones peuvent ralentir vos unités ou leur fournir une protection supplémentaire." +
                        "\n\n- Soyez attentif à la santé de vos unités. Elles peuvent subir des dégâts lors des combats." +
                        "\n\n- Si une unité perd tous ses points de vie, elle est éliminée du jeu." +
                        "\n\n- Utilisez des tactiques défensives pour protéger vos unités et des tactiques offensives pour affaiblir les unités ennemies." +
                        "\n\n- Le jeu se déroule en tours alternés avec votre adversaire." +
                        "\n\n- Pendant votre tour, vous pouvez déplacer vos unités et les engager dans des combats." +
                        "\n\n- Le jeu se termine lorsque l'un des joueurs atteint l'objectif de victoire défini." +
                        "\n\n- Le joueur 1 est en rouge et le joueur 2 en bleu.\n"+
                        "\n");
            }
        });

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(jouerButton);
        mainPanel.add(continuerButton);
        mainPanel.add(optionButton);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(aideButton);

        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        backgroundPanel.add(mainPanel, gbc);
    }
}
