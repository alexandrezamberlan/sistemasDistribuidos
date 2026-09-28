## Trabalho Prático: Sistemas Distribuídos (Cliente-Servidor via UDP)
Objetivo:
Desenvolver uma aplicação cliente-servidor utilizando comunicação UDP por meio da classe Comunicador e uma interface gráfica (GUI).
Requisitos do Sistema:

* Interface Gráfica: O cliente deve possuir uma interface gráfica desenvolvida em Java Swing (ou outro ambiente gráfico de sua preferência/outra linguagem).
* Comunicação: Todo o envio e recebimento de dados deve ser feito via protocolo UDP.

------------------------------
## Dinâmica e Funcionamento da Arquitetura## 1. Cadastro do Cliente

* O cliente inicia o contato com o servidor enviando seu nome completo e e-mail.
* O servidor deve registrar o usuário em uma lista interna utilizando a classe Pessoa (conforme visto em aula).
* O servidor deve controlar e impedir cadastros duplicados.

## 2. Autenticação por Chave Temporária (Token)

* O cliente deve solicitar periodicamente ao servidor uma chave token (gerada de forma aleatória).
* Cada token tem validade estrita de 60 segundos.
* Se o cliente solicitar um novo token dentro do prazo de 60 segundos, o servidor mantém o mesmo token. Caso o tempo expire, o servidor deve gerar e retornar uma nova chave.


