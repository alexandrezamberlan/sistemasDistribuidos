
import java.io.Serializable;
import java.util.Objects;
import javax.swing.JButton;


public class Componente implements Serializable {
    public String apelido;
    public int x;
    public int y;
    public int largura;
    public int altura;

    public JButton botao;
    
    public Componente(String apelido, int x, int y, int largura, int altura) {
        this.apelido = apelido;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.botao = new JButton(apelido);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.apelido);
        hash = 83 * hash + this.x;
        hash = 83 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Componente other = (Componente) obj;
//        if (this.x != other.x) {
//            return false;
//        }
//        if (this.y != other.y) {
//            return false;
//        }
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Componente{" + "apelido=" + apelido + ", x=" + x + ", y=" + y + ", largura=" + largura + ", altura=" + altura + '}';
    }    
}
