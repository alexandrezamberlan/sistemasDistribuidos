package ex1;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    ServerSocket servidor;

    private void criaServerSocket() {
        try {
            servidor = new ServerSocket(1234);
            System.out.println("Server escutando na porta 1234");
        } catch (Exception ex) {
            System.out.println("Erro ao conectar o servidor");
        }
    }

    private void aguardaClientes() {
        while (true) {
            try {
                /*Bloqueia esperando por uma conexão através do accept()
                 Ao receber a conexão, ele receberá como retorno uma referência do Socket do cliente*/
                Socket cliente = servidor.accept();
                System.out.println("Recebi uma conexão de um cliente");
                String mensagem = Comunicador.recebeMensagem(cliente);
                System.out.println("Recebi " + mensagem);
                Comunicador.enviaMensagem(cliente, mensagem.toUpperCase());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Servidor() {
        criaServerSocket();
        aguardaClientes();
    }

    public static void main(String[] args) {
        Servidor s = new Servidor();
    }
}
