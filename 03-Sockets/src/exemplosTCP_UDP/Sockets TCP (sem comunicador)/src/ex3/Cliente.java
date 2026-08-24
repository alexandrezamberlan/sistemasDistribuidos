package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            /*
             Criação de um socket cliente e tentativa de conexão
             no ip "localhost", porta 1234
             */
            Socket s = new Socket("localhost", 1234);
            System.out.println("Conexão estabelecida com sucesso");

            /*
             Extraio o fluxo de saída e entrada de dados do socket
             */
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            DataInputStream in = new DataInputStream(s.getInputStream());

            /*
             Crio um fluxo secundário (thread) para receber mensagens do servidor
             */
            new Thread() {
                public void run() {
                    //recebimento de mensagens do servidor
                    while (true) {
                        try {
                            String mensagem = in.readUTF();
                            System.out.println("Servidor disse: " + mensagem);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            //envio de mensagens digitadas pelo teclado para o servidor
            Scanner leitor = new Scanner(System.in);
            while (true) {
                String mensagem = leitor.nextLine();
                out.writeUTF(mensagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
