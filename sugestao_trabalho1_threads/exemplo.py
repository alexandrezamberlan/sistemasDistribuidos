import threading
import time

class Conta:
    """Classe com saldo_central com sincronizacao de acesso (depositar ou consultar)
    """
    def __init__(self, saldo):
        """Construtor

        Args:
            saldo (inteiro): um objeto conta pode iniciar com saldo definido
        """
        self.saldo_central = saldo
        self.lock = threading.Lock()
        
    def depositar(self, valor):
        """método que adiciona um valor ao saldo da conta

        Args:
            valor (inteiro): valor a ser adicionado ao saldo da conta

        Returns:
            string: quem depositou e o novo valor do saldo
        """
        with self.lock: #exclusao mutua 
            self.saldo_central += valor
            print(f"{threading.current_thread().name} alterou o saldo em {valor} e ficou {self.saldo_central}")
    
    def consultar(self):
        """método que retorna o saldo da conta

        Returns:
            inteiro: saldo temporário da conta
        """
        with self.lock: #exclusao mutua
            return self.saldo_central


class Operacao:        
    @staticmethod
    def vender(conta, total_fichas, valor_ficha):
        """método de classe que realiza vendas de fichas

        Args:
            conta (Conta): objeto conta
            total_fichas (int): quantidade de fichas a serem vendidas
            valor_ficha (int): valor unitario da ficha
        """
        for i in range(1, total_fichas):
            conta.depositar(valor_ficha)
            time.sleep(0.05)


if __name__ == "__main__":
    conta = Conta(0)

    caixa1 = threading.Thread(target=Operacao.vender, args=(conta, 5, 10))
    caixa2 = threading.Thread(target=Operacao.vender, args=(conta, 10, 10))

    caixa1.start()
    caixa2.start()

    caixa1.join()
    caixa2.join()

    print("Saldo final após vendas de fichas:", conta.consultar())        