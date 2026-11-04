from dicionario import Dicionario

#alunos = []
# alunos.append(Aluno("Maria", 20, "A123"))
# alunos.append(Aluno("João", 22, "B456"))
# alunos.append(Aluno("Ana", 21, "C789"))
 
# # Serializando a lista de objetos Aluno para JSON
# json_alunos = json.dumps(alunos, default=Dicionario.aluno_para_dict, indent=4)
# print("Lista de Alunos em JSON:")
# print(json_alunos)

# objeto_python = json.loads(json_alunos)
# Dicionario.dict_para_json(objeto_python, "arquivo.json") # Funciona corretamente



#json_alunos = Dicionario.json_para_dict("arquivo.json")

# Agora json_alunos contém a lista de dicionários pronta para uso
#print(json_alunos)

 
# Desserializando o JSON de volta para uma lista de objetos Aluno
#alunos_recuperados = json.loads(json_alunos, object_hook=Dicionario.dict_para_aluno)
#print("\nLista de Alunos recuperada do JSON:")
#print(alunos_recuperados)


Dicionario.csv_json("arquivo.csv", "outro_json.json")