# Engenharia de Prompt: Guia de Prompt JSON em Arquiteturas RAG

No universo de engenharia de prompt e arquiteturas **RAG (Retrieval-Augmented Generation)**, um **Prompt JSON** é a prática de estruturar as instruções, o contexto (como esquemas de banco de dados) e a saída esperada utilizando o formato JSON. 

Em sistemas de produção, os LLMs (Modelos de Linguagem de Grande Porte) precisam interagir de forma previsível com sistemas de software. O texto livre (linguagem natural pura) falha muito nessa comunicação devido à sua imprevisibilidade. O JSON força o modelo a **pensar de forma estruturada e responder em formatos que sistemas de código conseguem ler nativamente** (com um simples `json.loads()`).

---

## Por que usar Prompt JSON com Banco de Dados em RAG?

1. **Separação Clara de Contexto:** Evita que o modelo confunda dados recuperados (metadados, linhas, tabelas) com as instruções operacionais do sistema.
2. **Casamento Perfeito com Esquemas:** Bancos de dados relacionais e NoSQL possuem esquemas estruturados. Passar esses esquemas em JSON torna a assimilação do modelo muito mais precisa.
3. **Casos de Uso Comuns:**
   * **Text-to-SQL:** O usuário faz uma pergunta em texto livre e o modelo gera a query SQL exata analisando o esquema JSON fornecido.
   * **RAG Filtrado:** O modelo analisa a intenção do usuário e decide quais tabelas ou filtros de banco de dados ele precisa buscar antes de consultar a base de conhecimento.

---

## Exemplo Prático: Cenário Text-to-SQL em RAG

Imagine um sistema onde o usuário pergunta sobre os dados de alunos, e o LLM precisa consultar o banco de dados de forma automatizada.

### 1. O Prompt Estruturado Enviado ao Modelo
Você pode enviar o prompt envelopado por uma instrução direta em linguagem natural: *"Analise o seguinte objeto JSON e retorne estritamente o formato de saída esperado."*

```json
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
    "sql_gerado": "A query SQL pura, sem formatação markdown.",
    "status": "sucesso ou erro se não for possível gerar."
  }
}
```

### 2. A Resposta Gerada pelo Modelo
Como a instrução delimitou o formato de saída, o modelo responde mapeando estritamente as chaves requisitadas:

```json
{
  "pensamento_passo_a_passo": "O usuário quer filtrar alunos pela idade maior que 21. A tabela é 'alunos'. A coluna de filtro é 'idade' e o retorno deve ser a coluna 'matricula'.",
  "sql_gerado": "SELECT matricula FROM alunos WHERE idade > 21;",
  "status": "sucesso"
}
```

---

## 3 Regras de Ouro para Engenharia de Prompt JSON

1. **Use Delimitadores de Código:** Envolva o JSON do prompt em blocos de código markdown (\`\`\`json ... \`\`\`). Isso ajuda o tokenizador do modelo a entender exatamente onde começam e terminam as estruturas de dados.
2. **Force o Modo JSON da API (JSON Mode / Structured Outputs):** Ao integrar com APIs como OpenAI, Anthropic ou Google Gemini, ative parâmetros de restrição de formato (como `response_format={"type": "json_object"}`). Isso força validações sintáticas diretamente na amostragem de tokens da IA.
3. **Forneça Exemplos (Few-shot):** Se o esquema do seu banco de dados contiver relacionamentos complexos ou chaves estrangeiras ambíguas, inclua pares de `exemplo_entrada` e `exemplo_saida` em JSON dentro do prompt para ditar o padrão comportamental esperado.
