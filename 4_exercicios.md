# Exercícios de fixação

## Threads

1. Divisão e Conquista: Soma de Sublistas

    Contexto: O processamento de grandes volumes de dados numéricos.

    Problema: Dado um vetor ou lista com 10.000 números inteiros aleatórios, divida essa lista em 4 partes iguais.

    Ação: Crie 4 threads. Cada thread recebe apenas uma das partes como parâmetro de entrada, calcula a soma dos elementos dessa sublista e retorna o valor final.

    Encerramento: A thread principal aguarda o fim das 4 threads, coleta as 4 somas parciais e calcula a soma total.

2. Filtro de Dados Independente (Map)

    Contexto: Limpeza e saneamento de bases de dados.

    Problema: Você tem uma lista com 5.000 strings contendo nomes de usuários gravados em um arquivo txt.

    Ação: Divida a lista em 2 blocos. A Thread A recebe a primeira metade e a Thread B recebe a segunda metade. Cada thread deve processar sua sublista isolada, aplicando regras de limpeza: remover espaços em branco no início/fim e converter todo o texto para letras maiúsculas.

    Encerramento: Cada thread retorna uma nova lista limpa. A thread principal junta as duas listas resultantes.

3. Pesquisar, compilar e disponibilizar nos githubs pessoais sobre Relógios Físicos e Lógicos. Exclusão Mútua e Eleição
    
4. Pesquisar e compilar sobre a teoria de pool de threads - criar exemplos usando listas


5: Analisador de Logs Distribuído (MapReduce Local)
    
    Os alunos devem criar um sistema para processar arquivos de log gigantescos.

    O Cenário: Um processo coordenador lê o arquivo grande. Ele divide o arquivo em pedaços menores.
    
    A Regra do Pool: O coordenador envia cada pedaço para um pool de trabalhadores usando filas de mensagens (mensageria).
    
    Sem Memória Compartilhada: Os trabalhadores não podem alterar variáveis globais. Cada trabalhador processa seu pedaço de forma isolada e devolve um resumo parcial (contagem de erros, por exemplo).
    
    O Resultado: O coordenador junta todos os resumos e mostra o resultado final.
    
6: Simulador de Chat por Mensageria
    
    Os alunos devem criar um mini chat onde o estado não é compartilhado entre as threads.
    
    O Cenário: Vários clientes se conectam ao servidor.
    
    A Regra do Pool: O servidor usa um pool de trabalhadores (estilo modelo de atores). Cada trabalhador cuida de um grupo de usuários ou de salas específicas.
    
    Sem Memória Compartilhada: As threads não acessam uma lista global de usuários conectados. Para enviar uma mensagem de um usuário para outro, a thread remetente precisa enviar uma mensagem em formato de rede ou canal para a thread destino.
    
    O Resultado: O chat funciona em tempo real apenas com envio de mensagens entre os componentes isolados.
