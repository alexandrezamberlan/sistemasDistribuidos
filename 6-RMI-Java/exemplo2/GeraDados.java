import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GeraDados extends UnicastRemoteObject implements IGeraDados {
    public GeraDados() throws RemoteException {
    }

    @Override
    public String geraEmail(String nome) throws RemoteException {        
        String vetorNomes[];
        vetorNomes = nome.toLowerCase().split(" ");
        System.out.println("Nome recebido.... " + nome);
        if (vetorNomes.length <= 1) { 
            return "Nao foi possivel gerar email";
        } 

        return vetorNomes[0] + "." + vetorNomes[vetorNomes.length-1] + "@ufn.edu.br";
    }

    @Override
    public String geraHash(String nome) throws RemoteException {
        if (nome.equals("")) {
            return "Nao foi possivel gerar hash";
        }
        return ""+nome.hashCode();
    }
}
