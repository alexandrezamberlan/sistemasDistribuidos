# Trabalho do encurtador RPC

Usando sua linguagem de preferência e a biblioteca RPC equivalente, construa um sistema de arquitetura cliente-servidor para encurtar links ou urls passados do cliente ao servidor.

## Fluxo

### Cliente
  1) login (se necessário)
  2) informar url ou link a ser encurtado
  3) receber link encurtado e/ou QRCode gerado

### Servidor
  1) autenticar login (se necessário)
  2) receber o link ou url a ser encurtado
  3) gerar hash do link ou url
  4) armazenar em um hashmap
     - chave: hash gerado (hash_gerado)
     - conteudo: link ou url informado
  5) devolver:
     - o link encurtado com o padrão https://<IP DO SERVIDOR>/hash_gerado
     - OPCIONAL: um QRCode do link ou url informado
    
  Observações:
    - Na parte do cliente, a interface deve ser gráfica
    - Entrega deve ser na última semana de novembro (27/11), via email, com o link do github do trabalho.
    - Email: alexz@ufn.edu.br
