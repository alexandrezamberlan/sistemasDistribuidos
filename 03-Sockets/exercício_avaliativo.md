# Exercício sobre socket, arquitetura cliente-servidor e threads.

## Códigos base para o exercício 
  - https://github.com/alexandrezamberlan/sistemasDistribuidos/tree/master/03-Sockets/src/exemplo2_gerarEmail
    


### Desafio Prático: Sistema de Cadastro Acadêmico com Redes e GUI

Desenvolva uma aplicação Cliente/Servidor multithread em Java integrada com interfaces gráficas (Java Swing), utilizando Sockets TCP e streams de objetos (ObjectInputStream / ObjectOutputStream).

#### Requisitos do Cliente (ClienteGUI):

- Possuir campos de texto (JTextField) para preenchimento: Nome Completo e Data de Nascimento (padrão dd/MM/yyyy).
- Possuir um botão "Enviar". Ao ser clicado, deve validar os campos e enviar os dados (individualmente ou encapsulados na classe Pessoa) para o servidor.
- Possuir três campos de texto bloqueados para edição (setEditable(false)), que exibirão o Nome, E-mail e Data de Nascimento retornados de dentro do objeto Pessoa enviado pelo servidor.
  
#### Requisitos do Servidor (ServidorGUI):

- Exibir uma interface com uma área de log (JTextArea) e uma lista gráfica (ArrayList ou equivalente) com as pessoas cadastradas.
- Ao receber os dados do cliente, deve instanciar um objeto Pessoa.
- Regra de Negócio do E-mail: O e-mail deve ser gerado automaticamente seguindo a lógica:

  primeiro_nome.ultimo_sobrenome.ano_nascimento@ufn.edu.br (tudo em minúsculas).

- Armazenamento: Adicionar o objeto em uma lista. Se o objeto já existir na lista (mesmo nome e data de nascimento), ignore a inserção duplicada.
- Retorno: Devolver o objeto Pessoa criado/localizado de volta ao cliente.

#### Atenção aos Detalhes de Sistemas Distribuídos e Concorrência:

1. A classe Pessoa deve ser trafegável na rede. O que é necessário implementar nela?
2. As operações de rede (Sockets) bloqueiam a execução. Como evitar que a interface gráfica (tanto do cliente quanto do servidor) "trave" ou congele enquanto espera pela rede?
3. Como garantir que a lista de pessoas no servidor não sofra de condições de corrida (Race Conditions) quando múltiplos clientes se conectarem simultaneamente?
