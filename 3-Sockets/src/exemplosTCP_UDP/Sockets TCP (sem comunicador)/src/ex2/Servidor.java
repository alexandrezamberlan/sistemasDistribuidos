package ex2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                 Extraio o fluxo de saída e entrada de objetos do socket
                 */
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

                Numero n;
                Resposta res;
                /*
                 Servidor recebe 1 objeto do tipo Numero do cliente
                 */
                n = (Numero) in.readObject();
                
                System.out.println("Recebi " + n.getX() + " e " + n.getY());
                /*
                 Servidor calcula a resposta e envia para o cliente
                 */
                res = new Resposta(n.getX()+n.getY());
                out.writeObject(res);
                
                cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
