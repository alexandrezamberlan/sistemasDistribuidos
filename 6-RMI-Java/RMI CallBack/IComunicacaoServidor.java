
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
public interface IComunicacaoServidor extends Remote {
    
    public void recebeCilente(IComunicacaoCliente c) throws RemoteException;
    public void recebeMensagemDoCliente(String msg) throws RemoteException;
}
