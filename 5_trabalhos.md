# Trabalhos avaliativos

## Threads

### Módulo 1: Com Compartilhamento de Memória (Threads/State)
Foco em sincronização, condições de corrida e exclusão mútua.

#### Exercício 1: Sistema de Caixa Centralizado de Evento (Dificuldade: Média)

* Contexto: Um grande festival de música possui 5 caixas físicos vendendo fichas de alimentação simultaneamente. Todos os caixas atualizam o mesmo saldo bancário centralizado do evento.

* Requisitos:
    1. Crie uma variável global/compartilhada chamada saldo_central.
    2. Instancie 5 threads (representando os caixas).
    3. Cada thread deve simular a venda de 1.000 fichas (cada ficha custa R$ 10,00), somando o valor ao saldo_central.
    4. O saldo final esperado deve ser exatamente R$ 50.000,00.

* O que avalia: utilização de mecanismos de sincronização (synchronized/ReentrantLock em Java ou threading.Lock em Python) para garantir a consistência do saldo.


### Módulo 2: Sem Compartilhamento de Memória (Message Passing/Isolation)
Foco em divisão de tarefas, junção de resultados e isolamento de escopo.

#### Exercício 2: Processamento de Relatório de Vendas por Filial (Dificuldade: Fácil)

* Contexto: Uma franquia precisa calcular o faturamento total anual somando os dados independentes de suas 4 filiais.

* Requisitos:
    1. Crie 4 listas independentes de números locais, cada um simulando as vendas de uma filial (ex: 10.000 registros por lista).
    2. Dispare 4 threads. Cada thread recebe apenas a lista da sua respectiva filial e calcula a soma localmente.
    3. As threads não podem acessar variáveis globais durante a execução.
    4. A thread principal deve aguardar o fim de todas e somar os 4 resultados finais.

* O que avalia: Conceito de Fork-Join e isolamento. Em Java, avalia o uso de join() com classes que estendem Thread/implementam Runnable (guardando o resultado em um atributo do objeto) ou Future/Callable. Em Python, avalia o uso de threading.Thread com retorno planejado ou concurrent.futures.
