package ex3;

import java.net.Socket;
import java.util.Scanner;

public class ThreadEnviadora extends Thread {

    private Socket socket;

    public ThreadEnviadora(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Comunicador com = new Comunicador();
        try {
            System.out.println("Digite: ");
            while (true) {
                String mensagem = scanner.nextLine();
                com.enviaMensagem(socket, mensagem); //envia uma mensagem pela rede
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
