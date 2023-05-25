package projet.view;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FenetrePrincipal frame = new FenetrePrincipal();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


