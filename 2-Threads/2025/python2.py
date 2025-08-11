import threading
import random
import time

class ExemploThreadSemCompartilharMemoria(threading.Thread):
    def __init__(self, name):
        super().__init__(name=name)
    
    def run(self):
        for i in range(10):
            print(f"{i} {self.name}")
            time.sleep(random.uniform(0, 1))  # Atraso aleatório entre 0 e 1 segundo
        print(f"DONE! {self.name}")

if __name__ == "__main__":
    # Opção com nome de variável
    t1 = ExemploThreadSemCompartilharMemoria("Gustavo")
    t1.start()

    t2 = ExemploThreadSemCompartilharMemoria("Jose")
    t2.start()

    # Opção sem nome
    ExemploThreadSemCompartilharMemoria("Zeni").start()
    ExemploThreadSemCompartilharMemoria("Regis").start()

    # Opção sem nome e aninhada
    threading.Thread(target=lambda: [
        print(f"{i} {threading.current_thread().name}") or time.sleep(random.uniform(0, 1)) 
        for i in range(10)
    ] + [print(f"DONE! {threading.current_thread().name}")]).start()
