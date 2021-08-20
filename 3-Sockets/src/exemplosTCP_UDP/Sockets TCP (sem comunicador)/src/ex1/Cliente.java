package ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            /*
             Criação de um socket cliente e tentativa de conexão
             no ip "localhost", porta 1234
             */
            Socket s = new Socket("localhost", 1234);
            System.out.println("Conexão estabelecida com sucesso");
            
            /*
            Extraio o fluxo de saída e entrada de dados do socket
            */
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            DataInputStream in = new DataInputStream(s.getInputStream());
            
            int x = 5, y = 6, resposta;
            /*
            Envia o x e o y para o servidor
            */
            out.writeInt(x);
            out.writeInt(y);
            /*
            Aguardo a resposta do servidor
            */
            resposta = in.readInt();
            
            System.out.println("A soma é "+resposta);
            
            s.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
