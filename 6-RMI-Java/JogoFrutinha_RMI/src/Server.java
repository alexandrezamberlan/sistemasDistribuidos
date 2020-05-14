import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Patrick
 */
public class Server {
    
    String HOST_URL = "rmi://localhost/Chat";
            
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Chat objetoRemoto = new Chat();
            Naming.bind(HOST_URL, objetoRemoto);
            System.out.println("Servidor em execução e aguardando conexões");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException ex) {

        }
    }
    
    public static void main(String args[]){
        new Server();
    }
}
