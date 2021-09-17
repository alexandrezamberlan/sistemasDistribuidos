import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    ServerSocket servidor;

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
        try {
            /*Bloqueia esperando por uma conexão através do accept()
             Ao receber a conexão, ele receberá como retorno uma referência do Socket do cliente*/
            Socket cliente = servidor.accept();
            System.out.println("Recebi uma conexão de um cliente");
            ThreadRecebedora tr = new ThreadRecebedora(cliente);
            ThreadEnviadora te = new ThreadEnviadora(cliente);
            tr.start();
            te.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Servidor s = new Servidor();
    }
}
