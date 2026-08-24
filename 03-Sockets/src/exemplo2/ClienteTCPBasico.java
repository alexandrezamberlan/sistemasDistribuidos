package exemplo2;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

public class ClienteTCPBasico {
  public static void main(String[] args) {
    try {
      int porta = 8888;
      Socket cliente = new Socket("localhost",porta);
      
      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
     
      Date data_atual = (Date)entrada.readObject();
      JOptionPane.showMessageDialog(null,"Data recebida do servidor: " + data_atual.toString());
      entrada.close();
      System.out.println("Conexão encerrada");
    }
    catch(HeadlessException | IOException | ClassNotFoundException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}