class Aluno:
    def __init__(self, nome, idade, matricula):
        self.nome = nome
        self.idade = idade
        self.matricula = matricula
 
    def __repr__(self):
        return f"Aluno(nome='{self.nome}', idade={self.idade}, matricula='{self.matricula}')"
 
