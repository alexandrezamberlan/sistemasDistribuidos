using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ThreadConsole
{
    /// <summary>
    /// Classe que exemplifica uso de threads com a função lambda
    /// </summary>
    class ThreadExemploLambda
    {

        /// <summary>
        /// Método que inicia duas threads sem nome e com lambda
        /// </summary>
        public static void Inicia()
        {
            new Thread( () => {
                for (int i = 0; i < 10; i++)
                {
                    Console.WriteLine("Thread secundaria");
                    Thread.Sleep(500);
                }
            }).Start();
            
            new Thread( () => {
                for (int i = 0; i < 10; i++)
                {
                    Console.WriteLine("Thread principal");
                    Thread.Sleep(1000);
                }
            }).Start();
        }
    }
}
