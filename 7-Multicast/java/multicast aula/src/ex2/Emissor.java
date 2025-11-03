package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
import util.ComunicadorUDP;

public class Emissor {

    public Emissor() {
        try {
            int porta = 3456;
            String enderecoGrupo = "239.1.2.3";
            String msg = "";
            
            //criação do Scanner para leitura do teclado
            Scanner scanner = new Scanner(System.in);
            
            //criação do socket multicast
            MulticastSocket socket = new MulticastSocket();
            do {
                //leitura do teclado
                System.out.println("Digite: ");
                msg = scanner.nextLine();
                
                //criação do pacote multicast (mesmo que pacote UDP)
                DatagramPacket pacote = com.montaMensagem(msg, enderecoGrupo, porta);
                
                //envio do pacote
                s.send(pacote);
                
                System.out.println("Mensagem enviada");
            } while (!msg.equals("sair"));
            s.close();
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Emissor e = new Emissor();
    }
}
