/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo2;

import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        try {
            IServerString c = (IServerString) Naming.lookup("rmi://localhost/ServerString");
            String frase = JOptionPane.showInputDialog("Digite uma frase: ");
            int cont = c.contaCaracteres(frase);
            System.out.println("A frase tem " + cont + " caracteres");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
