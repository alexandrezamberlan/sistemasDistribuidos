import threading
import random
import time
 
def popular_lista_intervalo(lista, tamanho_lista):
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
    print(lista)
    
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
 
    popula_lista1 = threading.Thread(target=popular_lista_intervalo,args=(lista1, 5))
    popula_lista2 = threading.Thread(target=popular_lista_intervalo,args=(lista2, 10))
 
    popula_lista1.start()
    popula_lista2.start()
    
    popula_lista1.join()
    popula_lista2.join()
 
    print(f"Listas populadas.")
    
    ordenar_pente(lista2)
    print(lista2)
 
    # ordena_pente = threading.Thread(target=ordenar_pente,args=(lista2))
    # ordena_bolha = threading.Thread(target=ordenar_bolha,args=(lista1))
 
    # ordena_pente.start()
    # ordena_bolha.start()
    
 
    