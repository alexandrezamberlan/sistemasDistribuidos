import socket
import struct

# Configurações do multicast
MULTICAST_GROUP = '224.1.1.1'
PORT = 5004

# Cria um socket UDP
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
sock.bind(('', PORT))

# Adiciona o socket ao grupo multicast
mreq = struct.pack('4sl', socket.inet_aton(MULTICAST_GROUP), socket.INADDR_ANY)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)

while True:
    data, address = sock.recvfrom(1024)
    print(f'Received: {data} from {address}')
