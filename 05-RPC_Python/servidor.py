import datetime, xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer

def hoje_eh():
	hoje = datetime.datetime.today()
	return xmlrpc.client.DateTime(hoje)

def gerar_email(nome):	
   try:
      nomes = nome.split()
      email = nomes[0] + '.' + nomes[-1] + '@ufn.edu.br'
      email = email.lower()
      return email
   except Exception as e:
      print(f'Erro: {e}')
      return None
   
def retirar_artigos(frase):
    # Artigos definidos
    artigos_definidos = ["o", "a", "os", "as"]

    # Artigos indefinidos
    artigos_indefinidos = ["um", "uma", "uns", "umas"]

    # Todos juntos (opcional)
    artigos = artigos_definidos + artigos_indefinidos

    # converter tudo para minúsculas e dividir em palavras
    palavras = frase.split()

    # remover os artigos
    palavras_sem_artigos = [p for p in palavras if p.lower() not in artigos]

    # palavras_sem_artigos = []
    # for p in palavras:
    #     if p.lower() not in artigos:
    #         palavras_sem_artigos.append(p)

    # juntar de volta em uma string
    frase_sem_artigos = " ".join(palavras_sem_artigos)

    return frase_sem_artigos
		
servidor = SimpleXMLRPCServer(("localhost", 1099))
print("Ouvindo a porta 1099...")
servidor.register_function(hoje_eh, "hoje_eh")
servidor.register_function(gerar_email, "gerar_email")
servidor.register_function(retirar_artigos, "retirar_artigos")
servidor.serve_forever()