import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import javax.swing.JButton;

public interface IComunica extends Remote{
    public void enviarPosicaoJogador(JButton jogador) throws RemoteException;

    public LinkedList receberPosicoesJogadores()throws RemoteException;
    
//    public void enviarPosicaoFrutinha(Componente frutinha) throws RemoteException;
//    
//    public Componente receberPosicaoFrutinha() throws RemoteException;
}
