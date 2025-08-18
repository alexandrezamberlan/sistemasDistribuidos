# Threads com memória compartilhada

## Java

Em Java a memória é compartilhada entre threads na mesma JVM. Além disso, deve-se usar **sincronização** para evitar condições de corrida. Em computação, uma condição de corrida (ou race condition) ocorre quando dois ou mais threads ou processos acessam e modificam simultaneamente um recurso compartilhado, resultando em comportamento inesperado ou erros devido à ordem imprevisível em que as operações são executadas. 

```java
import java.util.ArrayList;
import java.util.List;

class ListaCompartilhada {
    private final List<Integer> numeros = new ArrayList<>(); //observem a visibilidade final

    //método set da variavel numeros que é private final
    public synchronized void adicionarNumero(int umNumero) {
        numeros.add(umNumero);
        System.out.println(Thread.currentThread().getName() + " adicionou: " + umNumero);
    }

    //metodo get da variavel numeros que é private final
    public synchronized List<Integer> retornarNumeros() { //metodo get de acesso tipo leitura da lista numeros
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

        System.out.println("Lista final: " + listaCompartilhada.retornarNumeros());
    }
}
```


## C#

Em C#, também é possível compartilhar memória entre threads. Contudo, é utilizado **lock** para proteger a lista compartilhada, ao invés de **sincronização do Java**.

```csharp
using System;
using System.Collections.Generic;
using System.Threading;

class ListaCompartilhada {
    private List<int> numeros = new List<int>();
    private readonly object lockObj = new object();

    public void AdicionarNumeros(int umNumero) {
        lock (lockObj) {
            numeros.Add(umNumero);
            Console.WriteLine(Thread.CurrentThread.ManagedThreadId + " adicionou: " + umNumero);
        }
    }

    public List<int> RetornarNumeros() {
        lock (lockObj) {
            return new List<int>(numeros);
        }
    }
}

class Program {
    static void ThreadDeTrabalho(object objeto) {
        ListaCompartilhada listaCompartilhada = (ListaCompartilhada)objeto;
        for (int i = 1; i <= 5; i++) {
            listaCompartilhada.AdicionarNumeros(i);
            Thread.Sleep(50);
        }
    }

    static void Main() {
        ListaCompartilhada listaCompartilhada = new ListaCompartilhada();

        Thread t1 = new Thread(ThreadDeTrabalho);
        Thread t2 = new Thread(ThreadDeTrabalho);

        t1.Start(listaCompartilhada);
        t2.Start(listaCompartilhada);

        t1.Join();
        t2.Join();

        Console.WriteLine("Lista final: " + string.Join(", ", listaCompartilhada.RetornarNumeros()));
    }
}
```


## Python

No Python, threads também compartilham memória, mas é preciso, também, usar **Lock** para proteger a lista.

```python
import threading
import time

class ListaCompartilhada:
    def __init__(self):
        self.numeros = []
        self.lock = threading.Lock()

    def adicionar_numeros(self, um_numero):
        with self.lock:
            self.numeros.append(um_numero)
            print(f"{threading.current_thread().name} adicionou: {um_numero}")

    def retornar_numeros(self):
        with self.lock:
            return list(self.numeros)

def operacao_trabalho(lista, quantidade_numeros):
    for i in range(1, quantidade_numeros):
        lista.adicionar_numeros(i)
        time.sleep(0.05)

if __name__ == "__main__":
    lista_compartilhada = ListaCompartilhada()

    t1 = threading.Thread(target=operacao_trabalho, args=(lista_compartilhada,5))
    t2 = threading.Thread(target=operacao_trabalho, args=(lista_compartilhada,5))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print("Lista final:", lista_compartilhada.retornar_numeros())
```


## Threads sem x com Memória Compartilhada

* **Threads SEM memória compartilhada**

  * Cada thread recebe **parâmetros próprios** (ex.: números, strings, objetos independentes).
  * As variáveis **não são acessadas em comum**.
  * Mais fáceis de implementar, sem necessidade de sincronização.
  * Menos propensas a **condições de corrida**.

* **Threads com memória compartilhada**

  * Duas ou mais threads acessam a **mesma estrutura de dados** (lista, dicionário, objeto).
  * Necessário uso de **mecanismos de sincronização** (Java `synchronized`, C# `lock`, Python `threading.Lock`).
  * Mais eficientes em alguns casos, MAS REQUEREM **cuidado com concorrência** (deadlocks, race conditions).


