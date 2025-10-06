import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGeraDados extends Remote {
    public String geraEmail(String nome) throws RemoteException;
    public String geraHash(String nome) throws RemoteException;
}
