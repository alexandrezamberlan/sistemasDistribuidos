
import java.util.Date;

/**
 *
 * @author usrlab25
 */
public class ContaPoupanca extends Conta {
    String aniversario;

    /**
     * 
     * @param aniversario
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo 
     */
    public ContaPoupanca(String aniversario, String numeroAgencia, String numeroConta, double saldo) {
        super(numeroAgencia, numeroConta, saldo);
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "ContaPopupanca{Agencia=" + numeroAgencia +
                "Conta=" + numeroConta + "aniversario=" + aniversario + '}';
    }
       
    
}
