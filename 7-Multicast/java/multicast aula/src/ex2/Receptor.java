package ex2;

import java.net.*;
import util.ComunicadorUDP;

public class Receptor {

    public Receptor() {
        try {
            int porta = 3456;
            String enderecoGrupo = "239.1.2.3"
                
            //especificação do endereço do grupo multicast
            InetAddress grupo = InetAddress.getByName(enderecoGrupo);
            
            //criação do socket multicast
            MulticastSocket socket = new MulticastSocket(porta);
            
            //processo entra no grupo multicast
            socket.joinGroup(grupo);
            
            String msgRecebida = "";
            do {
                //aguarda um pacote datagrama chegar de um cliente pela porta 3456
                DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);
                
                //crio uma String com os dados do pacote datagrama
                msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                
                System.out.println("Enviaram :" + msgRecebida);
            } while (!msgRecebida.equals("sair"));
            
            //processo deixa o grupo multicast
            socket.leaveGroup(group);
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Receptor r = new Receptor();
    }
}
