package ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Comunicador {

    // public Comunicador() {

    // }

    public static String recebeMensagem(Socket s) {
        try {
            //Cria um objeto de fluxo de dados de entrada, para poder receber dados de um socket s
            DataInputStream leitor = new DataInputStream(s.getInputStream());
            String mensagem = leitor.readUTF();
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
