# Desafio da Telefonia

A partir do sistema local, desenvolvido em PESQUISA E ORDENAÇÃO, refatore o sistema para que funcione em arquitetura cliente-servidor. O servidor abre a base de sessões de telefonia e fornece ao cliente os dados de sua sessão, a partir do número de celular informado pelo cliente.

##

Código base em https://github.com/alexandrezamberlan/pesquisa_ordenacao/tree/master/__aulaPratica/Telefonia

## Observações

1) Cabe ao programador decidir qual abordagem Cliente-Servidor vai utilizar
2) O servidor deve abrir a base de sessões (https://github.com/alexandrezamberlan/pesquisa_ordenacao/blob/master/05-hash/problemaSessaoTelefonia/telephony_sessions.txt); adicionar em um HashMap.

### O código da classe Sessao:
```java
package model;
import java.util.Objects;

public class Sessao {
    String numeroCelular;
    String dadosSessao;

    public Sessao(String numeroCelular, String dadosSessao) {
        this.numeroCelular = numeroCelular;
        this.dadosSessao = dadosSessao;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getDadosSessao() {
        return dadosSessao;
    }

    public void setDadosSessao(String dadosSessao) {
        this.dadosSessao = dadosSessao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.numeroCelular);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        return Objects.equals(this.numeroCelular, other.numeroCelular);
    }

    @Override
    public String toString() {
        return "Sessao{" + "numeroCelular=" + numeroCelular + ", dadosSessao=" + dadosSessao + '}';
    }
}
```

### O código da classe TabelaHash

```java
package model;

import java.util.HashMap;

public class TabelaHash {
    public HashMap<String,Sessao> sessoes;

    public TabelaHash() {
        sessoes = new HashMap<>();
    }
}
```
