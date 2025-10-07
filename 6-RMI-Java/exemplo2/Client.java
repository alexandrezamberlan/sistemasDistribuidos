import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String HOST_URL = "rmi://10.104.12.12/GeraDados";
        Scanner teclado = new Scanner(System.in);
        try {
            IGeraDados interfaceRemota = (IGeraDados) Naming.lookup(HOST_URL);
            System.out.println("Servicos vindos do servidor ....");
            String nome;
            System.out.print("Nome completo: ");
            nome = teclado.nextLine();

            System.out.println("Email gerado... " + interfaceRemota.geraEmail(nome));
            System.out.println("Has gerado... " + interfaceRemota.geraHash(nome));
        } catch (Exception e) {
            System.out.println("Erro de conexão ou " + e);
        }
    }    
}
