import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


public class Comunica extends UnicastRemoteObject implements IComunica{
    public LinkedList<Componente> listaJogadores;

    public Comunica() throws RemoteException{
        listaJogadores = new LinkedList<>();
    }
    
    @Override
    public void enviarPosicaoJogador(Componente jogador) throws RemoteException {
        listaJogadores.add(jogador);
        System.out.println(jogador.x + "," + jogador.y);
    }

    @Override
    public LinkedList receberPosicoesJogadores()throws RemoteException {
        return listaJogadores;
    }
    
}
