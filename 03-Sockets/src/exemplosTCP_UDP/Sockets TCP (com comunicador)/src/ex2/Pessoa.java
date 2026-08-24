import java.io.Serializable;

public class Pessoa implements Serializable {

    private int idade;
    private String nome;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idade;
        hash = 47 * hash + (this.nome != null ? this.nome.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        return (this.nome == null) ? (other.nome == null) : this.nome.equals(other.nome);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idade=" + idade + ", nome=" + nome + '}';
    }
    
    
}
