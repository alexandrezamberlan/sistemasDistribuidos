
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab06
 */
public class ScoreController {
    JLabel label_p1_score;
    JLabel label_p2_score;
    JLabel instructions;
    int p1_score = 0;
    int p2_score = 0;
    boolean game_ended = false;

    public ScoreController(JLabel label_p1_score, JLabel label_p2_score, JLabel instructions) {
        this.label_p1_score = label_p1_score;
        this.label_p2_score = label_p2_score;
        this.instructions = instructions;
    }
    
    public void increaseScore(int n){
        if(n == 1){
            p1_score += 1;
            label_p1_score.setText("" + p1_score);
            if(p1_score == 5){
                instructions.setText("JOGADOR LARANJA GANHOU!!!");
                game_ended = true;
            }else{
                instructions.setText("Jogador Laranja marcou um ponto");
            }
        }else{
            p2_score += 1;
            label_p2_score.setText("" + p2_score);
            if(p2_score == 5){
                instructions.setText("JOGADOR AZUL GANHOU!!!");
                game_ended = true;
            }else{
                instructions.setText("Jogador Azul marcou um ponto");
            }
        }
    }
    
    public void resetScore(){
        p1_score = 0;
        p2_score = 0;
        
        game_ended = false;
        
        label_p1_score.setText("" + p1_score);
        label_p2_score.setText("" + p2_score);
        
        instructions.setText("O jogo começou");
    }
    
    public void setInstructions(String ins){
        this.instructions.setText(ins);
    }
}
