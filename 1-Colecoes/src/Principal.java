
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author usrlab25
 */
public class Principal {
    public static void main(String[] args) {
        Correntista c1 = new Correntista("Frederico", new HashSet());
        
        c1.contasBancarias.add(new ContaCorrente("5051-2", "59999-9", 5000, 10000));
        
        ContaCorrente outra = new ContaCorrente("5051-2", "59999-9", 50, 10);
        
        if ( c1.contasBancarias.add(outra) ) {
            //System.out.println("Ufaaa. vou inserir");
        }else{
            System.out.println("Conta já cadastrada!");
        }
        
        
        
        for (Iterator it = c1.contasBancarias.iterator(); it.hasNext();) {
            ContaCorrente conta = (ContaCorrente)it.next();
            System.out.println("Agencia: " + conta.numeroAgencia + 
                        "\nConta: " + conta.numeroConta + "\nSaldo: " + conta.saldo);
        }
            
            
         
    }
}
