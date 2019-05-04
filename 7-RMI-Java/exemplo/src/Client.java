import java.rmi.Naming;

public class Client {
    public static void main(String args[]) {
        try {
            IHoje_eh d = (IHoje_eh) Naming.lookup("rmi://localhost/Hoje_eh");    
            System.out.println("Data e hora vinda do servidor!!");
            System.out.println("Data: " + d.pegaDataHora().data);
            System.out.println("Hora: " + d.pegaDataHora().hora);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
