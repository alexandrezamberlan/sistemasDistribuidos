import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Comunicador {

    public static String receberMensagem(Socket s) {
        String msg = new String();
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber um objeto do tipo Pessoa de um socket s
            ObjectInputStream leitor = new ObjectInputStream(s.getInputStream());
            msg = (String) leitor.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Problemas para enviar a mensagem");
        }
        return msg;
    }

    public static void enviarMensagem(Socket s, String msg) {
        try {
            //Cria um objeto de fluxo de dados de de saída, para poder enviar dados pelo socket s
            ObjectOutputStream escritor = new ObjectOutputStream(s.getOutputStream());
//            System.out.println("Enviarei " + p.getNome()+","+p.getIdade());
            escritor.writeObject(msg);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Problemas para para receber mensagens");
        }
    }
}