package exemplo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerString extends UnicastRemoteObject implements IServerString  {

    public ServerString() throws RemoteException {
    }

    public int contaCaracteres(String s) throws RemoteException {
        int conta = s.length();
        System.out.println("Servidor atendeu e retorna: " + conta);
        return conta;
    }

    

}
