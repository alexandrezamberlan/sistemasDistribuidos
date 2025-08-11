package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PopulaLista extends Thread {
    private List<Integer> lista;
    Integer tamanho;

    //construtor
    public PopulaLista(List<Integer> lista, Integer tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            lista.add(random.nextInt(tamanho));
        }
        System.out.println("lista populada: ");
    }
}


class OrdenaBolha extends Thread {
    private List<Integer> lista;

    public OrdenaBolha(List<Integer> lista) {
        this.lista = lista;
    }

    public void run() {
        boolean houveTroca;
        int tmp;
        do {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i) > lista.get(i+1)) {
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i+1));
                    lista.set(i+1, tmp);
                }
            }
        } while (houveTroca);
    }
}

public class Java {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        List<Integer> lista3 = new ArrayList<>();

        PopulaLista popula1 = new PopulaLista(lista1, 10000);
        PopulaLista popula2 = new PopulaLista(lista2, 1000);
        PopulaLista popula3 = new PopulaLista(lista3, 5000);
        
        popula1.start();
        popula2.start();
        popula3.start();

        popula1.join();
        popula2.join();
        popula3.join();

        OrdenaBolha ordena1 = new OrdenaBolha(lista1);
        OrdenaBolha ordena2 = new OrdenaBolha(lista2);
        OrdenaBolha ordena3 = new OrdenaBolha(lista3);

        ordena1.start();
        ordena2.start();
        ordena3.start();
    }
}
 