class Program {
    static List<int> lista1 = new List<int>();
    static List<int> lista2 = new List<int>();
 
    static void popularLista(List<int> lista, int tamanho) {
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            lista.Add(rand.Next(1, 200));
        }
    }
 
    static void ordenarBolha(List<int> lista)
    {
        int n = lista.Count;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (lista[j] > lista[j + 1])
                {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        // Console.WriteLine("Lista ordenada com o método Bolha:");
        // foreach (var item in lista)
        // {
        //     System.Console.Write(item + " ");
        // }
        // System.Console.WriteLine();
    }
 
 
    static void ordenarPente(List<int> lista)
    {
        int n = lista.Count;
        int distancia = n;
        bool houveTroca = true;
 
        while (distancia > 1 || houveTroca)
        {
            if (distancia > 1)
            {
                distancia = (int)(distancia / 1.3);
            }
            houveTroca = false;
 
            for (int i = 0; i + distancia < n; i++)
            {
                if (lista[i] > lista[i + distancia])
                {
                    int temp = lista[i];
                    lista[i] = lista[i + distancia];
                    lista[i + distancia] = temp;
                    houveTroca = true;
                }
            }
        }
        // Console.WriteLine("Lista ordenada com o método Pente:");
        // foreach (var item in lista)
        // {
        //     System.Console.Write(item + " ");
        // }
        // System.Console.WriteLine();
    }
 
    static void Main()
    {
        Thread t1 = new Thread(() => popularLista(lista1, 1000));
        Thread t2 = new Thread(() => popularLista(lista2, 1000));
        Thread t3 = new Thread(() => ordenarPente(lista1));
        Thread t4 = new Thread(() => ordenarBolha(lista2));
 
        t1.Start();
        t2.Start();
 
        t1.Join();
        t2.Join();
 
        t3.Start();
        t3.Join();
 
        t4.Start();
        t4.Join();
    }
}