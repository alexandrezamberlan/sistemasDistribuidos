import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Hoje_eh extends UnicastRemoteObject implements IHoje_eh {
    public Hoje_eh() throws RemoteException{
        
    }
    
    @Override
    public String pegaDataHora() throws RemoteException {     
        Date obj = new Date();
        return obj.toString();
    }   
}
