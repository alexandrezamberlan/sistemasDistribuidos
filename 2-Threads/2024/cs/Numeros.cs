using System;
using System.Collections.Generic;
class Numeros
{
    public static void PopularAleatorio(List<int> lista, int quantidade, string nomeLista)
    {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(random.Next());
        }
        Console.WriteLine($"Lista {nomeLista} populada com {quantidade} números aleatórios.");
    }
}