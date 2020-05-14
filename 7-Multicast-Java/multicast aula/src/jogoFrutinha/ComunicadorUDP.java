package jogoFrutinha;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ComunicadorUDP {

    public ComunicadorUDP() {

    }

    public DatagramPacket montaComponente(Componente botao, String ip, int porta) {
        try {
            byte[] buffer = ("" + botao.altura + botao.largura + botao.texto).getBytes();
            
            //monta um pacote datagrama com a mensagem, indicando, além dos dados, o endereço e a porta a ser enviado
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), porta);
            return pacote;
        } catch (UnknownHostException ex) {
            return null;
        }
    }
	
	public void enviaComponente(DatagramSocket s, DatagramPacket pacote) {
        try {
            //envia o pacote datagrama
            s.send(pacote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DatagramPacket recebeComponente(DatagramSocket s) {
        try {
            //cria um pacote vazio de 512 bytes
            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);
            //bloqueia aguardando um pacote datagrama do servidor
            s.receive(pacote);
            return pacote;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
