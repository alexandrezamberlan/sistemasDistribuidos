package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        try {
            //Criação do socket servidor e definição da porta (1234)
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Socket servidor criado com sucesso");

            /*Servidor aguarda uma conexão de um cliente
             O servidor bloqueia nesta linha enquanto um cliente não chega
             Quando um cliente se conecta, o servidor recebe uma referência do
             socket do cliente que se conectou (retorno do método)
             */
            Socket cliente = servidor.accept();
            /*
             Extraio o fluxo de saída e entrada de dados do socket
             */
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            DataInputStream in = new DataInputStream(cliente.getInputStream());

            /*
             fluxo secundário para recebimento de mensagens do cliente
             */
            new Thread() {
                public void run() {
                    while (true) {
                        try {
                            String mensagem = in.readUTF();
                            System.out.println("Cliente disse: " + mensagem);
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
