import java.util.ArrayList;

public class Principal2 {
    public static void main(String args[]) {
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        ArrayList<Integer> lista3 = new ArrayList<Integer>();

        new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista1,10,"lista1");
                
            }
        }.start();

        new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista2, 10, "lista2");
                
            }
        }.start();
        Numeros.exibir(lista1);
        Numeros.exibir(lista2);
        
        // new Thread() {
        //     public void run() {
        //         Numeros.popularAleatorio(lista3,10, "lista3");
        //     }
        // }.start();
        
        System.out.println("Programa encerrado!!!");
    }
}