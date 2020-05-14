package ex2;

import ex1.*;
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
                /*
                ENVIO UMA MENSAGEM PARA O RECEPTOR
                */
                
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
                
                /*
                AGUARDO A RESPOSTA DO RECEPTOR
                */
                //crio um pacote vazio para receber a resposta do recepetor
                DatagramPacket pacoteResposta = new DatagramPacket(new byte[100], 100);
                //aguardo a resposta do receptor
                socket.receive(pacoteResposta);
                //extraio os bytes dos dados da resposta
                byte buffer[] = pacoteResposta.getData();
                //converto os bytes em string
                String mensagemResposta = new String(buffer, 0, pacoteResposta.getLength());
                //exibo na tela a resposta do receptor
                System.out.println("Resposta: "+mensagemResposta);
            }
        } catch (Exception ex) {
            Logger.getLogger(Emissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
