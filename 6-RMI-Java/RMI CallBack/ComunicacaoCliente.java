
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ComunicacaoCliente extends UnicastRemoteObject implements IComunicacaoCliente {

    ClienteFrame c;
    public ComunicacaoCliente(ClienteFrame c) throws RemoteException {
        this.c = c;
    }

    @Override
    public void recebeMensagemDoServidor(String msg) throws RemoteException {
        c.adicionaMsg(msg);
    }
}
