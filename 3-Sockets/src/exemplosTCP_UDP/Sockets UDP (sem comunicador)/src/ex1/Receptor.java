package ex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptor {

    public static void main(String[] args) {
        try {
            //crio um socket udp na porta 1234
            DatagramSocket socket = new DatagramSocket(1234);
            //crio um pacote datagrama "vazio" para recebimento de até 100 bytes
            DatagramPacket pacoteRecebido = new DatagramPacket(new byte[100], 100);
            while (true) {
                //aguardo (bloqueado) uma mensagem chegar pela rede
                socket.receive(pacoteRecebido);
                //extraio os bytes dos dados da mensagem
                byte buffer[] = pacoteRecebido.getData();
                //converto os bytes em string
                String mensagemRecebida = new String(buffer, 0, pacoteRecebido.getLength());
                //exibo na tela a mensagem recebida
                System.out.println("Recebi: " + mensagemRecebida);
            }
        } catch (Exception ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
