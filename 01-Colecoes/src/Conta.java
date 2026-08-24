/**
 *
 * @author usrlab25
 */
public abstract class Conta {
    String numeroAgencia;
    String numeroConta;
    double saldo;

    /**
     * Construtor que serve de molde para instanciar contas corrente ou poupança
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo 
     */
    public Conta(String numeroAgencia, String numeroConta, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    
    @Override
    public int hashCode() {
        return (this.numeroAgencia + this.numeroConta).hashCode();
    }
    
    @Override
     public boolean equals(Object o) {
        if (o instanceof Conta) {
            Conta e = (Conta) o;
            return numeroAgencia.equals(e.numeroAgencia) && numeroConta.equals(e.numeroConta);
        }
        return false;
    }
}
