package ex1;

import java.io.IOException;
import java.net.*;
import util.ComunicadorUDP;

public class Emissor {

    public Emissor() {
        try {
            int porta = 3456;
            String enderecoGrupo = "239.1.2.3";
            //criação do pacote multicast (mesmo que pacote UDP)
            DatagramPacket pacote = ComunicadorUDP.montaMensagem("Turma de Sistemas Distribuídos", enderecoGrupo, porta);
            
            //criação do socket multicast
            MulticastSocket socket = new MulticastSocket();
            
            //envio do pacote
            socket.send(pacote);
            
            socket.close();
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Emissor e = new Emissor();
    }
}
