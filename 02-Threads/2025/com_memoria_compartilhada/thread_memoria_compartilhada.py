import threading
import time

class ListaCompartilhada:
    def __init__(self):
        self.numeros = []
        self.lock = threading.Lock()

    def adicionar_numeros(self, um_numero):
        with self.lock:
            self.numeros.append(um_numero)
            print(f"{threading.current_thread().name} adicionou: {um_numero}")

    def retornar_numeros(self):
        with self.lock:
            return list(self.numeros)

def operacao_trabalho(lista, quantidade_numeros):
    for i in range(1, quantidade_numeros):
        lista.adicionar_numeros(i)
        time.sleep(0.05)

if __name__ == "__main__":
    lista_compartilhada = ListaCompartilhada()

    t1 = threading.Thread(target=operacao_trabalho, args=(lista_compartilhada,5))
    t2 = threading.Thread(target=operacao_trabalho, args=(lista_compartilhada,5))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print("Lista final:", lista_compartilhada.retornar_numeros())