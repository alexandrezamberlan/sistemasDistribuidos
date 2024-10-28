import socket
import struct
import time

# Configurações do multicast
MULTICAST_GROUP = '224.1.1.1'
PORT = 5004

# Cria um socket UDP
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 32)

while True:
    message = b'Hello, Multicast!'
    sock.sendto(message, (MULTICAST_GROUP, PORT))
    print(f'Sent: {message}')
    time.sleep(1)
