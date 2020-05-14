import java.io.*; 
import java.net.*;

public class EnviadorUDP {

    DatagramSocket socket;

    private void criaClientSocket() {
        try {
            //Cria um socket datagrama para enviar dados
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public EnviadorUDP() {
        criaClientSocket();
        ComunicadorUDP com = new ComunicadorUDP();
        DatagramPacket pacote;

        for (int i = 0; i < 10; i++) {
            pacote = com.montaMensagem("Msg: " + (i+1) + " Ola mundo", "localhost", 1234);
            com.enviaMensagem(socket, pacote);
        }
    }

    public static void main(String[] args) {
        EnviadorUDP c = new EnviadorUDP();
    }
}
