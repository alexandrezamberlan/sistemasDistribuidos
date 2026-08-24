package exemplo1;

import java.rmi.*;

interface IIncrementa extends Remote {

    public int inc(int x) throws RemoteException;
    public int dec(int x) throws RemoteException;
} 

	
	
	
	
