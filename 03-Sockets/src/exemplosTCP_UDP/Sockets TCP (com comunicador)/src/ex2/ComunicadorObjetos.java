import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ComunicadorObjetos {

    public static Pessoa recebeObjeto(Socket s) {
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber um objeto do tipo Pessoa de um socket s
            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream());
            Pessoa p = (Pessoa) leitor.readObject();
            return p;
        } catch (Exception e) {
            return null;
        }
    }

    public static void enviaObjeto(Socket s, Pessoa p) {
        try {
            //Cria um objeto de fluxo de dados de de saída, para poder enviar dados pelo socket s
            ObjectOutputStream escritor = new ObjectOutputStream(s.getOutputStream());
            System.out.println("Enviarei " + p.getNome()+","+p.getIdade());
            escritor.writeObject(p);
            escritor.close();
        } catch (Exception e) {
        }
    }
    
    public static String recebeMensagem(Socket s) {
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber dados de um socket s
            DataInputStream leitor = new DataInputStream(s.getInputStream());
            String mensagem = leitor.readUTF();
            leitor.close();
            return mensagem;
        } catch (Exception e) {
            return null;
        }
    }

    public static void enviaMensagem(Socket s, String mensagem) {
        try {
            //Cria um objeto de fluxo de dados de de saída, para poder enviar dados pelo socket s
            DataOutputStream escritor = new DataOutputStream(s.getOutputStream());
            System.out.println("Enviarei " + mensagem);
            escritor.writeUTF(mensagem);
        } catch (Exception e) {
        }
    }
}
