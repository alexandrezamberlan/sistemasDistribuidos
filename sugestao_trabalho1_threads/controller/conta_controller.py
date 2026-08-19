import threading

from model.conta import Conta
from view.conta_view import ContaView
from model.operacao import Operacao

# --- CONTROLLER ---
class ContaController:
    def __init__(self, saldo_inicial):
        self.conta = Conta(saldo_inicial)
        self.interface = ContaView()

    def _ao_depositar(self, thread_nome, valor, novo_saldo):
        # Repassa o evento para a View
        self.interface.mostrar_alteracao(thread_nome, valor, novo_saldo)

    def executar_vendas(self):
        caixa1 = threading.Thread(
            target=Operacao.vender, 
            args=(self.conta, 5, 10, self._ao_depositar),
            name="Caixa1"
        )
        caixa2 = threading.Thread(
            target=Operacao.vender, 
            args=(self.conta, 10, 10, self._ao_depositar),
            name="Caixa2"
        )

        caixa1.start()
        caixa2.start()
        caixa1.join()
        caixa2.join()

        self.interface.mostrar_saldo_final(self.conta.consultar())