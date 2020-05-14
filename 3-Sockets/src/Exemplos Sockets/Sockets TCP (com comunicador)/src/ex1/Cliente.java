package ex1;

import java.io.*;
import java.net.*;

public class Cliente {

    Socket socket;

    private void criaClientSocket() {
        try {
            //cria um socket TCP para se conectar ao servidor de ip "localhost" porta 1234
            socket = new Socket("localhost", 1234);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Cliente() {
        criaClientSocket();
        Comunicador com = new Comunicador();
        com.enviaMensagem(socket, "Hello world");
        String mensagem = com.recebeMensagem(socket);
        System.out.println("Recebi " + mensagem);
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
}
