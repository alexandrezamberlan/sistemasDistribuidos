/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme
 */
public interface IServerString extends Remote {

    public int contaCaracteres(String s) throws RemoteException;
    
}
