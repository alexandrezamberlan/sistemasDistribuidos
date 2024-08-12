using System;
using System.Threading;

//Feito por Giovani Luigi
namespace ThreadConsole
{
    /// <summary>
    /// Classe que gerencia o programa principal
    /// </summary>
    class Program
    {
        /// <summary>
        /// Método estático responsável por iniciar o programa principal
        /// </summary>
        /// <param name="args">lista de argumentos para o console</param>
        static void Main(string[] args)
        {
            //ThreadSimples.Inicia();

            //hreadExemploLambda.Inicia();

            //ThreadComSincronismo.Inicia();

            ThreadComParametro.Inicia();
        }
    }
}
