# Quadro Branco
## Aula 18 - Atividades de recuperação
    - Usando a tecnologia RPC ou RMI, construir um sistema que:
        - receba uma string com fundamentos do padel e retorne um objeto
            - string a ser enviada ao servidor: nomeFundamento;zonaEmQueOcorreuFundamento;resultado
                vo;z2;e
                vo;z1;p
                vo;z3;e
                sm;z1;p
                - fundamentos: voleio (vo), smash (sm), bandeja (ba)
                - zonas: zona1 (z1); zona2 (z2); zona3 (z3)
                - resultado: ponto (p); erro (e)
            - objeto do tipo Jogada(nomeFundamento, zona, resultado)

## Aula 17 - JGroups
    - Apresentação de trabalhos

## Aula 16 - JGroups
    - Desafio (2 pts). Melhorias no sistema JGroups_Aula - https://github.com/alexandrezamberlan/sistemasDistribuidos/tree/master/8-JGroups/JGroups
        - ao lado dos membros (modo gráfico, mostrar IP)
        - quando um membro sair do grupo, gerar notificação na área de msg coletiva
        - quando um usuário entrar atrasado, atualizar as msg para ele

## Aula 15 - Multicast Java
    - Tecnologia Multicast
        - arquitetura ponto-a-ponto
            - máquina/estação é servidor e cliente
        - protocolo de transporte padrão: UDP
            - montar mensagem + enviar mensagem (bloqueantes)
            - receber (bloqueante)
        - conceitos:
            - IP do Grupo (ip falso, na convenção 239.X.Y.W)
            - Porta de conexão (saída da estação)
            - Threads 'ouvidora' ou 'receptora' + 'falante' ou 'enviadora' ('quebrar' as ações bloqueantes)

## Aula 11 - Remote Procedure Call (RPC)
    - Exercício de fixação RMI Java
        - Ter como base os códigos trabalhados em laboratório
        - Refatorar os códigos para que os serviços do servidor sejam:
            - receber um nome completo e devolver um email (nome.sobrenome@ufn.edu.br)
            - receber um nome completo e devolver uma chave hash 
    - Tecnologia ou um recurso em que máquinas (sem poder computacional | clientes) solicitam processos em outra máquina (com poder computacional | servidor)
    - A relação entre clientes e servidor vai se dar por serviços via Interface
    - Exemplo:
        Cliente                                 Servidor
         - Classe Client                         - Classe Server: ip, porta, socket, ...
         - 'Menu' de Serviços                        - IServicos - ou a implementação dos serviços/métodos
                                                     - servico1()
                                                     - servico2()
    - RPC é técnica ou o recurso
        Java: Remote Method Invocation - RMI
        Python: RPC
        C#: xmlRPC


## Aula 10 - Programação Socket UDP
    - Exemplo de código UDP
    - Jogo da cobrinha com sockets: adaptar o jogo da pasta https://github.com/alexandrezamberlan/sistemasDistribuidos/tree/master/4-ThreadSocketCobrinha
        **Ciência da Computação**
            - No cliente, adicionar informações no form de: ip e porta do servidor; placar do jogo; obstáculos (usar matriz ou compononente gráfico equivalente)
            - No servidor, adicionar informações do form de: placar do jogo; jogar novamente; obstáculos (usar matriz ou compononente gráfico equivalente)
        **Sistemas de Informação**
            - No cliente, adicionar informações no form de: ip e porta do servidor; placar do jogo
            - No servidor, adicionar informações do form de: placar do jogo; jogar novamente
    - Gerador de códigos (como o Google Authenticator)
        - em algum lado (servidor ou cliente) ter uma lista de frutas (8 frutas)
        - toda vez que alguem conectar envvia um fruta sorteada a quem se conectou

## Aula 9 - Programação Socket com Classe Comunicador
    - Diferença entre TCP e UDP
    - Atividade avaliativa:
        - Refatorar o código Socket do Gerar Email: https://github.com/alexandrezamberlan/sistemasDistribuidos/tree/master/3-Sockets/src/exemplo2_gerarEmail
            - incluir modo gráfico e classe Comunicador

## Aula 8 - Programação Socket em Java + modo gráfico
    - Uso de sockets
        - arquitetura cliente-servidor: chat (tanto servidor, quanto cliente escreviam e liam no socket)
        - arquitetura cliente-servidor: servidor é um prestador de serviço. Instancia/conecta, recebe cliente, processa, devolve, fecha e recomeça o ciclo

## Aula 7 - Correção e Discussão da Prova + Socket
    - Socket é um recurso de baixo nível
    - Conecta 2 máquinas
    - Usa o modelo TCP/IP: endereço IP, porta lógica
    - Estrutura clássica para a arquitetura cliente-servidor
        - servidor (java): ServerSocket (porta logica autorizada) + Socket (representando o cliente) + leitor (input) e escritor (output) de socket + threads para não bloquear a comunicação
        - cliente: Socket (endereço ip + porta lógica do servidor) + leitor (input) e escritor (output)

## Aula 6 - Avaliação

## Aula 5 - Sincronização Distribuída – Relógios Físicos e Lógicos. Exclusão Mútua e Eleição.
    - Teoria básica de sistemas distribuídos
        - o que é e para que serve -> compartilhar recurso (cpu, ram, memória secundária)
        - diferenças entre grid (computação concomitante) e cluster (computação paralela)
            - programação concomitante = threads
            - programação paralela = cuda, openMP, MPI
        - comunicação entre computadores ou equipamentos em sistemas distribuídos
            - model TCP/IP: endereço, porta, máscara de rede, socket, camada de transporte (UDP e TCP)
        - comunicação é leitura (consumidor) ou é escrita (produtor) - É BLOQUEANTE
            - THREADS: mini processos concomitantes -> desbloquear a comunicação
                - sem memória compartilhada - somente rotinas/tarefas
                - com memória compartilhada - rotinas/tarefas + seção crítica
                - delegar uma rotina para thread; passar parâmetros; identificação
            - SINCRONISMO -> acesso a seção crítica -> memória compartilhada
                - java: sincronized
                - c# e python: lock
                - via relógio: físico e lógico (lamport)
                - exclusão mútua - lock ou relógio ou eleição

    - Poll de Threads

    - Atividades:
        - pesquisar, compilar e disponibilizar nos githubs pessoais sobre Relógios Físicos e Lógicos. Exclusão Mútua e Eleição
        - pesquisar e compilar sobre a teoria de poll de threads
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


                

    
