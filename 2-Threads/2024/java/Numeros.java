import java.util.Random;
import java.util.ArrayList;
/**
 * Classe com métodos para gerar números em lista e exibir lista
 */
public class Numeros {
    /**
     * Método estático que gera números aleatórios e inteiros dentro de uma lista
     * @param lista - contém os números gerados
     * @param qtd - quantidade de números a serem gerados
     * @param frase - título do método
     */
    public static void popularAleatorio(ArrayList<Integer> lista, int qtd, String frase) {
        Random gerador = new Random();
        for (; qtd > 0; qtd--) {
            lista.add( gerador.nextInt(1000) );
        }
        System.out.println("Feito...." + frase);
    }

    /**
     * 
     * @param lista
     */
    public static void exibir(ArrayList<Integer> lista){
        for (Object item : lista) {
            System.out.println(item);
        }
    }
}
