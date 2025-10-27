
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IComunicacaoCliente extends Remote {
    
    public void receberMensagemDoServidor(String msg) throws RemoteException;
}
