/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    
    String HOST_URL = "rmi://localhost/Soma";
            
    public Server(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Soma objetoRemoto = new Soma();
            Naming.bind(HOST_URL, objetoRemoto);
        } catch (Exception ex) {

        }
    }
    
    public static void main(String args[]){
        new Server();
    }
}
