package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PopulaLista extends Thread { //uso de threads sem memória compartilhada
    private List<Integer> lista;
    Integer tamanho;

    //construtor
    public PopulaLista(List<Integer> lista, Integer tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        //aqui que está a tarefa ou rotina a ser concomitada
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            lista.add(random.nextInt(tamanho));
        }
        System.out.println("lista populada: ");
    }
}


class OrdenaBolha extends Thread { //uso de threads sem memória compartilhada
    private List<Integer> lista;

    public OrdenaBolha(List<Integer> lista) {
        this.lista = lista;
    }

    public void run() {
        //aqui está a tarefa ou rotina a ser concomitada - no caso, bubble sort
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

class OrdenaPente extends Thread { //uso de threads sem memória compartilhada
    private List<Integer> lista;

    public OrdenaBolha(List<Integer> lista) {
        this.lista = lista;
    }

    public void run() {
        //aqui está a tarefa ou rotina a ser concomitada - no caso, bubble sort
        boolean houveTroca;
        int tmp;
        int distancia = lista.size();
        do {
            distancia = (int)distancia / 1.3;
            houveTroca = false;
            for (int i = 0; i < lista.size() - distancia; i++) {
                if (lista.get(i) > lista.get(i+distancia)) {
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i+distancia));
                    lista.set(i+distancia, tmp);
                }
            }
        } while (distancia > 1 || houveTroca);
    }
}

public class Java {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        List<Integer> lista3 = new ArrayList<>();

        PopulaLista threadPopula1 = new PopulaLista(lista1, 10000);
        PopulaLista threadPopula2 = new PopulaLista(lista2, 1000);
        PopulaLista threadPopula3 = new PopulaLista(lista3, 5000);
        
        threadPopula1.start();
        threadPopula2.start();
        threadPopula3.start();

        threadPopula1.join();
        threadPopula2.join();
        threadPopula3.join();

        OrdenaPente threadOrdena1 = new OrdenaPente(lista1);
        OrdenaBolha threadOrdena2 = new OrdenaBolha(lista2);
        OrdenaBolha threadOrdena3 = new OrdenaBolha(lista3);

        threadOrdena1.start();
        threadOrdena2.start();
        threadOrdena3.start();
    }
}
 