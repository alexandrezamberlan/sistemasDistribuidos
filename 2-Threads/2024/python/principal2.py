import threading
from numeros import Numeros

def main():
    lista1 = []
    lista2 = []
    lista3 = []
    threading.Thread(target=lambda: Numeros.popular_aleatorio(lista1, 1000000, "lista1")).start()
     
    threading.Thread(target=lambda: Numeros.popular_aleatorio(lista2, 1000000, "lista2")).start()
    
    threading.Thread(target=lambda: Numeros.popular_aleatorio(lista3, 1000000, "lista3")).start()
    
    print("Programa principal finalizado")

if __name__ == "__main__":
    main()
