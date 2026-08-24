import java.io.Serializable;
/**
 *
 * @author alexandrezamberlan
 */
public class Componente implements Serializable {
    public static final int FRUTA = 1, JOGADOR = 2;
    public int x;
    public int y;
    public int largura;
    public int altura;
    public int tipo;

    public Componente(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }
}
