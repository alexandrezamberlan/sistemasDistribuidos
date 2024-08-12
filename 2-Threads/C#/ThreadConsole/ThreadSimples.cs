using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ThreadConsole
{
    /// <summary>
    /// Classe que exemplifica o uso de Threads em C# de forma simples
    /// </summary>
    class ThreadSimples
    {
        /// <summary>
        /// Método estático que roda um for de 1 a 10 com sleep de 500
        /// </summary>
        private static void Executa()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Thread secundaria");
                Thread.Sleep(500);
            }
        }

        /// <summary>
        /// Método estático que cria uma thread e executa um for de 1 a 10 com sleep de 1000
        /// </summary>
        public static void Inicia()
        {
            Thread t = new Thread(Executa);
            t.Start();

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Thread principal");
                Thread.Sleep(1000);
            }
        }

    }
}
