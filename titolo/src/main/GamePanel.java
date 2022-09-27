package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    final int originalTileSize = 64;
    final int scale = 1;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 23;//16
    final int maxScreenRow = 12;//12
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);
    //set player position
    int playerX=100;
    int playerY=100;
    int playerSpeed =8;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
      /*  double drawInterval = 1000000000/FPS;//0.01666
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            this.update();

            repaint();

            try {
                double remaningTime = nextDrawTime - System.nanoTime();
                remaningTime = remaningTime / 1000000;
                if (remaningTime < 0) {
                    remaningTime = 0;
                }
                Thread.sleep((long) remaningTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    public void update()
    {
    player.update();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
