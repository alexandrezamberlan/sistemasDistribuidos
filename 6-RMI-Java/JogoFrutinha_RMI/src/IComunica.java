import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface IComunica extends Remote{
    public boolean enviarJogador(Componente jogador) throws RemoteException;
    
    public void atualizarPosicaoJogador(Componente jogador) throws RemoteException;

    public LinkedList receberPosicoesJogadores()throws RemoteException;
    
//    public void enviarPosicaoFrutinha(Componente frutinha) throws RemoteException;
//    
//    public Componente receberPosicaoFrutinha() throws RemoteException;
}
