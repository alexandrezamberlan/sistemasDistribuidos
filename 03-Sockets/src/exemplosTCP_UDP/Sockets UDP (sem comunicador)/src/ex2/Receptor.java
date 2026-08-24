package ex2;

import ex1.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptor {

    public static void main(String[] args) {
        int mensagensRecebidas = 0;
        try {
            //crio um socket udp na porta 1234
            DatagramSocket socket = new DatagramSocket(1234);
            //crio um pacote datagrama "vazio" para recebimento de até 100 bytes
            DatagramPacket pacoteRecebido = new DatagramPacket(new byte[100], 100);
            while (true) {
                /*
                AGUARDO A MENSAGEM DO EMISSOR
                */
                //aguardo (bloqueado) uma mensagem chegar pela rede
                socket.receive(pacoteRecebido);
                //extraio os bytes dos dados da mensagem
                byte buffer[] = pacoteRecebido.getData();
                //converto os bytes em string
                String mensagemRecebida = new String(buffer, 0, pacoteRecebido.getLength());
                //exibo na tela a mensagem recebida
                System.out.println("Recebi: " + mensagemRecebida);
                
                /*
                ENVIO UMA RESPOSTA AO EMISSOR
                */
                //extraio do pacoteRecebido os dados de quem me enviou uma mensagem
                InetAddress emissorEndereco = pacoteRecebido.getAddress();
                int emissorPorta = pacoteRecebido.getPort();
                //monto uma resposta para o emissor
                String resposta = "mensagens recebidas: "+(++mensagensRecebidas);
                DatagramPacket pacoteResposta = new DatagramPacket(resposta.getBytes(),
                                                                   resposta.getBytes().length,
                                                                   emissorEndereco,
                                                                   emissorPorta);
                socket.send(pacoteResposta);
            }
        } catch (Exception ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
