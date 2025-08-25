# Quadro Branco

## Aula 5 - Sincronização Distribuída – Relógios Físicos e Lógicos. Exclusão Mútua e Eleição.
    - Teoria básica de sistemas distribuídos
        - o que é e para que serve -> compartilhar recurso (cpu, ram, memória secundária)
        - diferenças entre grid (computação concomitante) e cluster (computação paralela)
        - comunicação entre computadores ou equipamentos em sistemas distribuídos
            - model TCP/IP: endereço, porta, máscara de rede, socket, camada de transporte (UDP e TCP)
        - comunicação é leitura (consumidor) ou é escrita (produtor) - É BLOQUEANTE
            - THREADS: mini processos concomitantes -> desbloquear a comunicação
                - sem memória compartilhada
                - com memória compartilhada
                - delegar uma rotina para thread; passar parâmetros; identificação
            - SINCRONISMO -> acesso a seção crítica -> memória compartilhada
                - java: sincronized
                - c# e python: lock
                - via relógio: físico e lógico
                - exclusão mútua - lock ou relógio ou eleição

    - Poll de Threads - Matheus vai enviar o link dos exemplos

    - Atividades:
        - pesquisar, compilar e disponibilizar nos githubs pessoais sobre Relógios Físicos e Lógicos. Exclusão Mútua e Eleição
        - refazer ou compreender o Tele Jogo com uso de threads (sem e com compartilhamento de recurso)


## Aula 4 - Threads
    - Entrega do desafio 2
    - Revisão
        - passagem de parâmetro Java (construtor), C# (construtor) e Python (args)
        - quando threads NÃO DEVEM ser utilizadas
            - baixa complexidade das rotinas ou tarefas envolvidas
            - seção crítica:
                - não há possibilidade de gerenciar via sincronismo (java) e lock (C# e Python)
    - Threads com memória compartilhada

        
## Aula 3 - Threads

Threads
    - o que são?
        - mini processos dentro de processos para realizar tarefas ou rotinas de forma concomitante
    - para que servem?
        - circundam rotinas ou tarefas para essas possam executar concomitantemente
    - em quais tarefas as threads são mais adequadas?
        - mineração
            - tratamento de dados
            - análise de dados
        - rotinas que não possuam seção crítica 
    - em quais tarefas ou situações threads NÃO SÃO adequadas?
        - de interação com o usuário

    - tipos de threads
        - sem memória compartilhada - sem seção crítica
        - com memória compartilhada - com seção crítica


Exercícios:
    Para os códigos Threads em Java, C# e Python, adicionar rotinas que identifiquem as threads em execução ou finalizadas

Desafio para depois do intervalo:
    Fazer um programa na sua linguagem de preferência que:
        i) distribua n números em m listas de inteiros, sendo que os números devem variar entre 1000 a 100000
        ii) que faça a média dos valores gerados em todas as listas
        iii) circundar as rotinas com threads, desde que possível

        DICA:
            JAVA
                List<List> listaDeListas = new ArrayList<>();
                int totalListas = 1000;
                for (int i = 0; i < totalListas; i++) {
                    listaDeListas.add( new ArrayList<Integer>());
                }

                for (int i = 0; i < totalListas; i++) {
                    new PopulaLista(listaDeListas.get(i), tamanhoLista).start();
                }

## Aula 2
    - Threads nas 3 linguagens: ideia geral
    - Desafio 1: Jogo da cobrinha

## Aula 1
    - Apresentação e discussão do plano de ensino
    - Conceitos básicos de SD: comunicação, arquitetura, 


                

    
