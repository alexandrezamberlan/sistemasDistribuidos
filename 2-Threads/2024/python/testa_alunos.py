from aluno import Aluno

lista_alunos = [Aluno()]

for _ in range(10):
    nome = input("Digite o nome do aluno: ")
    idade = int(input("Digite a idade do aluno: "))
    matricula = input("Digite a matrícula do aluno: ")
    aluno = Aluno(nome, idade, matricula)
    lista_alunos.append(aluno)

lista_alunos.sort()