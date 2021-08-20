
import static java.lang.Math.max;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab01
 */
public class BallController implements Runnable {
    JPanel board;
    JButton ball;
    JButton p1;
    JButton p2;
    ScoreController score;
    int collision_counter = 0;
    boolean on_round = false;
    int delay = 14;
    int l_speed = 0;
    int v_speed = 0;
    boolean moveUp = false, moveDown = false, moveRight = false, moveLeft = false;

    public BallController(JPanel board, JButton ball, JButton p1, JButton p2, ScoreController score) {
        this.board = board;
        this.ball = ball;
        this.p1 = p1;
        this.p2 = p2;
        this.score = score;
    }

    
    @Override
    public void run() {
        on_round = false;
        startRound();
        while(true){
            try
            {
                while(true) 
                {
                    if((moveUp)){
                        moveUp(v_speed);
                    }

                    else if(moveDown){
                        moveDown(v_speed);
                    }
                    
                    if(moveRight){
                        moveRight(l_speed);
                    }
                    
                    else if (moveLeft){
                        moveLeft(l_speed);
                    }
                Thread.sleep(delay);
                }
            }catch(InterruptedException ex){

            }
        }
    }
    
    public void moveUp(int n){
        if(ball.getY() + n > 4){
            ball.setLocation(ball.getX(), ball.getY() - n);
        }else{
            moveUp = false;
            moveDown = true;
        }  
    }
    
    public void moveDown(int n){
        if(ball.getY() + ball.getHeight() + n < board.getHeight()){
            ball.setLocation(ball.getX(), ball.getY() + n);
        }else{
            moveDown = false;
            moveUp = true;
        }
    }
    
    public void moveRight(int n){
        if((ball.getX() + ball.getWidth() + n >= p2.getX()) && (((ball.getY() + ball.getHeight() >= p2.getY())) && (ball.getY() <= p2.getY() + p2.getHeight())))
        {
            moveRight = false;
            moveLeft = true;
            if(delay > 4){
                delay -= 1;
            } 
        }else if(ball.getX() + ball.getWidth() + n >= board.getWidth())
        {
            scorePoint(1);
        }else
        {
            ball.setLocation(ball.getX() + n, ball.getY());
        }
    }
    
    public void moveLeft(int n){
        if((ball.getX() - n <= p1.getX() + p1.getWidth()) && ((ball.getY() + ball.getHeight() >= p1.getY()) && (ball.getY() <= p1.getY() + p1.getHeight())))
        {
            moveLeft = false;
            moveRight = true;
            if(delay > 4){
                delay -= 1;
            }
        }else if(ball.getX() - n <= 4)
        {
            scorePoint(2);
        }else
        {
            ball.setLocation(ball.getX() - n, ball.getY());
        }
    }
    
    public void scorePoint(int n){
        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;
        
        ball.setLocation(board.getWidth()/2, board.getHeight()/2);
        score.increaseScore(n);
        on_round = false;
    }
    
    public void startRound(){
        if(!on_round){
            score.setInstructions("Jogando...");
            if(score.game_ended){
                score.resetScore();
            }
            on_round = true; 
            int val = (int) (Math.random() * (4 - 1 + 1) + 1);
            delay = 14;
            switch (val){
                case 1:{
                    moveLeft = true;
                    moveDown = true;
                    moveRight = false;
                    moveUp = false;    
                    break;
                }
                case 2:{
                    moveLeft = false;
                    moveDown = true;
                    moveRight = true;
                    moveUp = false;
                    break;
                }

                case 3:{
                    moveLeft = true;
                    moveDown = false;
                    moveRight = false;
                    moveUp = true;
                    break;
                }

                case 4:{
                    moveLeft = false;
                    moveDown = false;
                    moveRight = true;
                    moveUp = true;
                    break;
                }
            }

            int speed = (int) (Math.random() * (5 - 1 + 1) + 1);
            switch (speed){
                case 1:{
                    l_speed = 3;
                    v_speed = 4;
                    break;
                }
                case 2:{
                    l_speed = 3;
                    v_speed = 3;
                    break;
                }
                case 3:{
                    l_speed = 4;
                    v_speed = 2;
                    break;
                }
                case 4:{
                    l_speed = 4;
                    v_speed = 1;
                    break;
                }
                case 5:{
                    l_speed = 2;
                    v_speed = 4;
                    break;
                }
            }
        }    
    }
}
