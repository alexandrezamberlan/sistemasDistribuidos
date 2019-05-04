import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    
    String HOST_URL = "rmi://localhost/Hoje_eh";
            
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Hoje_eh objetoRemoto = new Hoje_eh();
            Naming.bind(HOST_URL, objetoRemoto);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String args[]){
        new Server();
    }
}
