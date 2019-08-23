package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteSolicitaOperacao {

    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 12345);

            //cliente enviando conta para ser calculada no servidor
            Conta c = new Conta();
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.flush();
            saida.writeObject(c);
            
            System.out.println("Enviando para o servidor ..........");
            
            //servidor responde a solicitacao de calculo de operacao
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            c = (Conta)entrada.readObject();
            JOptionPane.showMessageDialog(null, "Resultado da operacao: " + c.resposta);
            int continuar;
            do{
                continuar = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Continuar | 2 - Sair"));
                if(continuar != 1) break;
                c.realizarConta();
                saida.flush();
                saida.writeObject(c);
                c = (Conta)entrada.readObject();
                JOptionPane.showMessageDialog(null, "Resultado da operacao: " + c.resposta);
            }while(true);
            entrada.close();
            saida.close();
            cliente.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
