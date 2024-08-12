import random

class Numeros:
    """Classe com métodos para manipulação de listas de números.
    """
    @staticmethod
    def popular_aleatorio(lista, quantidade, nome_lista):
        """Método para popular uma lista com números aleatórios.

        Args:
            lista (int): Lista a ser populada.
            quantidade (int): Quantidade de números a serem gerados.
            nome_lista (string): Nome da lista a ser populada para exibição.
        """
        for _ in range(quantidade):
            lista.append(random.randint(0, 1000))
        print(f"Lista {nome_lista} populada com {quantidade} números aleatórios.")