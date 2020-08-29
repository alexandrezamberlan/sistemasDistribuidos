
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class Comunicador extends ReceiverAdapter {

    JChannel channel;
    List<Address> membros;
    String frase;
    Message mensagem;
    JFrame_Jogo_Frutinha meuFrame;
    StringBuffer listaMembros;

    public void iniciar(JFrame_Jogo_Frutinha meuFrame) throws Exception {

        System.setProperty("java.net.preferIPv4Stack", "true");//desabilita ipv6, para que só sejam aceitas conexões via ipv4
        /*
         * JGroups utiliza um JChannel como principal forma de conectar
         * a um cluster/grupo. É atraves dele que enviaremos e recebermos mensagens
         * bem como registrar os eventos callback quando acontecer alguma
         * mudança (por exemplo, entrada de um membro no grupo).
         * 
         * Neste caso, criamos uma instancia deste objeto, utilizando configurações default.
         */
        this.channel = new JChannel();
        /*
         * Definimos através do método setReceiver qual classe implementará
         * o método callback receive, que será chamado toda vez que alguém
         * enviar uma mensagem ao cluster/grupo. Neste caso, a própria classe
         * implementa o método receive mais abaixo.
         */
        this.channel.setReceiver(this);
        /*
         * O método connect faz com que este processo entre no cluster/grupo ChatCluster.
         * Não há a necessidade de se criar explicitamente um cluster, pois o método connect
         * cria o cluster caso este seja o primeiro membro a entrar nele.
         */
        this.meuFrame = meuFrame;
        this.channel.setName(meuFrame.getjTextField_apelido().getText());
        this.channel.connect(meuFrame.getTitle());
        this.meuFrame.getjTextArea_listaMembros().setText(listaMembros.toString());
        this.desenhaJogadores();
    }

    public void enviar(String frase) {
        try {
            /*
            * cria uma instancia da classe Message do JGrupos com a mensagem.
            * O primeiro parâmetro é o endereço do destinatário. Caso seja null, a mensagem é enviada para todos do grupo
            * O segundo parâmetro é a mensagem enviada através de um buffer de bytes (convertida automaticamente)
             */
            this.mensagem = new Message(null, frase);
            /*
            * envia a mensagem montada acima ao grupo
             */
            this.channel.send(this.mensagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(meuFrame, "Algo ocorreu de errrado ao enviar sua mensagem!!");
        }
    }

    public void finalizar() {
        this.channel.close();
    }

    /*
     * O método abaixo é callback, e é chamado toda vez que alguem
     * envia uma mensagem ao processo/grupo/canal. Esta mensagem é recebida no parâmetro
     * Message msg. Nessa implementação, mostramos na tela o originador
     * da mensagem em msg.getSrc() e a mensagem propriamente dita em
     * msg.getObject
     */
    @Override
    public void receive(Message msg) {

        System.out.println(msg.getSrc()
                + " disse " + msg.getObject() + "\n");
    }

    /*
     * O método abaixo é callback, e é chamado toda vez que uma nova
     * instancia entra no grupo, ou se alguma instancia sai do grupo.
     * Ele recebe uma View como parâmetro. Este objeto possui informações
     * sobre todos os membros do grupo.
     * Na nossa implementação, quando damos um print no objeto new_view
     * ele mostra, respectivamente:
     *      [Criador do grupo | ID da View]  [Membros do grupo]
     * 
     * Cada View possui uma ID, que a identifica. 
     * O ID da View é um Relógio de Lamport que marca a ocorrência de eventos.
     */
    @Override
    public void viewAccepted(View view_atual) {
        this.membros = view_atual.getMembers();
        this.listaMembros = new StringBuffer();

        for (int i = 0; i < membros.size(); i++) {
            this.listaMembros.append(membros.get(i) + "\n");
        }
        this.meuFrame.getjTextArea_listaMembros().setText(listaMembros.toString());
        this.desenhaJogadores();
    }

    /*
     * Este método callback é chamado toda vez que um membro é 
     * suspeito de ter falhado, porém ainda não foi excluído
     * do grupo. Esse método só é executado no coordenador do grupo.
     */
    @Override
    public void suspect(Address mbr) {

        JOptionPane.showMessageDialog(meuFrame, "PROCESSO SUSPEITO DE FALHA: " + mbr);
    }

    private void desenhaJogadores() {
        Componente c = new Componente();
        System.out.println("Relacao atualizada.....");
        for (int i = 0; i < this.meuFrame.listaJogadores.size(); i++) {
            c = this.meuFrame.listaJogadores.get(i);
            this.meuFrame.getjPanel_area().add(c.botao);
            c.botao.setVisible(true);
            c.botao.setBounds(c.x, c.y, c.largura, c.altura);
            System.out.println(c.toString());
        }
    }
}
