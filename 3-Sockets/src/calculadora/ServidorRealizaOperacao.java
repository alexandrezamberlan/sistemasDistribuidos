package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRealizaOperacao {

    public static void main(String[] args) {

        try {
            // Instancia o ServerSocket ouvindo a porta 12345
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");
            Socket cliente;

            while (true) {
                cliente = servidor.accept();
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());                
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

                //servidor recebe a solicitacao de calculo de operacao
                Conta c = (Conta) entrada.readObject();

                System.out.println("servidor recebeu dados do cliente....." + "Conta a realizar: " + c.n1 + " " + c.operacao + " " + c.n2);

                switch (c.operacao) {
                    case "+":
                        c.resposta = c.n1 + c.n2;
                        break;
                    case "-":
                        c.resposta = c.n1 - c.n2;
                        break;
                    case "/":
                        c.resposta = (int) c.n1 / c.n2;
                        break;
                    case "*":
                        c.resposta = c.n1 * c.n2;
                        break;
                    default:
                        c.resposta = -27;
                }

                //servidor enviando resposta ao cliente
                saida.flush();
                saida.writeObject(c);
                saida.close();
                cliente.close();  
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
