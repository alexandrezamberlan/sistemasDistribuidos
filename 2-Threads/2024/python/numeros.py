import random

class Numeros:
    @staticmethod
    def popular_aleatorio(lista, quantidade, nome_lista):
        for _ in range(quantidade):
            lista.append(random.randint(0, 1000))
        print(f"Lista {nome_lista} populada com {quantidade} números aleatórios.")