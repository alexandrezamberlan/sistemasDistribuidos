import java.util.Random;
import java.util.ArrayList;

public class Numeros {
    public static void popularAleatorio(ArrayList<Integer> lista, int qtd, String frase) {
        Random gerador = new Random();
        for (; qtd > 0; qtd--) {
            lista.add( gerador.nextInt(1000) );
        }
        System.out.println("Feito...." + frase);
    }

    public static void exibir(ArrayList<Integer> lista){
        for (Object item : lista) {
            System.out.println(item);
        }
    }
}
