import xmlrpc.client, datetime

servidor = xmlrpc.client.ServerProxy("http://localhost:8000/")

hoje = servidor.hoje()

# convert the ISO8601 string to a datetime object
data_hora_convertida = datetime.datetime.strptime(hoje.value, "%Y%m%dT%H:%M:%S")
print("Hoje é: %s" % data_hora_convertida.strftime("%d.%m.%Y, %H:%M:%S"))