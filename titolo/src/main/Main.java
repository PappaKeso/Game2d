package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame w = new JFrame();

        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.setTitle("2D game");

        GamePanel gamePanel = new GamePanel();
        w.add(gamePanel);
        w.pack();

        w.setLocationRelativeTo(null);
        w.setVisible(true);

        gamePanel.startGameThread();
    }

}
