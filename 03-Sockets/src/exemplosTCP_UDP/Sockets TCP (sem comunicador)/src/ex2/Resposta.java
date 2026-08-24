package ex2;

import java.io.Serializable;

public class Resposta implements Serializable {
    private int valor;

    public Resposta(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
