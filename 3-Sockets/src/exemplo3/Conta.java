package exemplo3;

import java.io.Serializable;
import javax.swing.JOptionPane;

class Conta implements Serializable {

    int n1;
    int n2;
    String operacao;
    int resposta;

    public Conta() {
        this.n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe primeiro valor inteiro"));
        this.n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe segundo valor inteiro"));
        this.operacao = JOptionPane.showInputDialog(null, "Informe a operacao [+ - / *]");
    }
    
    public void realizarConta(){
        this.n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe primeiro valor inteiro"));
        this.n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe segundo valor inteiro"));
        this.operacao = JOptionPane.showInputDialog(null, "Informe a operacao [+ - / *]");
    }
}
