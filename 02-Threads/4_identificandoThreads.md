# Threads e suas identificações

Quando se dispara *threads* nas linguagens Java, C# e Python, mesmo sem usar memória compartilhada, ainda é possível **identificar** e **monitorar** qual thread está executando por meio de informações como:

* **ID da thread** (número único no processo)
* **Nome da thread** (definido manualmente ou pelo sistema)

Isso é útil para debug, logging e até sincronização.

## Java

Em Java, cada *thread* tem métodos para obter ID e nome:

```java
class MinhaTarefa implements Runnable { //permite o uso de memória compartilhada
    @Override
    public void run() {
        //aqui está o código a ser concomitado
        Thread t = Thread.currentThread();
        System.out.println("Executando na Thread: " + t.getName() + " | ID: " + t.getId());
    }
}

public class TesteThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MinhaTarefa(), "Tarefa-1");
        Thread t2 = new Thread(new MinhaTarefa(), "Tarefa-2");

        t1.start();
        t2.start();
    }
}
```

**Saída esperada**

```
Executando na Thread: Tarefa-1 | ID: 13
Executando na Thread: Tarefa-2 | ID: 14
```

### Use `Thread.currentThread()` dentro do `run()` para saber **qual thread está rodando**.


## C#

No C#, o equivalente é `Thread.CurrentThread`:

```csharp
using System;
using System.Threading;

class Program {
    static void MinhaTarefa(object nome) {
        Thread t = Thread.CurrentThread;
        Console.WriteLine($"Thread {t.ManagedThreadId} | Nome: {t.Name} | Param: {nome}");
    }

    static void Main() {
        Thread t1 = new Thread(MinhaTarefa);
        t1.Name = "Tarefa-1";
        Thread t2 = new Thread(MinhaTarefa);
        t2.Name = "Tarefa-2";

        t1.Start("Parametro A");
        t2.Start("Parametro B");
    }
}
```

**Saída esperada**

```
Thread 3 | Nome: Tarefa-1 | Param: Parametro A
Thread 4 | Nome: Tarefa-2 | Param: Parametro B
```

### Em C#, `ManagedThreadId` é o número único para identificar a thread no processo.


## Python

No Python, o módulo `threading` fornece `threading.current_thread()`:

```python
import threading
import time

def minha_tarefa(param):
    t = threading.current_thread()
    print(f"Thread {t.name} | ID interno: {threading.get_ident()} | Param: {param}")
    time.sleep(1)

t1 = threading.Thread(target=minha_tarefa, args=("A",), name="Tarefa-1")
t2 = threading.Thread(target=minha_tarefa, args=("B",), name="Tarefa-2")

t1.start()
t2.start()
```

**Saída esperada**

```
Thread Tarefa-1 | ID interno: 140463276087040 | Param: A
Thread Tarefa-2 | ID interno: 140463267694336 | Param: B
```

### Em Python, `get_ident()` retorna um número único por thread no processo.



## Resumo de como identificar a thread em execução

| Linguagem  | Método para nome                   | Método para ID                         |
| ---------- | ---------------------------------- | -------------------------------------- |
| **Java**   | `Thread.currentThread().getName()` | `Thread.currentThread().getId()`       |
| **C#**     | `Thread.CurrentThread.Name`        | `Thread.CurrentThread.ManagedThreadId` |
| **Python** | `threading.current_thread().name`  | `threading.get_ident()`                |


