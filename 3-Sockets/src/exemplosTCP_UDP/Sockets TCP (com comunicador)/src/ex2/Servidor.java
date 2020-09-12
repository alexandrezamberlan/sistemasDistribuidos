package ex2;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    ServerSocket srv;

    private void criaServerSocket() {
        try {
            srv = new ServerSocket(1234);
            System.out.println("Server escutando na porta 1234");
        } catch (Exception ex) {
        }
    }

    private void aguardaClientes() {
        ComunicadorObjetos com = new ComunicadorObjetos();
        while (true) {
            try {
                /*Bloqueia esperando por uma conexão através do accept()
                 Ao receber a conexão, ele receberá como retorno uma referência do Socket do cliente*/
                Socket cliente = srv.accept();
                System.out.println("Recebi uma conexão de um cliente");
                Pessoa p = com.recebeMensagem(cliente);
                Pessoa p2 = new Pessoa(28,"Guilherme");
                com.enviaMensagem(cliente, p2);
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
