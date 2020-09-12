package ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try {
            //Criação do socket servidor e definição da porta (1234)
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Socket servidor criado com sucesso");

            while (true) {
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
                 Servidor recebe 2 inteiros do cliente, x e y
                 */
                int x, y, resposta;
                x = in.readInt();
                y = in.readInt();
                System.out.println("Recebi " + x + " e " + y);
                /*
                 Servidor calcula a resposta e envia para o cliente
                 */
                resposta = x + y;
                out.writeInt(resposta);
                
                cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
