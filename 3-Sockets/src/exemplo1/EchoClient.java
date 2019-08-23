package exemplo1;


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        String hostAddress = JOptionPane.showInputDialog(null, "Informe o endereco IP do servidor");
        int portNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da porta logica do servidor: "));

        try {
            Socket echoSocket = new Socket(hostAddress, portNumber);

            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in) );
            
            new Thread() {
                @Override
                public void run() {
                    String serverInput;
                    try {
                        while ((serverInput = in.readLine()) != null) {
                            //out.println(userInput);
                            System.out.println("echo: " + serverInput);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                //System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostAddress);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostAddress);
            System.exit(1);
        }
        System.exit(0);
    }
}
