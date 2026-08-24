package exemplo3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Soma extends UnicastRemoteObject implements ISoma{

    public Soma() throws RemoteException{
        
    }
    
    public double add(double a, double b) throws RemoteException {
        return a+b;
    }
    
    
}
