import datetime
import time
import jwt
# 1. Definição das chaves de segurança
CHAVE_SECRETA = "minha_chave_super_secreta_123"
ALGORITMO = "HS256"

def criar_token_jwt(usuario_id, nome, regras):
    """Simula o momento do login, gerando um token para o usuário."""
    payload = {
        "sub": usuario_id,  # ID do sujeito (Subject)
        "name": nome,  # Nome do usuário
        "roles": regras,  # Permissões do usuário
        # Tempo de expiração (definido para 5 segundos para fins de teste)
        "exp": datetime.datetime.now(datetime.timezone.utc)
        + datetime.timedelta(seconds=5),
    }

    # Gera o token assinado com a nossa chave secreta
    token = jwt.encode(payload, CHAVE_SECRETA, algorithm=ALGORITMO)
    return token

def decodificar_e_validar_token(token):
    """Simula a validação do token ao acessar uma rota protegida."""
    try:
        # O PyJWT decodifica e valida a assinatura e a expiração automaticamente
        dados_decodificados = jwt.decode(
            token, CHAVE_SECRETA, algorithms=[ALGORITMO]
        )
        return dados_decodificados
    except jwt.ExpiredSignatureError:
        return "Erro: O token expirou!"
    except jwt.InvalidTokenError:
        return "Erro: Token inválido ou assinatura corrompida!"

# --- FLUXO DE EXECUÇÃO NO TERMINAL ---
if __name__ == "__main__":
    print("--- PASSO 1: Simulando o Login do Usuário ---")

    # Gerando o token para o usuário "Carlos"
    token_gerado = criar_token_jwt(
        usuario_id="12345", nome="Carlos Silva", regras=["admin", "editor"]
    )
    print(f"Token JWT Gerado:\n{token_gerado}\n")

    print("--- PASSO 2: Acessando rota protegida com Token Válido ---")
    resultado = decodificar_e_validar_token(token_gerado)
    print(f"Dados extraídos do Token: {resultado}\n")

    # processo de comunicação entre maquinas - ENVIO

    # Tratano o token recebido
    print("--- PASSO 3: Tentando usar um Token Modificado (Ataque) ---")
    token_alterado = token_gerado
    resultado_ataque = decodificar_e_validar_token(token_alterado)
    print(f"Resultado com token alterado: {resultado_ataque}\n")

    print("--- PASSO 4: Aguardando o Token Expirar (6 segundos) ---")
    time.sleep(6)
    resultado_expirado = decodificar_e_validar_token(token_gerado)
    print(f"Resultado após expiração: {resultado_expirado}")

