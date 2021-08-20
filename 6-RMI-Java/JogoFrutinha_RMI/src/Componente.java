
import java.io.Serializable;
import java.util.Objects;


public class Componente implements Serializable {
    public static final int FRUTA = 1, JOGADOR = 2;
    public int x;
    public int y;
    public int largura;
    public int altura;
    public int tipo;
    public String apelido;

    public Componente(String apelido, int x, int y, int largura, int altura) {
        this.apelido = apelido;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.apelido);
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
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        return true;
    }
    
    
}

