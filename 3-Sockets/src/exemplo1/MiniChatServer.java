import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MiniChatServer {
	
    static BufferedReader tecladoTerminal = new BufferedReader( new InputStreamReader(System.in) );  
    static ServerSocket socketServidor;
    static Socket socketCliente;
    static ObjectOutputStream saida;
    static ObjectInputStream entrada;

    public static void main(String[] args) throws IOException {
    	String apelido = "A1";
        int portaNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a porta logica liberada"));
        
        try {
        	socketServidor = new ServerSocket(portaNumero);
                       
        	socketCliente = socketServidor.accept();
        	
        	saida = new ObjectOutputStream(socketCliente.getOutputStream());
        	
        	entrada = new ObjectInputStream(socketCliente.getInputStream());
        	
            
            new Thread() {
                @Override
                public void run() {
                    String fraseDoCliente;
                    try {
                    	while ((fraseDoCliente = (String)entrada.readObject()) != null) {
                    		System.out.println("Msg do cliente: " + fraseDoCliente);
                    	}
                    } catch (IOException ex) {
                        Logger.getLogger(MiniChatServer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }.start();
            
            String fraseDoServidor;
            do {
            	fraseDoServidor = tecladoTerminal.readLine();
            	saida.flush();
            	saida.writeObject((apelido + ": " + fraseDoServidor).toString());
            }  while (fraseDoServidor != null);
        } catch (IOException e) {
            System.out.println("Exceção capturada ao ouvir/ler a porta "
                    + portaNumero + " ou ao tentar conectar");
            System.out.println(e.getMessage());
        }
        saida.close();
        entrada.close();
        socketCliente.close();
        socketServidor.close();
        System.exit(0);
    }
}