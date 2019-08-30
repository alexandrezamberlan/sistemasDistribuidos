package exemplo1;


import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MiniChatServer {

    public static void main(String[] args) throws IOException {
        String apelido = "Zamber";
        int portaNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a porta logica liberada"));

        try {
            ServerSocket socketServidor = new ServerSocket(portaNumero);
                       
            Socket socketCliente = socketServidor.accept();

            PrintWriter escritor = new PrintWriter(socketCliente.getOutputStream(), true);

            BufferedReader leitor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            
            BufferedReader tecladoTerminal = new BufferedReader( new InputStreamReader(System.in) );            
            
            new Thread() {
                @Override
                public void run() {
                    String fraseDoCliente;
                    try {
                        while ((fraseDoCliente = leitor.readLine()) != null) {
                            //out.println(userInput);
                            System.out.println("Msg do cliente: " + fraseDoCliente);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MiniChatServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            String fraseDoServidor;
            while ((fraseDoServidor = tecladoTerminal.readLine()) != null) {
                escritor.println(apelido + ": " + fraseDoServidor);
            }
        } catch (IOException e) {
            System.out.println("Exceção capturada ao ouvir/ler a porta "
                    + portaNumero + " ou ao tentar conectar");
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }
}
