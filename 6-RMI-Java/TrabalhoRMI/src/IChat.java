import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
/**
 *
 * @author Patrick
 */
public interface IChat extends Remote {
    public void receberMensagem(String frase) throws RemoteException;

    public LinkedList lerMensagem() throws RemoteException;
}
