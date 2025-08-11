import threading
import random
import time
 
def popular_lista_intervalo(lista, inicio, fim, tamanho_lista):
    tamanho_intervalo = fim - inicio + 1
    if tamanho_intervalo <= tamanho_lista:
        lista.extend(range(inicio, fim + 1))
    else:
        lista.extend(random.sample(range(inicio, fim + 1), tamanho_lista))
 
def ordenar_bolha(lista):
    houve_troca = True
    while houve_troca:
        houve_troca = False
        for i in range(len(lista) - 1):
            if lista[i] > lista[i + 1]:
                lista[i], lista[i + 1] = lista[i + 1], lista[i]
                houve_troca = True
 
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
 
def sort_timing(lista, sort, name, resultados):
    inicio = time.time()
    sort(lista)
    fim = time.time()
    resultados[name] = fim - inicio
 
if __name__ == "__main__":
    lista1 = []
    lista2 = []
    tamanho_lista = 2000
 
    t1 = threading.Thread(target=popular_lista_intervalo,args=(lista1, 3001, 10000, tamanho_lista))
    t2 = threading.Thread(target=popular_lista_intervalo,args=(lista2, 0, 3000, tamanho_lista))
 
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    print(f"Listas populadas.")
 
    resultados = {}
 
    t3 = threading.Thread(target=sort_timing,args=(lista1, ordenar_pente, 'pente', resultados))
    t4 = threading.Thread(target=sort_timing,args=(lista2, ordenar_bolha, 'bolha', resultados))
 
    t3.start()
    t4.start()
    # t3.join()
    t4.join()
 
    tempo_pente = resultados['pente']
    tempo_bolha = resultados['bolha']
    print(f"Tempo ordenação Pente: {tempo_pente:.3f} s")
    print(f"Tempo ordenação Bolha:  {tempo_bolha:.3f} s")
 
    if tempo_pente < tempo_bolha:
        print(">> Ordenação por Pente terminou primeiro!")
    elif tempo_bolha < tempo_pente:
        print(">> Ordenação por Bolha terminou primeiro!")
    else:
        print(">> Ambos terminaram exatamente ao mesmo tempo!")