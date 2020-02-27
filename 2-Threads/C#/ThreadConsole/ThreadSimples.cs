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
            Console.WriteLine("Thread secundaria");
        }

        public static void Inicia()
        {
            Thread t = new Thread(Executa);
            t.Start();
            Console.WriteLine("Thread principal");
        }

    }
}
