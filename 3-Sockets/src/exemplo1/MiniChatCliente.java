package exemplo1;


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MiniChatCliente {

    public static void main(String[] args) throws IOException {
        String apelido = "Zamber";
        String servidorEndereco = JOptionPane.showInputDialog(null, "Informe o endereco IP do servidor");
        int portaNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da porta logica do servidor: "));

        try {
            Socket socketCliente = new Socket(servidorEndereco, portaNumero);

            PrintWriter escritor = new PrintWriter(socketCliente.getOutputStream(), true);

            BufferedReader leitor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            BufferedReader tecladoTerminal = new BufferedReader( new InputStreamReader(System.in) );
            
            new Thread() {
                @Override
                public void run() {
                    String fraseDoServidor;
                    try {
                        while ((fraseDoServidor = leitor.readLine()) != null) {
                            //out.println(userInput);
                            System.out.println("Msg do servidor: " + fraseDoServidor);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MiniChatCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            String fraseDoCliente;
            while ((fraseDoCliente = tecladoTerminal.readLine()) != null) {
                escritor.println(apelido + ": " + fraseDoCliente);
                //System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Nâo reconheço o servidor " + servidorEndereco);
            
        } catch (IOException e) {
            System.err.println("Servidor não conecta neste endereço "
                    + servidorEndereco);
            
        }
        System.exit(0);
    }
}
