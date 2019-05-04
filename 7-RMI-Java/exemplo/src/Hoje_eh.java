import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class Hoje_eh extends UnicastRemoteObject implements IHoje_eh {

    public Hoje_eh() throws RemoteException{
        
    }
    
    @Override
    public DataHora pegaDataHora() throws RemoteException {     
        DataHora obj = new DataHora();
        return obj;
    }   
}
