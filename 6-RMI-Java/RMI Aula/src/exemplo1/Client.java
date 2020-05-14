package exemplo1;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

public class Client {

    public static void main(String args[]) {
        try {
            IIncrementa c = (IIncrementa) Naming.lookup("rmi://localhost/Incrementa");
            Random gerador = new Random();
            System.out.println("incrementando = " + c.inc(gerador.nextInt(100)));
            System.out.println("decrementando = " + c.inc(gerador.nextInt(100)));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}









