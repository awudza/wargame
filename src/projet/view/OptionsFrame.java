package projet.view;

import projet.view.events.AnnulerListener;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OptionsFrame extends JFrame {
    private Clip audioClip;

    public OptionsFrame() {
        setTitle("Options");
        setSize(1300, 900);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();

        BackgroundMenu backgroundPanel=new BackgroundMenu();
        setContentPane(backgroundPanel);
        mainPanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Paramètres du son");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton playButton = new JButton();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("../../Lecture.png"));
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        playButton.setIcon(resizedIcon);

        JButton stopButton = new JButton();
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("../../Eteindre.png"));
        Image image1 = imageIcon1.getImage();
        Image resizedImage1 = image1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
        stopButton.setIcon(resizedIcon1);
        playAudio();


        JButton retour=new JButton("Retour au Menu");
        retour.setFont(new Font("Arial", Font.BOLD, 18));
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(playButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(stopButton, gbc);

        gbc.gridy=3;
        mainPanel.add(retour,gbc);

        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        backgroundPanel.add(mainPanel, gbc);


    }

    private void playAudio() {
        try {
            File file=new File("src/resources/Song.wav");
                audioClip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                audioClip.open(audioInputStream);
                audioClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
        }
    }
}