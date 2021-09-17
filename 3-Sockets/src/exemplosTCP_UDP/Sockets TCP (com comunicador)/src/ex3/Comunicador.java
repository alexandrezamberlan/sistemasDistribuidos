import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Comunicador {

    public static String recebeMensagem(Socket s) {
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber dados de um socket s
            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream());
            String mensagem = (String)leitor.readObject();
            return mensagem;
        } catch (Exception e) {
            return null;
        }
    }

    public static void enviaMensagem(Socket s, String mensagem) {
        try {
            //Cria um objeto de fluxo de dados de de saída, para poder enviar dados pelo socket s
            ObjectOutputStream escritor = new ObjectOutputStream(s.getOutputStream());
            escritor.writeObject(mensagem);
        } catch (Exception e) {
        }
    }
}
