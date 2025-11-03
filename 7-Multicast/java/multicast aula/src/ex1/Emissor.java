package ex1;

import java.io.IOException;
import java.net.*;
import util.ComunicadorUDP;

public class Emissor {

    public Emissor() {
        int porta = 3456;
        String enderecoGrupo = "239.1.2.3";
        try {

            //especificação do endereço do grupo multicast
            InetAddress grupo = InetAddress.getByName(enderecoGrupo);

            //criação do socket multicast
            MulticastSocket socket = new MulticastSocket(porta);

            //processo entra no grupo multicast
            socket.joinGroup(grupo);

            //criação do pacote multicast (mesmo que pacote UDP)
            DatagramPacket pacote = ComunicadorUDP.montaMensagem("Turma de Sistemas Distribuídos", enderecoGrupo, porta);

            //envio do pacote
            socket.send(pacote);

            socket.leaveGroup(grupo);
            socket.close();
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Emissor e = new Emissor();
    }
}
