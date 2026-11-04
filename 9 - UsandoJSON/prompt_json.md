No universo de engenharia de prompt e arquiteturas RAG (Retrieval-Augmented Generation), um Prompt JSON é a prática de estruturar as instruções, o contexto (como esquemas de banco de dados) e a saída esperada utilizando o formato JSON.
Em sistemas de produção, os LLMs precisam interagir de forma previsível com sistemas de software. O texto livre (linguagem natural pura) falha muito nessa comunicação porque varia muito. O JSON força o modelo a "pensar" de forma estruturada e responder em formatos que sistemas de código conseguem ler nativamente (com um simples json.loads()).

Por que usar Prompt JSON em cenários de RAG com Banco de Dados?

1. Separação Clara de Contexto: Evita que o modelo confunda dados recuperados (metadados, linhas, tabelas) com as instruções do sistema.
2. Casamento Perfeito com Esquemas: Bancos de dados relacionais e NoSQL possuem esquemas estruturados. Passar esses esquemas em JSON torna a assimilação do modelo muito mais precisa.
3. Casos de Uso Comuns:
	• Text-to-SQL: O usuário faz uma pergunta em texto e o modelo gera a query SQL exata analisando o esquema JSON.
	• RAG Filtrado: O modelo analisa a pergunta do usuário e decide quais tabelas ou filtros de banco de dados ele precisa buscar antes de responder.

Exemplo Prático de Prompt JSON (Cenário: Text-to-SQL em RAG)

Imagine um sistema onde o usuário pergunta sobre os alunos do seu sistema, e o LLM precisa consultar o banco de dados.

O Prompt estruturado em JSON enviado ao Modelo:

json
{
  "contexto_sistema": {
    "role": "Engenheiro de Dados IA",
    "tarefa": "Analisar a pergunta do usuario, mapear contra o esquema do banco de dados fornecido e gerar a query SQL correspondente."
  },
  "esquema_banco_dados": {
    "tabela": "alunos",
    "colunas": [
      {"nome": "id", "tipo": "INTEGER", "chave_primaria": true},
      {"nome": "nome", "tipo": "VARCHAR(100)"},
      {"nome": "idade", "tipo": "INTEGER"},
      {"nome": "matricula", "tipo": "VARCHAR(20)", "unique": true}
    ]
  },
  "entrada_usuario": {
    "pergunta": "Quais são as matrículas dos alunos com mais de 21 anos?"
  },
  "formato_saida_esperado": {
    "pensamento_passo_a_passo": "Sua lógica de raciocínio sobre quais colunas e filtros usar.",
    "sql_gerado": "A query SQL pura, sem formatação markdown (```sql).",
    "status": "sucesso ou erro se não for possível gerar."
  }
}
Use o código com cuidado.
Nota: Você envia exatamente esse JSON no prompt, muitas vezes precedido por uma linha curta em linguagem natural como: "Analise o seguinte objeto JSON e retorne estritamente o formato de saída esperado:"

A Resposta gerada pelo Modelo (também em JSON):

Como você instruiu o formato de saída em JSON, o modelo responderá exatamente assim:
json
{
  "pensamento_passo_a_passo": "O usuário quer filtrar alunos pela idade maior que 21. A tabela é 'alunos'. A coluna de filtro é 'idade' e o retorno deve ser a coluna 'matricula'.",
  "sql_gerado": "SELECT matricula FROM alunos WHERE idade > 21;",
  "status": "sucesso"
}
Use o código com cuidado.

3 Regras de Ouro para Engenharia de Prompt JSON

1. Use Delimitadores de Código: Envolva o JSON do prompt em blocos de código markdown (json ... ). Isso ajuda o modelo a entender onde começa e termina a estrutura de dados.
2. Force o Modo JSON da API (JSON Mode): Se você estiver utilizando APIs da OpenAI (GPT-4o), Anthropic (Claude) ou Google (Gemini), ative o parâmetro response_format={"type": "json_object"} ou use Structured Outputs/Tools. Isso força o modelo a retornar um JSON válido a nível de hardware/tokenização.
3. Forneça Exemplos (Few-shot): Se o esquema do seu banco de dados for muito complexo (muitas chaves estrangeiras ou relacionamentos), inclua um par de exemplo_entrada e exemplo_saida em JSON dentro do próprio prompt para o modelo entender o padrão.
Você está planejando construir um sistema de Text-to-SQL (gerar queries automaticamente) ou o seu RAG vai buscar dados estruturados para gerar relatórios textuais para o usuário? Se quiser, posso te mostrar como ficaria o código Python usando as bibliotecas de IA para implementar esse fluxo estruturado.
