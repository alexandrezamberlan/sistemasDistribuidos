package ex2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            Extraio o fluxo de saída e entrada de objetos do socket
            */
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            
            Numero n = new Numero(12, 6);
            Resposta res;
            /*
            Envia o objeto n para o servidor
            */
            out.writeObject(n);
            /*
            Aguardo a resposta do servidor
            */
            res = (Resposta)in.readObject();
            
            System.out.println("A soma é "+res.getValor());
            
            s.close();
            out.close();
            in.close();
            System.gc();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

