package exemplo1;


import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        int portNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a porta logica liberada"));

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            
            
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            
            
            
            
            BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in) );
            
            
            new Thread() {
                @Override
                public void run() {
                    String userInput;
                    try {
                        while ((userInput = in.readLine()) != null) {
                            //out.println(userInput);
                            System.out.println("echo: " + userInput);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            
            String serverInput;
            while ((serverInput = stdIn.readLine()) != null) {
                out.println(serverInput);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
}
