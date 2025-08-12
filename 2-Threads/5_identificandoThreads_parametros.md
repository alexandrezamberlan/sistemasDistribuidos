# Threads e parâmetros
---

## Java

```java
class MinhaTarefa implements Runnable { //uso de threads com memória compartilhada
    private String parametro;

    public MinhaTarefa(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("Executando na Thread: " + t.getName() +
                           " | ID: " + t.getId() +
                           " | Param: " + parametro);
    }
}

public class TesteThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MinhaTarefa("A"), "Tarefa-1");
        Thread t2 = new Thread(new MinhaTarefa("B"), "Tarefa-2");

        t1.start();
        t2.start();
    }
}
```

**Saída típica**

```
Executando na Thread: Tarefa-1 | ID: 13 | Param: A
Executando na Thread: Tarefa-2 | ID: 14 | Param: B
```



## C#

```csharp
using System;
using System.Threading;

class Program {
    static void MinhaTarefa(object parametro) {
        Thread t = Thread.CurrentThread;
        Console.WriteLine($"Thread {t.ManagedThreadId} | Nome: {t.Name} | Param: {parametro}");
    }

    static void Main() {
        Thread t1 = new Thread(MinhaTarefa);
        t1.Name = "Tarefa-1";
        Thread t2 = new Thread(MinhaTarefa);
        t2.Name = "Tarefa-2";

        t1.Start("A");
        t2.Start("B");
    }
}
```

**Saída típica**

```
Thread 3 | Nome: Tarefa-1 | Param: A
Thread 4 | Nome: Tarefa-2 | Param: B
```


## Python

```python
import threading
import time

def minha_tarefa(param):
    t = threading.current_thread()
    print(f"Thread {t.name} | ID interno: {threading.get_ident()} | Param: {param}")
    time.sleep(1)

#ATENÇÃO ao args, que é uma tupla. Se passar um parâmetro é necessário terminar com vírgula
t1 = threading.Thread(target=minha_tarefa, args=("A",), name="Tarefa-1")
t2 = threading.Thread(target=minha_tarefa, args=("B",), name="Tarefa-2")

t1.start()
t2.start()
```

**Saída típica**

```
Thread Tarefa-1 | ID interno: 140463276087040 | Param: A
Thread Tarefa-2 | ID interno: 140463267694336 | Param: B
```



## Resumo

| Conceito       | Java                                   | C#                                     | Python                            |
| -------------- | -------------------------------------- | -------------------------------------- | --------------------------------- |
| Nome da thread | `Thread.currentThread().getName()`     | `Thread.CurrentThread.Name`            | `threading.current_thread().name` |
| ID da thread   | `Thread.currentThread().getId()`       | `Thread.CurrentThread.ManagedThreadId` | `threading.get_ident()`           |
| Passar param   | Construtor do `Runnable` ou `Callable` | Passado no `Start(obj)`                | Passado no `args` do `Thread()`   |


