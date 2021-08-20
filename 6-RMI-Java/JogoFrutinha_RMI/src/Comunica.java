import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


public class Comunica extends UnicastRemoteObject implements IComunica{
    public LinkedList<Componente> listaJogadores;

    public Comunica() throws RemoteException{
        listaJogadores = new LinkedList<>();
    }
    
    @Override
    public boolean enviarJogador(Componente jogador) throws RemoteException {
        if (!listaJogadores.contains(jogador)) {
            listaJogadores.add(jogador); 
            System.out.println(jogador.apelido + " entrou no jogo!!");
            return true;
        }
        return false;
    }
    
    @Override
    public void atualizarPosicaoJogador(Componente jogador) throws RemoteException {
        int indice = listaJogadores.indexOf(jogador);
        System.out.println(jogador.apelido + " localizado no servidor e será animado em todos os clientes");
    }

    @Override
    public LinkedList receberPosicoesJogadores()throws RemoteException {
        return listaJogadores;
    }
    
}
