package ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;
import util.ComunicadorUDP;

public class EmissorReceptor {

    //ESPECIFICO UMA THREAD RECEPTORA DE MENSAGENS DO GRUPO
    class ThreadReceptora extends Thread {

        @Override
        public void run() {
            /*
             * PARTE RESPONSAVEL POR RECEBER AS MENSAGENS DO GRUPO
             */
            while (true) {
                try {
                    //BLOQUEIO ATÉ RECEBER A MENSAGEM
                    final DatagramPacket pacote = com.recebeMensagem(s);
                    // TRANSFORMO A MENSAGEM EM STRING (POIS ELA VEM EM BYTES)
                    final String msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                    // MOSTRO A MENASGEM NA TELA
                    System.out.println(msgRecebida);
                } catch (final Exception e) {
                }
            }
        }
    }

    // ESPECIFICO UMA THREAD EMISSORA DE MENSAGENS DO GRUPO
    class ThreadEmissora extends Thread {

        @Override
        public void run() {
            /*
             * PARTE RESPONSAVEL POR ENVIAR MENSAGENS AO GRUPO
             */
            // PREPARO A LEITURA DO TECLADO
            String msg = "";
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    // LE A MENSAGEM DO TECLADO
                    msg = scanner.nextLine();
                    // CRIA O PACOTE DATAGRAMA
                    final DatagramPacket pacote = com.montaMensagem(msg, "239.1.2.3", 3456);
                    // ENVIA A MENSAGEM PRO GRUPO MULTICAST
                    s.send(pacote);
                } catch (final Exception e) {

                }
            }
        }
    }

    public EmissorReceptor() {
        // PARTE EMISSORA
        try {
            /*
             * CONFIGURAÇÃO DO EMISSOR/RECEPTOR
             */
            // DEFINO O IP DO GRUPO
            group = InetAddress.getByName("239.1.2.3");
            // CRIO O SOCKET MULTICAST COM A PORTA ESPECIFICADA
            s = new MulticastSocket(3456);
            // ENTRA NO GRUPO MULTICAST PARA RECEBER AS MENSAGENS
            s.joinGroup(group);
            // CRIO A THREAD PARA RECEBER AS MENSAGENS
            final ThreadReceptora tR = new ThreadReceptora();
            tR.start();
            final ThreadEmissora tE = new ThreadEmissora();
            tE.start();
        } catch (final Exception e) {
        }
    }


    InetAddress group;
    MulticastSocket s;
    ComunicadorUDP com = new ComunicadorUDP();
    
    public static void main(final String args[]) {
        final EmissorReceptor er = new EmissorReceptor();
    }
}
