/**
 * pacote responsável por oferecer os serviços de montar, enviar e receber mensagens
 */
package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author Turma Sistemas Distribuídos 2019-2
 */
public class ComunicadorUDP {

    /**
     * método de classe que recebe uma mensagem, um endereço de ip e uma porta de comunicação
     * @param mensagem mensagem a ser enviada
     * @param ip endereço do grupo
     * @param porta porta de saída da estação para o grupo
     * @return DatagramPacket
     * @throws UnknownHostException 
     */
    public static DatagramPacket montaMensagem(String mensagem, String ip, int porta) throws UnknownHostException {
        try {
            byte[] buffer = mensagem.getBytes();
            //monta um pacote datagrama com a mensagem, indicando, além dos dados, o endereço e a porta a ser enviado
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), porta);
            return pacote;
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /**
     * método de classe que recebe um DatagramSocket e um DatagramPacket
     * @param s DatagramSocket
     * @param pacote DatagramPacket
     * @throws IOException 
     */
    public static void enviaMensagem(DatagramSocket s, DatagramPacket pacote) throws IOException {
        try {
            //envia o pacote datagrama
            s.send(pacote);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * método de classe que recebe um DatagramSocket e retorna um DatagramPacket
     * @param s o DatagramSocket recebido
     * @return DatagramPackt
     * @throws IOException
     */
    public static DatagramPacket recebeMensagem(DatagramSocket s) throws IOException {
        try {
            //cria um pacote vazio de 512 bytes
            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);
            //bloqueia aguardando um pacote datagrama do servidor
            s.receive(pacote);
            return pacote;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
