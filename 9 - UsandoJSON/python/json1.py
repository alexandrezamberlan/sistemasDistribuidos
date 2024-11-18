import json

class Aluno:
    def __init__(self, nome, idade, matricula):
        self.nome = nome
        self.idade = idade
        self.matricula = matricula

    def __repr__(self):
        return f"Aluno(nome='{self.nome}', idade={self.idade}, matricula='{self.matricula}')"

def aluno_para_dict(aluno):
    """Converte um objeto Aluno para dicionário."""
    return {
        "nome": aluno.nome,
        "idade": aluno.idade,
        "matricula": aluno.matricula
    }

def dict_para_aluno(d):
    """Converte um dicionário para um objeto Aluno."""
    return Aluno(d["nome"], d["idade"], d["matricula"])


alunos = [
    Aluno("Maria", 20, "A123"),
    Aluno("João", 22, "B456"),
    Aluno("Ana", 21, "C789")
]

# Serializando a lista de objetos Aluno para JSON
json_alunos = json.dumps(alunos, default=aluno_para_dict, indent=4)
print("Lista de Alunos em JSON:")
print(json_alunos)

# Desserializando o JSON de volta para uma lista de objetos Aluno
alunos_recuperados = json.loads(json_alunos, object_hook=dict_para_aluno)
print("\nLista de Alunos recuperada do JSON:")
print(alunos_recuperados)
