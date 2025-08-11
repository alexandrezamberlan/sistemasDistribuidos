package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PopulaLista1 extends Thread {
    private List<Integer> lista1;
    Integer tamanho;

    public PopulaLista1(List<Integer> lista1, Integer tamanho) {
        this.lista1 = lista1;
        this.tamanho = tamanho;
    }

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < tamanho; i++) {
                lista1.add(random.nextInt(tamanho));
            }
            System.out.println("lista 1 populada: " + lista1);
        }
    }


class OrdenaLista1 extends Thread {
    private List<Integer> lista1;

    public OrdenaLista1(List<Integer> lista1) {
        this.lista1 = lista1;
    }

    public void run() {

        for (int i = 0; i < lista1.size() - 1; i++) {
            for (int j = 0; j < lista1.size() - 1; j++) {
                if (lista1.get(j) > lista1.get(j + 1)) {
                    int aux = lista1.get(j);
                    lista1.set(j, lista1.get(j + 1));
                    lista1.set(j + 1, aux);
                }
            }
        }
        System.out.println("lista 1 ordenada: " + lista1);
    }
}

class PopulaLista2 extends Thread {
    List<Integer> lista2;
    Integer tamanho;

    public PopulaLista2(List<Integer> lista2, Integer tamanho) {
        this.lista2 = lista2;
        this.tamanho = tamanho;
    }

    public void run() {
        Random random = new Random();
        for(int i = 0; i < tamanho; i++) {
            lista2.add(random.nextInt(tamanho));
        }
    }
}

class OrdenaLista2 extends Thread{
    private List<Integer> lista1;

    public OrdenaLista2(List<Integer> lista1) {
        this.lista1 = lista1;
    }

    public void run() {

    }
}

public class Java {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        PopulaLista1 popula1 = new PopulaLista1(lista1, 10000);
        OrdenaLista1 ordena1 = new OrdenaLista1(lista1);

        popula1.start();
        popula1.join();

        ordena1.start();
        ordena1.join();
    }
}
 