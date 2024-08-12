
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe com métodos estáticos para movimentar botão nas 4 direções
 * @author laboratorio
 */
public class Movimenta {
    /**
     * Método estático que leva o botão 5 pixels para cima
     * @param botao 
     */
    public static void irCima(JButton botao) {
        if (botao.getY() > 0) {
            botao.setBounds(botao.getX(), botao.getY() - 5, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static boolean irEsquerda(JButton botao) {
        if (botao.getX() > 0) {
            botao.setBounds(botao.getX() - 5, botao.getY(), botao.getWidth(), botao.getHeight());            
        }
        return false;
    }
    
    public static void irBaixo(JButton botao, int altura) {
        if (botao.getY() < altura - 70) {
            botao.setBounds(botao.getX(), botao.getY() + 5, botao.getWidth(), botao.getHeight());
        }
    }
    
    public static boolean irDireita(JButton botao, int largura) {
        if (botao.getX() < largura - 70) {
            botao.setBounds(botao.getX() + 5, botao.getY(), botao.getWidth(), botao.getHeight());
        }
        return false;
    }
    
    public static boolean pegou(JButton origem, JButton destino) {
        return origem.getBounds().intersects(destino.getBounds());
    }
    
    public static void sorteiaPosicao(JButton botao, JFrame frame) {
        Random gerador = new Random();
        botao.setBounds(gerador.nextInt(frame.getWidth() - 80), 
                        gerador.nextInt(frame.getHeight() - 80), 
                        botao.getWidth(), botao.getHeight());
    }
}
