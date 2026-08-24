using System;
using System.Text;
using System.IO;
using System.Net;
using System.Net.Sockets;

namespace C_
{
    class MinhaSocket
    {
        // This method requests the home page content for the specified server.
        private static string SocketSendReceive(string server, int port)
        {
            // Create a socket connection with the specified server and port.
            using(Socket s = ConnectSocket(server, port)) {
                if (s == null)
                    return "Connection failed";
                return "Connection ok!";
            }

            //     // Send request to the server.
            //     s.Send(bytesSent, bytesSent.Length, 0);

            //     // Receive the server home page content.
            //     int bytes = 0;
            //     page = "Default HTML page on " + server + ":\r\n";

            //     // The following will block until the page is transmitted.
            //     do {
            //         bytes = s.Receive(bytesReceived, bytesReceived.Length, 0);
            //         page = page + Encoding.ASCII.GetString(bytesReceived, 0, bytes);
            //     }
            //     while (bytes > 0);
            // }
            // return page;
        }
    }
    class Program
    {
        public static void Main(string[] args)
        {
            string host;
            int port = 12345;

            if (args.Length == 0)
                // If no server name is passed as argument to this program,
                // use the current host name as the default.
                host = Dns.GetHostName();
            else host = args[0];

            string result = MinhaSocket.SocketSendReceive(host, port);
            Console.WriteLine(result);
        }
    }
}
