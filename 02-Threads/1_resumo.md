# Diferença entre Processo e Thread

Em sistemas distribuídos (e em geral), **processo** e **thread** são conceitos fundamentais, mas diferentes. 

---

### Processo

* É uma **instância independente de um programa em execução**.
* Possui **seu próprio espaço de memória** (endereço, pilha, heap).
* Tem seus próprios **recursos do sistema**, como arquivos abertos, variáveis de ambiente, etc.
* Comunicação entre processos (IPC – *Inter-Process Communication*) é mais **complexa e custosa** (pipes, sockets, memória compartilhada, etc.).
* Se um processo falha, **não afeta outros processos**.

#### Exemplo:

Um servidor web pode rodar vários processos isolados para atender diferentes clientes simultaneamente.

---

### Thread

* É uma **unidade de execução dentro de um processo**.
* Todas as threads de um mesmo processo compartilham **o mesmo espaço de memória** e recursos.
* Comunicação entre threads é **rápida e simples**, pois compartilham o mesmo contexto.
* Se uma thread falha (por exemplo, corrompe memória), **pode comprometer o processo inteiro**.

#### Exemplo:

Dentro de um processo servidor web, você pode ter várias threads atendendo requisições simultâneas.

---

### Comparativo:

| Característica   | Processo                          | Thread                            |
| ---------------- | --------------------------------- | --------------------------------- |
| Isolamento       | Sim (cada um tem memória própria) | Não (compartilham memória)        |
| Comunicação      | Difícil (IPC)                     | Fácil (compartilhamento direto)   |
| Custo de criação | Alto                              | Baixo                             |
| Robustez         | Mais robusto (isolado)            | Menos robusto (compartilhado)     |
| Uso comum        | Isolar aplicações                 | Paralelizar tarefas dentro do app |

---

### Em sistemas distribuídos:

* **Processos** podem estar **em máquinas diferentes**, cada um executando parte de uma aplicação distribuída (por exemplo, um microserviço).
* **Threads** são usadas geralmente **dentro de um processo**, para aproveitar melhor os recursos da máquina local.

