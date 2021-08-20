public class ContaCorrente extends Conta{
    double limite;

    
    
    /**
     * Construtor que instancia contas do tipo corrente
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo
     * @param limite
     */
    public ContaCorrente(String numeroAgencia, String numeroConta, double saldo, double limite) {
        super(numeroAgencia, numeroConta, saldo);
        this.limite = limite;
    }
    
    

    @Override
    public String toString() {
        return "ContaCorrente{Agencia=" + numeroAgencia +
                "Conta=" + numeroConta + "limite=" + limite + '}';
    }


    
    
    
    
}
