import java.io.*; 
import java.net.*;

public class EnviadorUDP {
    DatagramSocket socket;

    public EnviadorUDP() {
        criaClientSocket();
        DatagramPacket pacote;

        for (int i = 0; i < 10; i++) {
                pacote = ComunicadorUDP.montaMensagem("Msg: " + (i+1) + " Ola mundo", "localhost", 1234);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                ComunicadorUDP.enviaMensagem(socket, pacote);
        }
    }

    private void criaClientSocket() {
        try {
            //Cria um socket datagrama para enviar dados
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EnviadorUDP enviador = new EnviadorUDP();
    }
}
