
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Movimenta {

    public static boolean irCima(JButton botao) {
        if (botao.getY() > 0) {
            botao.setBounds(botao.getX(), botao.getY() - 5, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    public static boolean irEsquerda(JButton botao) {
        if (botao.getX() > 0) {
            botao.setBounds(botao.getX() - 5, botao.getY(), botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    public static boolean irBaixo(JButton botao, int altura) {
        if (botao.getY() < altura - botao.getHeight()-10) {
            botao.setBounds(botao.getX(), botao.getY() + 5, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    public static boolean irDireita(JButton botao, int largura) {
        if (botao.getX() < largura - botao.getWidth()) {
            botao.setBounds(botao.getX() + 5, botao.getY(), botao.getWidth(), botao.getHeight());
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

    public static void movimentaBola(JButton bola, JFrame frame, JButton goleiro1, JButton goleiro2, JTextField gols1, JTextField gols2) {
        int gol1 = 0;
        int gol2 = 0;
        boolean cima = true;
        
        do {
            while (Movimenta.irDireita(bola, frame.getWidth()) && !pegou(bola, goleiro2)) {
                if (cima) {
                    if (!Movimenta.irCima(bola)) {
                        cima = false;
                    }
                } else {
                    if (!Movimenta.irBaixo(bola, frame.getHeight())) {
                        cima = true;
                    }
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (!pegou(bola, goleiro2)) {
//                System.out.println("Gool do goleiro 1");
                gol1 = Integer.parseInt(gols1.getText()) + 1;
                gols1.setText("" + gol1);
            }

            while (Movimenta.irEsquerda(bola) && !pegou(bola, goleiro1)) {
                if (cima) {
                    if (!Movimenta.irCima(bola)) {
                        cima = false;
                    }
                } else {
                    if (!Movimenta.irBaixo(bola, frame.getHeight())) {
                        cima = true;
                    }
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (!pegou(bola, goleiro1)) {
//                System.out.println("Gool do goleiro 2");
                gol2 = Integer.parseInt(gols2.getText()) + 1;
                gols2.setText("" + gol2);
            }
        } while (true);
    }

    public static void esquerdaDireita(JButton bola, JFrame frame, JButton goleiro1, JButton goleiro2, JTextField gols1, JTextField gols2) {
        int gol1 = 0;
        int gol2 = 0;
        do {
            while (Movimenta.irDireita(bola, frame.getWidth()) && !pegou(bola, goleiro2)) {

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (!pegou(bola, goleiro2)) {
                System.out.println("Gool do goleiro 1");
                gol1 = Integer.parseInt(gols1.getText()) + 1;
                gols1.setText("" + gol1);
            }

            while (Movimenta.irEsquerda(bola) && !pegou(bola, goleiro1)) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (!pegou(bola, goleiro1)) {
                System.out.println("Gool do goleiro 2");
                gol2 = Integer.parseInt(gols2.getText()) + 1;
                gols2.setText("" + gol2);
            }
        } while (true);
    }
}
