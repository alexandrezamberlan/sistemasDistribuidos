from controller.conta_controller import ContaController

# --- EXECUÇÃO ---
if __name__ == "__main__":
    app = ContaController(0)
    app.executar_vendas()
    