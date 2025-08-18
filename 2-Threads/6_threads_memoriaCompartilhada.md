# Threads com memória compartilhada

## Java

Em Java a memória é compartilhada entre threads na mesma JVM. Além disso, deve-se usar **sincronização** para evitar condições de corrida. Em computação, uma condição de corrida (ou race condition) ocorre quando dois ou mais threads ou processos acessam e modificam simultaneamente um recurso compartilhado, resultando em comportamento inesperado ou erros devido à ordem imprevisível em que as operações são executadas. 

```java
import java.util.ArrayList;
import java.util.List;

class SharedList {
    private final List<Integer> numbers = new ArrayList<>();

    public synchronized void addNumber(int num) {
        numbers.add(num);
        System.out.println(Thread.currentThread().getName() + " adicionou: " + num);
    }

    public synchronized List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}

class Worker extends Thread {
    private final SharedList sharedList;

    public Worker(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            sharedList.addNumber(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {}
        }
    }
}

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        SharedList listaCompartilhada = new SharedList();

        Thread t1 = new Worker(sharedList);
        Thread t2 = new Worker(sharedList);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Lista final: " + listaCompartilhada.getNumbers());
    }
}
```

---

# 🔹 C# – Threads com Memória Compartilhada

Em C#, também é possível compartilhar memória entre threads. Aqui usamos **lock** para proteger a lista compartilhada.

```csharp
using System;
using System.Collections.Generic;
using System.Threading;

class SharedList {
    private List<int> numbers = new List<int>();
    private readonly object lockObj = new object();

    public void AddNumber(int num) {
        lock (lockObj) {
            numbers.Add(num);
            Console.WriteLine(Thread.CurrentThread.ManagedThreadId + " adicionou: " + num);
        }
    }

    public List<int> GetNumbers() {
        lock (lockObj) {
            return new List<int>(numbers);
        }
    }
}

class Program {
    static void Worker(object obj) {
        SharedList sharedList = (SharedList)obj;
        for (int i = 1; i <= 5; i++) {
            sharedList.AddNumber(i);
            Thread.Sleep(50);
        }
    }

    static void Main() {
        SharedList sharedList = new SharedList();

        Thread t1 = new Thread(Worker);
        Thread t2 = new Thread(Worker);

        t1.Start(sharedList);
        t2.Start(sharedList);

        t1.Join();
        t2.Join();

        Console.WriteLine("Lista final: " + string.Join(", ", sharedList.GetNumbers()));
    }
}
```

---

# 🔹 Python – Threads com Memória Compartilhada

No Python, threads também compartilham memória, mas precisamos usar **Lock** para proteger a lista.

```python
import threading
import time

class SharedList:
    def __init__(self):
        self.numbers = []
        self.lock = threading.Lock()

    def add_number(self, num):
        with self.lock:
            self.numbers.append(num)
            print(f"{threading.current_thread().name} adicionou: {num}")

    def get_numbers(self):
        with self.lock:
            return list(self.numbers)

def worker(shared_list):
    for i in range(1, 6):
        shared_list.add_number(i)
        time.sleep(0.05)

if __name__ == "__main__":
    shared_list = SharedList()

    t1 = threading.Thread(target=worker, args=(shared_list,))
    t2 = threading.Thread(target=worker, args=(shared_list,))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print("Lista final:", shared_list.get_numbers())
```

---

# 🔹 Resumo: Threads sem x com Memória Compartilhada

* **Threads sem memória compartilhada**

  * Cada thread recebe **parâmetros próprios** (ex.: números, strings, objetos independentes).
  * As variáveis **não são acessadas em comum**.
  * Mais fáceis de implementar, sem necessidade de sincronização.
  * Menos propensas a **condições de corrida**.

* **Threads com memória compartilhada**

  * Duas ou mais threads acessam a **mesma estrutura de dados** (lista, dicionário, objeto).
  * Necessário uso de **mecanismos de sincronização** (Java `synchronized`, C# `lock`, Python `threading.Lock`).
  * Mais eficientes em alguns casos, mas requerem **cuidado com concorrência** (deadlocks, race conditions).

---

👉 Quer que eu faça também uma **variação sem Lock**, para você ver na prática o problema da condição de corrida em cada linguagem?
