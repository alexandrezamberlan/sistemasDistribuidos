
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author usrlab25
 */
public class Correntista {
    String nome;
    //List<Conta> contasBancarias;
    HashSet<Conta> contasBancarias = new HashSet<>();

    public Correntista(String nome, HashSet<Conta> contasBancarias) {
        this.nome = nome;
        //this.contasBancarias.addAll(contasBancarias);
    }
    
    
}
