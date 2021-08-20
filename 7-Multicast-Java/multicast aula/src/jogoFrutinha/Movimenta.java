package jogoFrutinha;

import java.util.Random;
import javax.swing.JButton;

public class Movimenta {
    public static void irEsquerda(JButton botao) {
        int x = botao.getBounds().x - 20;
        if (x < 0) return;
        botao.setBounds(x, botao.getBounds().y, botao.getBounds().width, botao.getBounds().height);
    }
    
    public static void irCima(JButton botao) {
        int y = botao.getBounds().y - 20;
        if (y < 0) return;
        botao.setBounds(botao.getBounds().x, y, botao.getBounds().width, botao.getBounds().height);
    }
    
    public static void irDireita(JButton botao, int largura) {
        int x = botao.getBounds().x + 20;
        if (x > largura - botao.getBounds().width) return;
        botao.setBounds(x, botao.getBounds().y, botao.getBounds().width, botao.getBounds().height);
    }
    
    public static void irBaixo(JButton botao, int altura) {
        int y = botao.getBounds().y + 20;
        if (y > altura - botao.getBounds().height) return;
        botao.setBounds(botao.getBounds().x, y, botao.getBounds().width, botao.getBounds().height);
    }
    
    public static boolean pegou(JButton botao1, JButton botao2) {
        return botao1.getBounds().intersects(botao2.getBounds());
    }
    
    public static void posicionaAleatorio(JButton botao, int largura, int altura) {
        Random gerador = new Random();
        int x = gerador.nextInt(largura - botao.getBounds().width);
        int y = gerador.nextInt(altura - botao.getBounds().height);
        botao.setBounds(x, y, botao.getBounds().width, botao.getBounds().height);   
    }
}
