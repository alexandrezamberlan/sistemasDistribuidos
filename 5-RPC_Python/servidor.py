import datetime, xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer

def hoje_eh():
	hoje = datetime.datetime.today()
	return xmlrpc.client.DateTime(hoje)

servidor = SimpleXMLRPCServer(("localhost", 8000))
print("Ouvindo a porta 8000...")
servidor.register_function(hoje_eh, "hoje")
servidor.serve_forever()