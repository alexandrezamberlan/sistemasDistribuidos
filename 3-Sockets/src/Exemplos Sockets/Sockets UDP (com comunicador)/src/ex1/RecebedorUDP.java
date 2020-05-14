import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class RecebedorUDP {

    
    DatagramSocket socket;

    private void criaServerSocket() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
        }
    }

    public RecebedorUDP() {
        criaServerSocket();
        ComunicadorUDP com = new ComunicadorUDP();
        System.out.println("Cliente ativo à espera do servidor");
        DatagramPacket pacote = com.recebeMensagem(socket);//aguarda um pacote datagrama chegar de um cliente pela porta 1234
        String mensagem = new String(pacote.getData());//monta uma string com os dados (bytes) que vieram no pacote
        System.out.println("Recebi " + mensagem);
        System.out.println("De: "+pacote.getAddress().getHostName()+":"+pacote.getPort());
    }

    public static void main(String[] args) {
        RecebedorUDP s = new RecebedorUDP();
    }
}
