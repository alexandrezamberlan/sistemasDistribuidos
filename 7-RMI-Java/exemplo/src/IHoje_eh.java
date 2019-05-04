import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHoje_eh extends Remote{  
    public DataHora pegaDataHora() throws RemoteException;
}
