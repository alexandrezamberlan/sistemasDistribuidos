class Aluno:
    """
    Classe que representa um aluno.
    Atributos:
    - nome (str): O nome do aluno.
    - idade (int): A idade do aluno.
    - matricula (str): O número de matrícula do aluno.
    """
    
    def __init__(self, nome, idade, matricula):
        """
        Construtor da classe Aluno.
        Parâmetros:
        - nome (str): O nome do aluno.
        - idade (int): A idade do aluno.
        - matricula (str): O número de matrícula do aluno.
        """
        self.nome = nome
        self.idade = idade
        self.matricula = matricula
        
    def __str__(self):
        """
        Retorna uma representação em string do objeto Aluno.
        """
        return f"Nome: {self.nome}, Matrícula: {self.matricula}"
    
    def __lt__(self, other):
        """
        Método de comparação para ordenação.
        Compara dois objetos Aluno com base no atributo nome.
        Retorna True se o objeto atual for menor que o objeto other, caso contrário retorna False.
        """
        return self.nome < other.nome