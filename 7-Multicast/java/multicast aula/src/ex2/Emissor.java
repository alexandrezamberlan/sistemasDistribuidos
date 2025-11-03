package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
import util.ComunicadorUDP;

public class Emissor {

    public Emissor() {
        int porta = 3456;
        String enderecoGrupo = "239.1.2.3";
        String msg = "";
        try {
            //criação do Scanner para leitura do teclado
            Scanner scanner = new Scanner(System.in);

            //especificação do endereço do grupo multicast
            InetAddress grupo = InetAddress.getByName(enderecoGrupo);

            //criação do socket multicast
            MulticastSocket socket = new MulticastSocket(porta);

            //processo entra no grupo multicast
            socket.joinGroup(grupo);
            do {
                //leitura do teclado
                System.out.println("Digite: ");
                msg = scanner.nextLine();

                //criação do pacote multicast (mesmo que pacote UDP)
                DatagramPacket pacote = ComunicadorUDP.montaMensagem(msg, enderecoGrupo, porta);

                //envio do pacote
                socket.send(pacote);

                System.out.println("Mensagem enviada");
            } while (!msg.equals("sair"));
            socket.close();
            socket.leaveGroup(grupo);
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Emissor e = new Emissor();
    }
}
