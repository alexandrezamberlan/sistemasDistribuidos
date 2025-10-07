import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHoje_eh extends Remote {  
    public String pegaDataHora() throws RemoteException;
}
