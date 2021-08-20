
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab09
 */
public interface IComunicacaoCliente extends Remote {
    
    public void recebeMensagemDoServidor(String msg) throws RemoteException;
}
