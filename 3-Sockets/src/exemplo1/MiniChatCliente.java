
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MiniChatCliente {

	static Socket socketCliente;
    static BufferedReader tecladoTerminal;
    static ObjectOutputStream saida;
    static ObjectInputStream entrada;
    
    public static void main(String[] args) throws IOException {
        String apelido = "C2";
        String servidorEndereco = JOptionPane.showInputDialog(null, "Informe o endereco IP do servidor");
        int portaNumero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da porta logica do servidor: "));
        
        
        try {
        	socketCliente = new Socket(servidorEndereco, portaNumero);
        	
        	saida = new ObjectOutputStream(socketCliente.getOutputStream());
        	
        	entrada = new ObjectInputStream(socketCliente.getInputStream());
	
	        tecladoTerminal = new BufferedReader( new InputStreamReader(System.in) );
            
            new Thread() {
                @Override
                public void run() {
                    String fraseDoServidor;
                    try {
                    	while ((fraseDoServidor = (String)entrada.readObject()) != null) {
                    		System.out.println("Msg do servidor: " + fraseDoServidor);
                    	}
                    } catch (IOException ex) {
                        Logger.getLogger(MiniChatCliente.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException e) {
                    	Logger.getLogger(MiniChatCliente.class.getName()).log(Level.SEVERE, null, e);
					}
                    
                }
            }.start();
            
            String fraseDoCliente;
            do {
            	fraseDoCliente = tecladoTerminal.readLine();
            	saida.flush();
            	saida.writeObject((apelido + ": " + fraseDoCliente).toString());
            }  while (fraseDoCliente != null);
            
        } catch (UnknownHostException e) {
            System.err.println("Nâo reconheço o servidor " + servidorEndereco);
            
        } catch (IOException e) {
            System.err.println("Servidor não conecta neste endereço "
                    + servidorEndereco);
            
        }
        saida.close();
        entrada.close();
        socketCliente.close();
        System.exit(0);
    }
}