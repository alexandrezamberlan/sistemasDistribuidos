
# Sistemas Distribuídos

---

## **Parte 1 – Questões Teóricas**

**1. Definição conceitual:**
Sistema distribuído = conjunto de computadores independentes que se apresentam ao usuário como um sistema único e coerente.
Exemplos: Google Drive, Netflix, Blockchain, WhatsApp.

**2. Objetivos principais:**

* Transparência (de acesso, localização, replicação, falha).
* Confiabilidade.
* Escalabilidade.
* Compartilhamento de recursos.

**3. Comunicação síncrona vs assíncrona:**

* **Síncrona:** remetente espera resposta (bloqueante). → Mais simples, mas menos eficiente.
* **Assíncrona:** remetente não espera (não bloqueante). → Mais rápido, mas exige controle.

**4. Arquiteturas:**

* **Cliente-Servidor:** um servidor central atende vários clientes. Ex: Gmail.
* **P2P:** cada nó atua como cliente e servidor. Ex: BitTorrent.

**5. Tipos de falhas:**

* Falhas de comunicação: perda de pacotes.
* Falhas de processo: crash de servidor.
* Falhas de hardware: queda de energia, disco corrompido.

**6. Relógios físicos vs lógicos:**

* **Físicos:** baseados em tempo real (NTP).
* **Lógicos:** baseados em ordem causal de eventos (Lamport).

**7. Algoritmo de Lamport:**
Cada processo mantém contador lógico.

* Evento local: incrementa contador.
* Mensagem enviada: inclui contador.
* Ao receber: atualiza contador = max(local, recebido)+1.
  → Define ordem causal de eventos ($a \rightarrow b$).

**8. Threads com memória compartilhada vs mensagens:**

* **Memória compartilhada:** comunicação via variáveis comuns. Mais rápido, mas sujeito a corrida.
* **Mensagens:** comunicação explícita. Mais seguro, mas mais lento.

**9. Escalabilidade:**
Capacidade de suportar mais usuários/processos.
Técnicas:

* Replicação de servidores.
* Balanceamento de carga.
* Particionamento de dados.

**10. Caso Netflix:**

* Replicação de dados para disponibilidade.
* Balanceamento de carga (CDNs).
* Tolerância a falhas: redirecionamento automático em falhas de servidores.

---

## **Parte 2 – Questões Práticas em Python**

**11. Thread básica (pares/ímpares):**

```python
import threading

def pares():
    for i in range(0, 21, 2):
        print("Par:", i)

def impares():
    for i in range(1, 20, 2):
        print("Ímpar:", i)

t1 = threading.Thread(target=pares)
t2 = threading.Thread(target=impares)

t1.start()
t2.start()

t1.join()
t2.join()
```

---

**12. Threads com atraso:**

```python
import threading, time

def tarefa(nome, atraso):
    for i in range(3):
        print(nome, "execução", i+1)
        time.sleep(atraso)

threads = [
    threading.Thread(target=tarefa, args=("Thread 1", 1)),
    threading.Thread(target=tarefa, args=("Thread 2", 2)),
    threading.Thread(target=tarefa, args=("Thread 3", 3))
]

for t in threads: t.start()
for t in threads: t.join()
```

---

**13. Condição de corrida (sem lock):**

```python
import threading

contador = 0

def incrementa():
    global contador
    for _ in range(100000):
        contador += 1

t1 = threading.Thread(target=incrementa)
t2 = threading.Thread(target=incrementa)

t1.start(); t2.start()
t1.join(); t2.join()

print("Contador final:", contador)
# O valor varia, devido à condição de corrida
```

---

**14. Usando Lock:**

```python
import threading

contador = 0
lock = threading.Lock()

def incrementa():
    global contador
    for _ in range(100000):
        with lock:
            contador += 1

t1 = threading.Thread(target=incrementa)
t2 = threading.Thread(target=incrementa)

t1.start(); t2.start()
t1.join(); t2.join()

print("Contador final:", contador)
```

---

**15. Produtor-Consumidor:**

```python
import threading, queue, time, random

fila = queue.Queue()

def produtor():
    for i in range(5):
        item = random.randint(1,100)
        print("Produzido:", item)
        fila.put(item)
        time.sleep(1)

def consumidor():
    for i in range(5):
        item = fila.get()
        print("Consumido:", item)
        time.sleep(2)

t1 = threading.Thread(target=produtor)
t2 = threading.Thread(target=consumidor)

t1.start(); t2.start()
t1.join(); t2.join()
```

---

**16. Relógio lógico (Lamport simplificado):**

```python
import threading, time, random

contador = [0, 0]

def processo(id, outro):
    global contador
    for _ in range(5):
        contador[id] += 1
        print(f"Processo {id}: evento local, clock {contador[id]}")
        if random.random() > 0.5:  
            contador[outro] = max(contador[id], contador[outro]) + 1
            print(f"Processo {id} envia msg → Processo {outro}, clock {contador}")
        time.sleep(1)

t1 = threading.Thread(target=processo, args=(0,1))
t2 = threading.Thread(target=processo, args=(1,0))

t1.start(); t2.start()
t1.join(); t2.join()
```

---

**17. Thread com parâmetro (soma de lista):**

```python
import threading

resultado = 0

def soma_lista(lista):
    global resultado
    resultado = sum(lista)

lista = [1,2,3,4,5]
t = threading.Thread(target=soma_lista, args=(lista,))
t.start()
t.join()
print("Soma:", resultado)
```

---

**18. Barrier (sincronização):**

```python
import threading, time

barreira = threading.Barrier(4)

def tarefa(id):
    print(f"Thread {id} executando parte 1")
    time.sleep(1)
    barreira.wait()
    print(f"Thread {id} passou para parte 2")

threads = [threading.Thread(target=tarefa, args=(i,)) for i in range(4)]

for t in threads: t.start()
for t in threads: t.join()
```

---

**19. Deadlock e solução:**

```python
import threading, time

lock1 = threading.Lock()
lock2 = threading.Lock()

def tarefa1():
    with lock1:
        time.sleep(1)
        with lock2:
            print("Tarefa1 finalizada")

def tarefa2():
    with lock2:
        time.sleep(1)
        with lock1:
            print("Tarefa2 finalizada")

t1 = threading.Thread(target=tarefa1)
t2 = threading.Thread(target=tarefa2)

t1.start(); t2.start()
t1.join(); t2.join()
# Deadlock pode ocorrer! 
# Para evitar: adquirir locks em ordem consistente (sempre lock1 antes de lock2).
```

---

**20. Servidor multi-thread com socket:**

```python
import socket, threading

def atende_cliente(conn, addr):
    print("Conexão de:", addr)
    while True:
        data = conn.recv(1024)
        if not data: break
        conn.sendall(data.upper())
    conn.close()

HOST = '127.0.0.1'
PORT = 5000
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen()

print("Servidor ativo em", (HOST, PORT))

while True:
    conn, addr = server.accept()
    t = threading.Thread(target=atende_cliente, args=(conn, addr))
    t.start()
```
