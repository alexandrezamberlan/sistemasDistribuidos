# --- VIEW ---
class ContaView:
    @staticmethod
    def mostrar_alteracao(thread_nome, valor, saldo_atual):
        print(f"{thread_nome} alterou o saldo em {valor} e ficou {saldo_atual}")

    @staticmethod
    def mostrar_saldo_final(saldo):
        print(f"Saldo final após vendas de fichas: {saldo}")