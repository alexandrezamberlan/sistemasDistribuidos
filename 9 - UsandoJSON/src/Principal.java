import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {        
        //convertendo um JSON para um objeto
        Gson gson1 = new Gson();
        String json1 = "{nome:\"Thiago\", idade:21, cidade:\"Santa Maria\"}";
        Aluno a = gson1.fromJson(json1, Aluno.class);
        System.out.println(a);
        
        
        //convertendo um objeto em JSON
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        Aluno b = new Aluno("Gustavo", 20,"Santa Maria");
        String json2 = gson2.toJson(b);
        System.out.println(json2);
        
        
        //trabalhando com listas - convertendo lista de objetos em JSON
        LinkedList<Aluno> listaAlunos = new LinkedList();
        String nome, cidade;
        int idade;
        for (int i = 0; i < 4; i++) {
            nome = JOptionPane.showInputDialog(null,"Nome");
            idade = Integer.parseInt(JOptionPane.showInputDialog(null,"Idade"));
            cidade = JOptionPane.showInputDialog(null,"Cidade");
            listaAlunos.add(new Aluno(nome,idade,cidade));
        }
        System.out.println(listaAlunos);
        String jsonLista = gson2.toJson(listaAlunos);
        System.out.println(jsonLista);
        
        //trabalhando com listas - convertendo JSON em lista de objetos        
        java.lang.reflect.Type tipoLista = new TypeToken<LinkedList<Aluno>>(){}.getType();
        LinkedList<Aluno> listaAlunos2 = gson2.fromJson(jsonLista, tipoLista);  
        System.out.println(listaAlunos2);
    }
}