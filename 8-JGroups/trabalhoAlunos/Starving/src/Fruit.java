
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author gabri
 */
public class Fruit implements Runnable {
    public Info info;
    public JButton sprite;
    public static boolean colided;
    Thread t;
    private final int delay = 3;
    
    @Override
    public void run() {
        while(true){
            try{
                //System.out.println("Fruit - " + this.info.shape);
                for (Bird b: Game.players){
                    if(b.info.shape.intersects(this.info.shape)){
                        b.info.score += 1;
                        this.info.caught = true;
                    }
                }
                Thread.sleep(delay);
            }catch(Exception e){
                
            }
        }
    }

    public Fruit() {
        this.generateSprite();
        this.info = new Info("Fruit", this.getSprite(), -1, Info.FRUIT);
        this.start();
    }
    
    public void start(){
        this.t = new Thread(this);
        t.start();
    }
    
    public void generateSprite()
    {
        sprite = new JButton();
        Game.panelBoard.add(sprite);
        sprite.setVisible(true);
        sprite.setSize(45, 45);
        sprite.setBackground(new Color(255,102,51));
        sprite.setForeground(new Color(51,51,51));
        sprite.setText("Ò");
        sprite.setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    
    
    public void updateInfo(){
        this.setInfo(new Info(this.info.name, this.getSprite(), this.info.score, Info.FRUIT));
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public JButton getSprite() {
        return sprite;
    }

    public void setSprite(JButton sprite) {
        this.sprite = sprite;
    }    
    
}
