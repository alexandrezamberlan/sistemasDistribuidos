
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab01
 */
public class PlayerController implements Runnable {
    
    JButton player;
    JPanel board;
    int speed = 2;
    int delay = 4;
    boolean moveUp = false, moveDown = false;
    
    PlayerController(JButton player, JPanel board){
        this.player = player;
        this.board = board;
    }
    
    @Override
    public void run() 
    {
        try
        {
            while(true) 
            {
                if(moveUp){
                    moveUp(speed);
                }

                else if(moveDown){
                    moveDown(speed);
                }
            Thread.sleep(delay);
            }
        }catch(InterruptedException ex){
            
        }
    }

    public boolean willMoveUp() {
        return moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public boolean willMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }
    
    public void moveUp(int n){
        if(player.getY() + n > 6){
            player.setLocation(player.getX(), player.getY() - n);
        }
    }
    
    public void moveDown(int n){
        if(player.getY() + player.getHeight() + n < board.getHeight()){
            player.setLocation(player.getX(), player.getY() + n);
        }
    }
    
    
}
