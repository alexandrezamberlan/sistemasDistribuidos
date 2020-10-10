import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Server {
    
    String HOST_URL = "rmi://localhost/Comunica";
            
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Comunica objetoRemoto = new Comunica();
            Naming.bind(HOST_URL, objetoRemoto);
            JOptionPane.showMessageDialog(null,"Servidor em execução e aguardando conexões para jogar a Frutinha");
        } catch (MalformedURLException | AlreadyBoundException | RemoteException ex) {

        }
    }
    
    public static void main(String args[]){
        new Server();
    }
}
