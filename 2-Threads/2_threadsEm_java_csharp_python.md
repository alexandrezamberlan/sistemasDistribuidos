# Threads nas 3 linguagens

## 1. Java

* **Threads nativas**: O Java tem suporte robusto para multithreading desde suas primeiras versões.
* É possível criar threads:

  * Estendendo a classe `Thread` e sobrescrevendo o método `run()`.
  * Implementando a interface `Runnable` e passando para uma Thread.
* Uso comum do **Executor Framework** (`java.util.concurrent`) para gerenciar pools de threads, facilitando a execução concorrente e o reaproveitamento de threads.
* Suporta sincronização via `synchronized`, `Lock`, `Semaphore`, entre outros.
* Bom suporte para comunicação e sincronização entre threads.

**Exemplo básico:**

```java
class MinhaThread extends Thread {
    public void run() {
        System.out.println("Thread executando!");
    }
}

public class Main {
    public static void main(String[] args) {
        MinhaThread t = new MinhaThread();
        t.start();  // inicia a thread
    }
}
```

---

## 2. Python

* Suporte a threads via módulo `threading`.
* **Limitação importante**: devido ao **GIL (Global Interpreter Lock)**, o Python executa apenas uma thread de bytecode Python por vez, o que limita o paralelismo real em CPU-bound.
* Contudo, threads são muito úteis para tarefas **I/O-bound** (entrada/saída), como chamadas de rede, leitura de arquivos, etc.
* Para CPU-bound, o Python recomenda o uso do módulo `multiprocessing` (processos em vez de threads).
* Fácil criação e controle de threads via `threading.Thread`.

**Exemplo básico:**

```python
import threading

def tarefa():
    print("Thread executando!")

t = threading.Thread(target=tarefa)
t.start()
t.join()  # espera a thread terminar
```

---

## 3. C\#

* Suporte nativo a threads pelo namespace `System.Threading`.
* Criação de threads com a classe `Thread` ou, mais moderno, usando **Tasks** (`System.Threading.Tasks`) que facilitam o trabalho assíncrono.
* O C# também suporta **async/await** para programação assíncrona, que em muitos casos substitui a necessidade de criar threads manualmente.
* Suporte robusto para sincronização (`lock`, `Mutex`, `Semaphore`, etc.).
* Muito usado em servidores distribuídos com ASP.NET, onde o gerenciamento eficiente de threads é crítico.

**Exemplo básico:**

```csharp
using System;
using System.Threading;

class Program {
    static void MinhaThread() {
        Console.WriteLine("Thread executando!");
    }

    static void Main() {
        Thread t = new Thread(new ThreadStart(MinhaThread));
        t.Start();
        t.Join();
    }
}
```

---

### Em resumo

| Linguagem | Uso de Threads                                          | Particularidade/limitação                  |
| --------- | ------------------------------------------------------- | ------------------------------------------ |
| Java      | Suporte completo, fácil, robusto com Executor Framework | Muito usado em sistemas distribuídos       |
| Python    | Suporte para threads, mas GIL limita paralelismo real   | Ideal para I/O-bound, não CPU-bound        |
| C#        | Suporte completo, com async/await e Tasks modernos      | Amplamente usado em aplicações de servidor |


