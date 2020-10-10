import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import javax.swing.JButton;


public class Comunica extends UnicastRemoteObject implements IComunica{
    public LinkedList<JButton> listaJogadores;

    public Comunica() throws RemoteException{
        listaJogadores = new LinkedList<>();
    }
    
    @Override
    public void enviarPosicaoJogador(JButton jogador) throws RemoteException {
        listaJogadores.add(jogador);
        System.out.println("veio uma nova posição de jogador para o servidor que será repassada aos demais clientes");
    }

    @Override
    public LinkedList receberPosicoesJogadores()throws RemoteException {
        return listaJogadores;
    }
    
}
