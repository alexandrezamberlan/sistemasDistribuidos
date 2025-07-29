# Comunicação e Sincronismo em Sistemas Distribuídos


### 1. Comunicação entre máquinas

Em sistemas distribuídos, as máquinas (ou nós) estão fisicamente separadas e conectadas via rede. Para que trabalhem em conjunto, elas precisam **trocar informações** — isso é a comunicação distribuída.

* **Papel:** Permitir que processos rodando em máquinas diferentes se comuniquem, coordenem ações, compartilhem dados, e cooperem para realizar tarefas maiores.
* **Como acontece:** Via troca de mensagens usando protocolos de rede (TCP/IP, HTTP, RPC, etc).
* **Desafios:**

  * Latência e largura de banda da rede.
  * Falhas na transmissão (perda de mensagens, duplicação, atraso).
  * Heterogeneidade dos sistemas.
* **Importância:** Sem comunicação eficiente, o sistema não funciona, pois os nós não conseguem sincronizar suas ações nem trocar dados necessários.

---

### 2. Sincronização

Em um sistema distribuído, processos ou nós muitas vezes precisam coordenar suas ações para:

* Evitar conflitos (ex: acesso concorrente a um recurso compartilhado).
* Garantir a ordem correta de eventos.
* Manter a consistência dos dados.

**Sincronismo** é o mecanismo que permite essa coordenação, apesar das máquinas estarem separadas e se comunicarem via rede (que é lenta e não confiável).

* Pode ser **sincronismo temporal** (relógios sincronizados para ordenar eventos).
* Ou **sincronismo de ações** (esperar resposta, barreiras, locks distribuídos).
* **Exemplo prático:** Dois nós que querem atualizar um banco de dados compartilhado precisam garantir que as atualizações não causem inconsistência — usam sincronização para coordenar quem pode alterar o dado primeiro.

---

### Por que a sincronização é complexa em sistemas distribuídos?

* Não existe um relógio global perfeitamente sincronizado.
* Mensagens podem chegar fora de ordem ou se perder.
* Nós podem falhar ou ficar lentos.
* Por isso, técnicas como relógios lógicos (Lamport), algoritmos de consenso (Paxos, Raft), e mecanismos de exclusão mútua distribuída são fundamentais.

---

### Resumo:

| Aspecto                    | Descrição                                                                                  |
| -------------------------- | ------------------------------------------------------------------------------------------ |
| Comunicação entre máquinas | Troca de mensagens entre processos/nós distantes para cooperar                             |
| Recurso de sincronismo     | Mecanismos que garantem coordenação, ordenação e consistência entre processos distribuídos |

