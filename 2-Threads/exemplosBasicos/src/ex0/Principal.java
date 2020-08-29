import java.util.LinkedList;
import java.util.Random;

public class Principal {

    public static void popula(LinkedList<Integer> lista, int n) {
        Random gerador = new Random();
        do {
            lista.add(gerador.nextInt(100));
            n--;
        } while (n > 0);

    }

    public static void exibe(LinkedList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void main(String a[]) {
        int n = 10000;
        LinkedList<Integer> lista1 = new LinkedList<Integer>();
        LinkedList<Integer> lista2 = new LinkedList<Integer>();
        
        Thread t1 = new Thread() { //há um objeto t1 que representa a thread1
            public void run() {
                System.out.println("Lista 1....");
                popula(lista1, n);
                Ordenacao.bolha(lista1); 
                //exibe(lista1);
                System.out.println("Ordenação Lista 1 terminada!!");
            }
        };
        t1.start();
        
        new Thread() { //não há um objeto thread
            public void run() {
                System.out.println("Lista 2....");
                popula(lista2, n);
                Ordenacao.pente(lista2);
                //exibe(lista2);
                System.out.println("Ordenação Lista 2 terminada!!");
            }
        }.start();        
    }
}