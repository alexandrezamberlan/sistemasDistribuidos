package exemplo1;

import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    String HOST_URL = "rmi://localhost/Incrementa";
    
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Incrementa c = new Incrementa();
            Naming.bind(HOST_URL, c);
            System.out.println("Servidor online e a espera de clientes...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void main(String args[]) {
        new Server();
    }
}



