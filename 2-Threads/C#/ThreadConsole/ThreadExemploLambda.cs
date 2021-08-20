using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ThreadConsole
{
    class ThreadExemploLambda
    {

        public static void Inicia()
        {
            Thread t = new Thread( () => {
                Console.WriteLine("Thread secundaria");
            });
            t.Start();
            Console.WriteLine("Thread principal");
        }
    }
}
