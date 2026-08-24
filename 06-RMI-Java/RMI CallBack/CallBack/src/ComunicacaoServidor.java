
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ComunicacaoServidor extends UnicastRemoteObject implements IComunicacaoServidor {

    IComunicacaoCliente c;
    ServidorFrame s;

    public ComunicacaoServidor(ServidorFrame s) throws RemoteException {
        this.s = s;
    }

    @Override
    public void receberCliente(IComunicacaoCliente c) throws RemoteException {
        this.c = c;
        s.adicionaMsg("Recebi um cliente");
    }

    @Override
    public void receberMensagemDoCliente(String msg) throws RemoteException {
        s.adicionaMsg(msg);
    }

    public void enviaMsgProCliente(String msg) {
        try {
            c.receberMensagemDoServidor(msg);
        } catch (RemoteException ex) {
        }
    }
}
