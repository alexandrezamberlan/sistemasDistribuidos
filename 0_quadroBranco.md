# Quadro Branco

## Aula 12/08 - Threads

Threads
    - o que são?
        - mini processos dentro de processos para realizar tarefas ou rotinas de forma concomitante
    - para que servem?
        - circundam rotinas ou tarefas para essas possam executar concomitantemente
    - em quais tarefas as threads são mais adequadas?
        - mineração
            - tratamento de dados
            - análise de dados
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



                

    
