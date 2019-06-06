package ex1;

import java.io.IOException;
import java.net.*;
import util.ComunicadorUDP;

public class Emissor {

    public Emissor() {
        ComunicadorUDP com = new ComunicadorUDP();
        try {
            //criação do pacote multicast (mesmo que pacote UDP)
            DatagramPacket pacote = com.montaMensagem("Olá", "239.1.2.3", 3456);
            //criação do socket multicast
            MulticastSocket s = new MulticastSocket();
            //envio do pacote
            s.send(pacote);
            s.close();
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Emissor e = new Emissor();
    }
}
