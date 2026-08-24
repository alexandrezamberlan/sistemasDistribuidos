package ex1;
import java.io.*; 
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EnviadorUDP {
    DatagramSocket socket;

    public EnviadorUDP() {
        criaClientSocket();
        DatagramPacket pacote;
        
        ArrayList<String> lista = new ArrayList<>(Arrays.asList("maça", "banana", "pera", "abacaxi", "goiaba"));
        
        for (String fruta : lista) {
                pacote = ComunicadorUDP.montaMensagem(fruta, "localhost", 1234);
                try {
                    Thread.sleep(5000);
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
