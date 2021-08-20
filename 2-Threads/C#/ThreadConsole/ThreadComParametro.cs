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

            Console.WriteLine("Parametro recebido=" + p.valor);

        }

        public static void Inicia()
        {
            Thread t = new Thread(Executa);            
            t.Start(new Parametros(10));
        }

    }
}
