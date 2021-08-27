using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ThreadConsole
{
    class ThreadSimples
    {
        private static void Executa()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Thread secundaria");
                Thread.Sleep(500);
            }
        }

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
