import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    String HOST_URL = "rmi://10.103.16.8/GeraDados";
    
    public Server() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("Porta padrao do RMI Java..." + Registry.REGISTRY_PORT);
            GeraDados objeto_remoto = new GeraDados();
            System.out.println("Servidor retornando....");
            Naming.rebind(HOST_URL, objeto_remoto);
        } catch (Exception e) {
            System.out.println("Erro de conexão ou " + e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
