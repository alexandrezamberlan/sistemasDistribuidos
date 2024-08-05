import java.util.ArrayList;

public class Principal2 {
    public static void main(String args[]) {
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        ArrayList<Integer> lista3 = new ArrayList<Integer>();

        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista1,1000000,"lista1");
            }
        }.start();
        

        new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista2, 1000000, "lista2");
            }
        }.start();
        
        new Thread() {
            public void run() {
                Numeros.popularAleatorio(lista3,1000000, "lista3");
            }
        }.start();
        
        System.out.println("Programa encerrado!!!");
    }
}