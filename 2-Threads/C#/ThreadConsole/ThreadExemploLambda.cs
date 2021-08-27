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
