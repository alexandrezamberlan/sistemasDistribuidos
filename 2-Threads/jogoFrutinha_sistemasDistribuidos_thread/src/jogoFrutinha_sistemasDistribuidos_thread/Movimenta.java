package jogoFrutinha_sistemasDistribuidos_thread;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Movimenta {
	public static boolean irCima(JButton botao) {
        if (botao.getY() > 0) {
            botao.setBounds(botao.getX(), botao.getY() - 10, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }
    
    public static boolean irEsquerda(JButton botao) {
        if (botao.getX() > 0) {
            botao.setBounds(botao.getX() - 10, botao.getY(), botao.getWidth(), botao.getHeight());      
            return true;
        }
        return false;
    }
    
    public static boolean irBaixo(JButton botao, int altura) {
        if (botao.getY() < altura - 70) {
            botao.setBounds(botao.getX(), botao.getY() + 10, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }
    
    public static boolean irDireita(JButton botao, int largura) {
        if (botao.getX() < largura - 70) {
            botao.setBounds(botao.getX() + 10, botao.getY(), botao.getWidth(), botao.getHeight());
            return true;
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
    
    public static void esquerdaDireita(JButton botao, JFrame frame) {
    	do {
    		while (Movimenta.irDireita(botao, frame.getWidth())) {
	    		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		
    		while (Movimenta.irEsquerda(botao)) {
	    		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	} while (true);
    }

}
