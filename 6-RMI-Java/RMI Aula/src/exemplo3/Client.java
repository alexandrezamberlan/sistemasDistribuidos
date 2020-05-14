package exemplo3;

import java.rmi.Naming;

public class Client {

    public static void main(String args[]) {
        try {
            ISoma c = (ISoma) Naming.lookup("rmi://localhost/Soma");
            double res = c.add(5.7, 9.3);
            System.out.println("O resultado da soma é " + res);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
