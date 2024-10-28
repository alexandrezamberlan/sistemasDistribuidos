package jogoFrutinha;

import java.io.Serializable;

public class Componente implements Serializable {
    public String texto;
    public int largura;
    public int altura;

    public Componente(String texto, int largura, int altura) {
        this.texto = texto;
        this.largura = largura;
        this.altura = altura;
    }
}
