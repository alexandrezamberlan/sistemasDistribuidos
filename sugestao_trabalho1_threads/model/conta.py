import threading

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
