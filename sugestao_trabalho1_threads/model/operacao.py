import time

class Operacao:
    @staticmethod
    def vender(conta, total_fichas, valor_ficha, callback_deposito=None):
        for _ in range(1, total_fichas):
            novo_saldo, thread_nome = conta.depositar(valor_ficha)
            if callback_deposito:
                callback_deposito(thread_nome, valor_ficha, novo_saldo)
            time.sleep(0.05)