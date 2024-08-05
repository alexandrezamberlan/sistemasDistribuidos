using System;
using System.Collections.Generic;
using System.Threading;

List<int> lista1 = new List<int>();
List<int> lista2 = new List<int>();
List<int> lista3 = new List<int>();

// Thread t1 = new Thread(
//     () => Numeros.PopularAleatorio(lista1, 1000000, "lista1")
// );
// t1.Start();

// Thread t2 = new Thread(
//     () => Numeros.PopularAleatorio(lista2, 1000000, "lista2")
// );
// t2.Start();

// Thread t3 = new Thread(
//     () => Numeros.PopularAleatorio(lista3, 1000000, "lista3")
// );
// t3.Start();

// t1.Join();
// t2.Join();
// t3.Join();

//uso de thread com nome para variável
new Thread(
    () => Numeros.PopularAleatorio(lista1, 1000000, "lista1")
).Start();

new Thread(
    () => Numeros.PopularAleatorio(lista2, 1000000, "lista2")
).Start();

new Thread(
    () => Numeros.PopularAleatorio(lista3, 1000000, "lista3")
).Start();

Console.WriteLine("Programa encerrado2!");


