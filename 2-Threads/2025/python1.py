import threading
import random
import time
 
def popular_lista(lista, tamanho_lista):
    for _ in range(tamanho_lista):
        lista.append( random.randint(1000,10000) )
    
 
def ordenar_bolha(lista):
    houve_troca = True
    while houve_troca:
        houve_troca = False
        for i in range(len(lista) - 1):
            if lista[i] > lista[i + 1]:
                lista[i], lista[i + 1] = lista[i + 1], lista[i]
                houve_troca = True
                
    print('Bolha finalizado...')
 
def ordenar_pente(lista):    
    n = len(lista)
    distancia = n
    fator = 1.3
    houve_troca = True
 
    while distancia > 1 or houve_troca:
        distancia = int(distancia / fator)
        if distancia < 1:
            distancia = 1
        houve_troca = False
 
        for i in range(n - distancia):
            if lista[i] > lista[i + distancia]:
                lista[i], lista[i + distancia] = lista[i + distancia], lista[i]
                houve_troca = True
    
    print('Pente finalizado...')
 
 
if __name__ == "__main__":
    lista1 = []
    lista2 = []
    lista3 = []
 
    thread_popula_lista1 = threading.Thread(target=popular_lista,args=(lista1, 5000))
    thread_popula_lista2 = threading.Thread(target=popular_lista,args=(lista2, 1000))
    thread_popula_lista3 = threading.Thread(target=popular_lista,args=(lista3, 500))
 
    thread_popula_lista1.start()
    thread_popula_lista2.start()
    thread_popula_lista3.start()
    
    thread_popula_lista1.join()
    thread_popula_lista2.join()
    thread_popula_lista3.join()
 
    thread_ordena_pente = threading.Thread(target=ordenar_pente,args=(lista1,))
    thread_ordena_bolha3 = threading.Thread(target=ordenar_bolha,args=(lista3,))
    thread_ordena_bolha2 = threading.Thread(target=ordenar_bolha,args=(lista2,))
 
    thread_ordena_pente.start()
    thread_ordena_bolha2.start()
    thread_ordena_bolha3.start()
    
 
    