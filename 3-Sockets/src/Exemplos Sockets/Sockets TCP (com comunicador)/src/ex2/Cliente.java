package ex2;

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
        ComunicadorObjetos com = new ComunicadorObjetos();
        Pessoa p = new Pessoa(23, "José");
        com.enviaMensagem(socket, p);
        Pessoa p2 = com.recebeMensagem(socket);
        System.out.println("Recebi " + p2.getNome() + "," + p2.getIdade());
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
}
