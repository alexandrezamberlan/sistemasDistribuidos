import json
import pandas as pd
from aluno import Aluno

class Dicionario:
    @staticmethod
    def aluno_para_dict(aluno):
        """Converte um objeto Aluno para dicionário."""
        return {
            "nome": aluno.nome,
            "idade": aluno.idade,
            "matricula": aluno.matricula
        }
    @staticmethod
    def dict_para_aluno(dicionario):
        """Converte um dicionário para um objeto Aluno."""
        return Aluno(dicionario["nome"], dicionario["idade"], dicionario["matricula"])

    @staticmethod
    def dict_para_json(dicionario, nome_arquivo):
        """Converte um dicionário e o salva em um arquivo .json."""
        with open(nome_arquivo, "w", encoding="utf-8") as arquivo:
            json.dump(dicionario, arquivo, indent=4, ensure_ascii=False)

    @staticmethod
    def json_para_dict(nome_arquivo):
        """Converte um arquivo .json em uma lista de dicionarios"""
        try:
            with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
                return json.load(arquivo)
        except FileNotFoundError:
            print(f"Erro: O arquivo {nome_arquivo} não foi encontrado.")
            return [] # Retorna uma lista vazia caso o arquivo não exista

    @staticmethod
    def json_csv(nome_arquivo_json, nome_arquivo_csv):
        # Lê o arquivo JSON diretamente para um DataFrame e salva em CSV
        df = pd.read_json(nome_arquivo_json)
        df.to_csv(nome_arquivo_csv, index=False, encoding="utf-8")


    @staticmethod
    def csv_json(nome_arquivo_csv, nome_arquivo_json):
        
        # Lê o arquivo CSV e salva em JSON formatado (como lista de dicionários)
        df = pd.read_csv(nome_arquivo_csv)
        df.to_json(nome_arquivo_json, orient="records", indent=4, force_ascii=False)