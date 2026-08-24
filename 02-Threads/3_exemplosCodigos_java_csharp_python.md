# Códigos exemplos

# **Java** – Servidor simples multithreaded usando `ExecutorService`

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

# **Java** – Cliente java

```java
import java.io.*;
import java.net.*;

public class Cliente {
    private static final String HOST = "10.104.12.13";
    private static final int PORTA = 12345;

    public static void main(String[] args) {
        try {
            System.out.println("Tentando se conectar ao servidor...");
        
            // Conecta ao servidor no host e porta definidos
            Socket socket = new Socket(HOST, PORTA);
            
            // Fluxos para comunicação com o servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Fluxo para ler o que o usuário digita no terminal
            BufferedReader leitorTeclado = new BufferedReader(new InputStreamReader(System.getenv("STDOUT") != null ? System.in : System.in));
            System.out.println("Conectado com sucesso! Digite suas mensagens (ou 'sair' para encerrar):");
            String textoUsuario;

            // Lê as mensagens do terminal
            while ((textoUsuario = leitorTeclado.readLine()) != null) {
                if ("sair".equalsIgnoreCase(textoUsuario.trim())) {
                    break;
                }

                // Envia para o servidor
                out.println(textoUsuario);
                
                // Recebe e mostra a resposta do servidor
                String resposta = in.readLine();
                System.out.println("Servidor respondeu: " + resposta);
            }

        } catch (UnknownHostException e) {
            System.err.println("Não foi possível encontrar o host: " + HOST);
        } catch (IOException e) {
            System.err.println("Erro de I/O na conexão com o servidor: " + e.getMessage());
        }
        
        System.out.println("Conexão encerrada.");
    }
}

```

# **Python** – Servidor multithread com `threading` (I/O-bound)

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

# **Python** – Cliente

```python
import socket
import sys

def cliente():
    HOST = '10.104.12.5'
    PORT = 12345

    print("Tentando se conectar ao servidor...")

    try:
        # Cria o socket TCP/IP e conecta ao servidor
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.connect((HOST, PORT))
            print("Conectado com sucesso! Digite suas mensagens (ou 'sair' para encerrar):")

            while True:
                # Lê a mensagem do usuário no terminal
                texto_usuario = input("> ")

                # Verifica se o usuário quer encerrar a conexão
                if texto_usuario.strip().lower() == 'sair':
                    print("Encerrando conexão...")
                    break

                # Se a mensagem estiver vazia, ignora para não travar o recv
                if not texto_usuario:
                    continue

                # Envia os dados codificados em bytes (UTF-8)
                s.sendall(texto_usuario.encode('utf-8'))

                # Aguarda e recebe a resposta do servidor (buffer de 1024 bytes)
                dados_recebidos = s.recv(1024)
                
                if not dados_recebidos:
                    print("O servidor encerrou a conexão inesperadamente.")
                    break

                # Decodifica e exibe a resposta
                print(dados_recebidos.decode('utf-8'))

    except ConnectionRefusedError:
        print(f"Erro: Não foi possível conectar ao servidor em {HOST}:{PORT}. O servidor está rodando?")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")

if __name__ == "__main__":
    cliente()


```

# **C#** – Servidor TCP com Threads

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

