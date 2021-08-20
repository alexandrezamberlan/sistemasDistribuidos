package ex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Emissor {

    public static void main(String[] args) {
        try {
            //Criar o socket UDP
            DatagramSocket socket = new DatagramSocket();
            Scanner teclado = new Scanner(System.in);
            while (true) {
                //leitura pelo teclado da mensagem a ser enviada
                String mensagem = teclado.nextLine();
                //especifico o endereço do destinatario
                InetAddress destinatario = InetAddress.getByName("localhost");
                //Criar o pacote datagrama com a mensagem e os dados do destinatario
                DatagramPacket pacote = new DatagramPacket(mensagem.getBytes(),
                        mensagem.getBytes().length,
                        destinatario,
                        1234);
                socket.send(pacote);
            }
        } catch (Exception ex) {
            Logger.getLogger(Emissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
