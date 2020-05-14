/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme
 */
public interface ISoma extends Remote{
    
    public double add(double a, double b) throws RemoteException;
}
