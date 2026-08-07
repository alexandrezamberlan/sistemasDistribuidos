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