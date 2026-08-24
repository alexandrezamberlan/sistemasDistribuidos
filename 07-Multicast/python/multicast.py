import socket
import threading

# Classe para o comportamento de recepção de mensagens
class ThreadReceptora(threading.Thread):
    def __init__(self, multicast_socket):
        super().__init__()
        self.socket = multicast_socket

    def run(self):
        while True:
            try:
                # Bloqueio até receber a mensagem
                pacote, _ = self.socket.recvfrom(1024)
                # Transforma os bytes recebidos em string
                msg_recebida = pacote.decode('utf-8')
                # Exibe a mensagem na tela
                print(msg_recebida)
            except Exception as e:
                pass


# Classe para o comportamento de envio de mensagens
class ThreadEmissora(threading.Thread):
    def __init__(self, multicast_socket, ip_grupo, porta_grupo):
        super().__init__()
        self.socket = multicast_socket
        self.ip_grupo = ip_grupo
        self.porta_grupo = porta_grupo
    def run(self):
        while True:
            try:
                # Lê a mensagem do teclado
                msg = input('Digite a mensagem a ser enviada: ')
                # Envia a mensagem ao grupo multicast
                self.socket.sendto(msg.encode('utf-8'), (self.ip_grupo, self.porta_grupo))
            except Exception as e:
                pass


class EmissorReceptor:
    def __init__(self):
        self.ip_grupo = "239.1.2.3"
        self.porta_grupo = 3456

        # Configura o socket multicast
        self.socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
        self.socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

        # Vincula o socket à porta especificada
        self.socket.bind(('', self.porta_grupo))

        # Junta-se ao grupo multicast
        self.socket.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP,
                               socket.inet_aton(self.ip_grupo) + socket.inet_aton("0.0.0.0"))

        # Cria e inicia a thread receptora
        tR = ThreadReceptora(self.socket)
        tR.start()

        # Cria e inicia a thread emissora
        tE = ThreadEmissora(self.socket, self.ip_grupo, self.porta_grupo)
        tE.start()


if __name__ == "__main__":
    # Cria uma instância do EmissorReceptor para começar a comunicação
    er = EmissorReceptor()
