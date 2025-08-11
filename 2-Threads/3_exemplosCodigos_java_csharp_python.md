# Códigos exemplos

# 1. **Java** – Servidor simples multithreaded usando `ExecutorService`

```java
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServidorMultithread {
    private static final int PORTA = 12345;
    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORTA);
        System.out.println("Servidor rodando na porta " + PORTA);

        while (true) {
            Socket clienteSocket = serverSocket.accept();
            pool.execute(new TratadorCliente(clienteSocket));
        }
    }
}

class TratadorCliente implements Runnable {
    private Socket socket;

    public TratadorCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String linha;
            while ((linha = in.readLine()) != null) {
                System.out.println("Recebido: " + linha);
                out.println("Eco: " + linha);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Esse servidor aceita conexões e cria uma thread para cada cliente, que fica lendo e respondendo linhas.

---

# 2. **Python** – Servidor multithread com `threading` (I/O-bound)

```python
import socket
import threading

def trata_cliente(conn, addr):
    print(f"Conexão de {addr}")
    with conn:
        while True:
            data = conn.recv(1024)
            if not data:
                break
            print(f"Recebido de {addr}: {data.decode()}")
            conn.sendall(b"Eco: " + data)

def servidor():
    HOST = '127.0.0.1'
    PORT = 12345

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()
        print(f"Servidor rodando na porta {PORT}")

        while True:
            conn, addr = s.accept()
            thread = threading.Thread(target=trata_cliente, args=(conn, addr))
            thread.start()

if __name__ == "__main__":
    servidor()
```

Esse servidor aceita múltiplas conexões, cada uma tratada por uma thread, ideal para operações de rede (I/O).

---

# 3. **C#** – Servidor TCP com Threads

```csharp
using System;
using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Threading;

class Servidor {
    public static void Main() {
        TcpListener listener = new TcpListener(IPAddress.Loopback, 12345);
        listener.Start();
        Console.WriteLine("Servidor rodando na porta 12345");

        while (true) {
            TcpClient client = listener.AcceptTcpClient();
            Thread thread = new Thread(() => TrataCliente(client));
            thread.Start();
        }
    }

    static void TrataCliente(TcpClient client) {
        NetworkStream stream = client.GetStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        try {
            while ((bytesRead = stream.Read(buffer, 0, buffer.Length)) != 0) {
                string data = Encoding.UTF8.GetString(buffer, 0, bytesRead);
                Console.WriteLine($"Recebido: {data}");
                byte[] response = Encoding.UTF8.GetBytes("Eco: " + data);
                stream.Write(response, 0, response.Length);
            }
        } catch (Exception e) {
            Console.WriteLine($"Erro: {e.Message}");
        } finally {
            client.Close();
        }
    }
}
```

Aqui também cada conexão aceita é tratada numa thread separada.

