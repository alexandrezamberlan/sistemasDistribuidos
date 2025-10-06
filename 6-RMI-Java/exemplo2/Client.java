import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String HOST_URL = "rmi://10.103.16.8/GeraDados";
        Scanner teclado = new Scanner(System.in);
        try {
            IGeraDados objetoRemoto = (IGeraDados) Naming.lookup(HOST_URL);
            System.out.println("Servicos vindos do servidor ....");
            String nome;
            System.out.print("Nome completo: ");
            nome = teclado.nextLine();

            System.out.println("Email gerado... " + objetoRemoto.geraEmail(nome));
            System.out.println("Has gerado... " + objetoRemoto.geraHash(nome));
        } catch (Exception e) {
            System.out.println("Erro de conexão ou " + e);
        }
    }    
}
