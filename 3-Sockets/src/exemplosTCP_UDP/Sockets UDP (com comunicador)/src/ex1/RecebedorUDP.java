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
        System.out.println("Cliente ativo à espera do servidor/enviador");
        DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);//aguarda um pacote datagrama chegar de um cliente pela porta 1234
        String mensagem;
        while (pacote != null) {
            mensagem = new String(pacote.getData());//monta uma string com os dados (bytes) que vieram no pacote
            System.out.println("Recebi " + mensagem);
            System.out.println("De: "+pacote.getAddress().getHostName()+":"+pacote.getPort());
            pacote = ComunicadorUDP.recebeMensagem(socket);//aguarda um pacote datagrama chegar de um cliente pela porta 1234
        }
    }

    public static void main(String[] args) {
        RecebedorUDP receptor = new RecebedorUDP();
    }
}
