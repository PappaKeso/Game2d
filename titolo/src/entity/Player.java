package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.security.Key;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp= gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_0.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y-= speed;
        }
        else if (keyH.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
    //    g2.setColor(Color.white);
   //     g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        BufferedImage image = null;
        switch(direction){
            case "up":
                image=up1;
                break;
            case "down":
                image=down1;
                break;
            case "left":
                image=left1;
                break;
            case "right":
                image=right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
