package ex2;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    ServerSocket servidor;
    Socket cliente;

    public Servidor() {
        criaServerSocket();
        aguardaClientes();
    }

    private void criaServerSocket() {
        try {
            servidor = new ServerSocket(1234);
            System.out.println("Server escutando na porta 1234");
        } catch (Exception ex) {
        }
    }

    private void aguardaClientes() {
        while (true) {
            try {
                /*Bloqueia esperando por uma conexão através do accept()
                 Ao receber a conexão, ele receberá como retorno uma referência do Socket do cliente*/
                cliente = servidor.accept();
                System.out.println("Recebi uma conexão de um cliente");
                Pessoa p = ComunicadorObjetos.recebeObjeto(cliente);
                Pessoa p2 = new Pessoa(28,"Guilherme");
                ComunicadorObjetos.enviaObjeto(cliente, p2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.gc();
        }
    }

    public static void main(String[] args) {
        Servidor s = new Servidor();
    }
}
