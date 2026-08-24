import java.util.ArrayList;
import java.util.List;

class ListaCompartilhada {
    private final List<Integer> numeros = new ArrayList<>(); //observem a visibilidade final

    public synchronized void adicionarNumero(int umNumero) {
        numeros.add(umNumero);
        System.out.println(Thread.currentThread().getName() + " adicionou: " + umNumero);
    }

    public synchronized List<Integer> getNumeros() { //metodo get de acesso tipo leitura da lista numeros
        return new ArrayList<>(numeros);
    }
}

class ThreadDeTrabalho extends Thread {
    private final ListaCompartilhada listaCompartilhada;
    int quantidadeNumeros;

    public ThreadDeTrabalho(ListaCompartilhada lista, int quantidadeNumeros) {
        this.listaCompartilhada = lista;
        this.quantidadeNumeros = quantidadeNumeros;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.quantidadeNumeros; i++) {
            listaCompartilhada.adicionarNumero(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {}
        }
    }
}

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        ListaCompartilhada listaCompartilhada = new ListaCompartilhada();

        //ha duas threads que populam números inteiros na mesma thread
        Thread t1 = new ThreadDeTrabalho(listaCompartilhada, 5);
        Thread t2 = new ThreadDeTrabalho(listaCompartilhada, 5);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Lista final: " + listaCompartilhada.getNumeros());
    }
}