import java.util.LinkedList;

public class Ordenacao {
    public static void bolha(LinkedList<Integer> lista) {
        boolean houveTroca;
        int i, tmp;

        do {
            houveTroca = false;
            for (i = 0; i < lista.size()-1; i++) {
                if (lista.get(i) > lista.get(i+1)) {
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i,lista.get(i+1));
                    lista.set(i+1,tmp);
                }
            }
        } while (houveTroca);
    }

    public static void pente(LinkedList<Integer> lista) {
        boolean houveTroca;
        int i, tmp;
        int distancia = lista.size();
        
        do {
            distancia = (int)(distancia / 1.3);
            if (distancia < 1) distancia = 1; //significa que virou bolha
            houveTroca = false;
            for (i = 0; i + distancia < lista.size(); i++) {
                if (lista.get(i) > lista.get(i + distancia)) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                    houveTroca = true;
                }
            }
        } while (distancia > 1 || houveTroca);
    }
}