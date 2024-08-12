using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ThreadConsole
{
    class ThreadComParametro
    {

        class Parametros{
           public int valor;
           public Parametros(int valor){
                this.valor = valor;
           }
        }

        private static void Executa(Object obj){

            Parametros p = (Parametros)obj;

            for (int i = 0; i < p.valor; i++)
            {
                Console.WriteLine(i + " " + Thread.CurrentThread.Name);
                Thread.Sleep(500);
            }
        }

        public static void Inicia()
        {
            Thread t = new Thread(Executa);            
            t.Name = "t1";
            t.Start(new Parametros(10));

            Thread t2 = new Thread(Executa);
            t2.Name = "t2";
            t2.Start(new Parametros(17));
        }

    }
}
