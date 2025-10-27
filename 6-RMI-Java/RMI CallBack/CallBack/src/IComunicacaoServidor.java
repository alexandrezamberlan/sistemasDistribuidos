
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IComunicacaoServidor extends Remote {
    
    public void receberCliente(IComunicacaoCliente c) throws RemoteException;
    public void receberMensagemDoCliente(String msg) throws RemoteException;
}
