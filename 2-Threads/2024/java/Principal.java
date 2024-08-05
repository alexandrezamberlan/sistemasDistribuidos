import java.util.ArrayList;

public class Principal {
    public static void main(String args[]) {
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        ArrayList<Integer> lista3 = new ArrayList<Integer>();

        Thread t1 = new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista1,1000000,"lista1");
            }
        };
        t1.start();
        

        Thread t2 = new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista2, 1000000, "lista2");
            }
        };
        t2.start();
        
        Thread t3 = new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista3,1000000, "lista3");
            }
        };
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        Numeros.exibir(lista1);
        Numeros.exibir(lista2);
        Numeros.exibir(lista3);
        
        System.out.println("Programa encerrado!!!");
    }
}