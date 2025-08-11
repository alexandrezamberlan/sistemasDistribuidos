# Diferenças entre arquitetura Cliente-Servidor e Ponto-a-Ponto
---

### Arquitetura Cliente-Servidor

* **Modelo centralizado:** Existe uma ou mais máquinas que atuam como **servidores**, responsáveis por fornecer serviços, dados ou recursos.
* Os **clientes** são máquinas que solicitam serviços ou recursos dos servidores.
* Os servidores gerenciam, controlam e atendem as requisições dos clientes.
* Comunicação é normalmente **unidirecional na requisição:** clientes fazem pedidos, servidores respondem.
* Exemplo típico: um site web, onde o navegador é cliente e o servidor web entrega as páginas.

#### Características:

* **Centralização:** servidores têm um papel chave.
* **Dependência:** se o servidor ficar indisponível, os clientes podem perder acesso ao serviço.
* **Gerenciamento:** fácil controle e administração centralizada.

---

### Arquitetura Ponto-a-Ponto (P2P)

* **Modelo descentralizado:** todos os nós (ou “pares”) têm papéis equivalentes — eles podem atuar tanto como clientes quanto como servidores.
* Cada nó pode **solicitar e fornecer** recursos diretamente para outros nós, sem precisar de um servidor central.
* Comunicação é **direta entre pares**, podendo ser mais distribuída e resiliente.
* Exemplo típico: redes de compartilhamento de arquivos como BitTorrent.

#### Características:

* **Descentralização:** não há um ponto único de falha.
* **Escalabilidade:** facilmente escalável porque cada nó contribui com recursos.
* **Resiliência:** se um nó falhar, o sistema continua funcionando.

---

### Resumo da diferença

| Aspecto              | Cliente-Servidor                       | Ponto-a-Ponto (P2P)                  |
| -------------------- | -------------------------------------- | ------------------------------------ |
| Estrutura            | Centralizada (servidor + clientes)     | Descentralizada (nós equivalentes)   |
| Papel dos nós        | Servidores fornecem, clientes consomem | Todos podem fornecer e consumir      |
| Comunicação          | Cliente → Servidor                     | Nó ↔ Nó direto                       |
| Ponto único de falha | Sim (servidor)                         | Não (descentralizado)                |
| Escalabilidade       | Limitada pelo servidor                 | Alta, pois recursos são distribuídos |
| Exemplo              | Web, bancos de dados                   | BitTorrent, redes blockchain         |

