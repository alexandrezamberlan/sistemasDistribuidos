import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
/**
 *
 * @author Patrick
 */
public class Chat extends UnicastRemoteObject implements IChat{
    public LinkedList<String> listaMensagens;

    public Chat() throws RemoteException{
        listaMensagens = new LinkedList<>();
    }
    
    @Override
    public void receberMensagem(String frase) throws RemoteException{
        listaMensagens.add(frase);
        //System.out.println(frase);
    }

    @Override
    public LinkedList<String> lerMensagem()throws RemoteException{
        return listaMensagens;
    }
}
