import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface IComunica extends Remote{
    public void enviarPosicaoJogador(Componente jogador) throws RemoteException;

    public LinkedList receberPosicoesJogadores()throws RemoteException;
    
//    public void enviarPosicaoFrutinha(Componente frutinha) throws RemoteException;
//    
//    public Componente receberPosicaoFrutinha() throws RemoteException;
}
