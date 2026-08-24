package exemplo2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServidorTCPBasico {

    public static void main(String[] args) {
        try {
            int portaServidor = 8888;
            ServerSocket servidor = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);
            Socket cliente; //procurador do cliente no lado do servidor
            while (true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(new Date());
                saida.close();
                cliente.close();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } 
    }
}
