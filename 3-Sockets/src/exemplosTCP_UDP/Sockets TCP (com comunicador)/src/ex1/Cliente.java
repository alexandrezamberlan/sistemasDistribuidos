// package ex1;

import java.io.*;
import java.net.Socket;

public class Cliente {

    Socket socket;

    public Cliente() {
        criaClientSocket();
        Comunicador.enviaMensagem(socket, "oi turma de sistemas distribuídos");
        String mensagem = Comunicador.recebeMensagem(socket);
        System.out.println("Recebi " + mensagem);
    }

    private void criaClientSocket() {
        try {
            //cria um socket TCP para se conectar ao servidor de ip "localhost" porta 1234
            socket = new Socket("localhost", 1234);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
}
