
public class Aluno {
    public String nome;
    public int idade;
    public String cidade;

    public Aluno(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", idade=" + idade + ", cidade=" + cidade + '}';
    }    
}
