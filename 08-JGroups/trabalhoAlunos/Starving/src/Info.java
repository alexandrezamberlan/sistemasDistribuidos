
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Info implements Serializable {
    
    public static int FRUIT = 0;
    public static int PLAYER = 1;
    
    String name;
    int type;
    Rectangle shape;
    int score;
    boolean started = false;
    boolean caught = false;

    public Info(String name, JButton sprite, int score, int type) {
        this.name = name;
        shape = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        this.type = type;
        this.score = score;
    }
    
    public void generatePosition(){
        int x = 0, y = 0;
        Random rand = new Random();
        x = rand.nextInt(Game.panelBoard.getWidth() - shape.width);
        y = rand.nextInt(Game.panelBoard.getHeight() - shape.height);
        this.shape.x = x;
        this.shape.y = y;
    }
}



