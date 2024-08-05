import threading
from numeros import Numeros

def main():
    lista1 = []
    lista2 = []
    lista3 = []
    t1 = threading.Thread(target=lambda: Numeros.popular_aleatorio(lista1, 1000000, "lista1"))
    t1.start()
     
    t2 = threading.Thread(target=lambda: Numeros.popular_aleatorio(lista2, 1000000, "lista2"))
    t2.start()
    
    t3 = threading.Thread(target=lambda: Numeros.popular_aleatorio(lista3, 1000000, "lista3"))
    t3.start()
    
    t1.join()
    t2.join()
    t3.join()

    print("Programa principal finalizado")

if __name__ == "__main__":
    main()
