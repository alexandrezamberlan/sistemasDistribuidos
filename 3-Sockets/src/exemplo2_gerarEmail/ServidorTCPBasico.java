package exemplo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorTCPBasico {

    public static void main(String[] args) {
        try {
            int portaServidor = 50000;
            ServerSocket servidor = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);
            Socket cliente; //procurador do cliente no lado do servidor
            ArrayList<Pessoa> lista = new ArrayList<>();
            Boolean encontrado;
            while (true) {
                encontrado = false;
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                cliente = servidor.accept();       
                String enderecoIP = cliente.getInetAddress().getHostAddress();
                int portaCliente = cliente.getPort();
                System.out.println("Cliente conectado no IP: " + enderecoIP);
                System.out.println("Cliente conectado via porta: " + portaCliente);
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());               
                //receber o nome completo do lado do cliente   
                String nomePessoa = (String)entrada.readObject();                    
                //gerar o email a partir do nome completo - primeiro.sobrenome@ufn.edu.br
                String vetorNome [] = nomePessoa.split(" ");
                String email = vetorNome[0] + "." + vetorNome[vetorNome.length-1] +
                        "@ufn.edu.br";
                nomePessoa = nomePessoa.toUpperCase();
                email = email.toLowerCase();
                //criar um objeto Pessoa(nome, email)
                Pessoa p = new Pessoa(nomePessoa, email);
                //adicionar na lista de controle o objeto criado
                if (lista.contains(p)) {
                    encontrado = true;                    
                } else {
                    lista.add(p);
                }
                //devolver o objeto criado
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                if (!encontrado) {
                    saida.writeObject(p);
                } else {
                    saida.writeObject(null);
                }

                saida.close();
                cliente.close();
                System.gc();
                
                System.out.println("Clientes na base....");
                for (Pessoa pessoa : lista) {
                    System.out.println(pessoa);                    
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } 
    }
}
