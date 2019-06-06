package ex2;

import java.net.*;
import util.ComunicadorUDP;

public class Receptor {

    public Receptor() {
        ComunicadorUDP com = new ComunicadorUDP();
        try {
            String msgRecebida = "";
            //especificação do endereço do grupo multicast
            InetAddress group = InetAddress.getByName("239.1.2.3");
            //criação do socket multicast
            MulticastSocket s = new MulticastSocket(3456);
            //processo entra no grupo multicast
            s.joinGroup(group);
            do {
                //aguarda um pacote datagrama chegar de um cliente pela porta 3456
                DatagramPacket pacote = com.recebeMensagem(s);
                //crio uma String com os dados do pacote datagrama
                msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                System.out.println("Enviaram :" + msgRecebida);
            } while (!msgRecebida.equals("sair"));
            //processo deixa o grupo multicast
            s.leaveGroup(group);
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Receptor r = new Receptor();
    }
}
