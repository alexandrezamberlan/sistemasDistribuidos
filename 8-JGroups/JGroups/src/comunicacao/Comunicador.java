package comunicacao;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class Comunicador extends ReceiverAdapter {

    JChannel channel;
    List<Address> listaMembros;
    String frase;
    Message mensagem;
    JFrame_jogoDaVelhaJGroups meuFrame;
    StringBuffer membrosStringBuffer;
    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    JTextField jTextField6;
    JTextField jTextField7;
    JTextField jTextField8;
    JTextField jTextField9;
    

    public void iniciar(JFrame_jogoDaVelhaJGroups meuFrame) throws Exception {

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
        jTextField1 = meuFrame.jTextField1;
        jTextField1 = meuFrame.jTextField2;
        jTextField1 = meuFrame.jTextField3;
        jTextField1 = meuFrame.jTextField4;
        jTextField1 = meuFrame.jTextField5;
        jTextField1 = meuFrame.jTextField6;
        jTextField1 = meuFrame.jTextField7;
        jTextField1 = meuFrame.jTextField8;
        jTextField1 = meuFrame.jTextField9;
        
        
        this.channel.setName(meuFrame.getjTextField_apelido().getText());
        this.channel.connect(meuFrame.getTitle());
        this.meuFrame.getjTextArea_listaMembros().setText(membrosStringBuffer.toString());
    }

    public void enviarJogada(JFrame_jogoDaVelhaJGroups meuFrame) {
        try {
            StringBuilder jogadas = new StringBuilder(meuFrame.jTextField1.getText() + meuFrame.jTextField2.getText() + meuFrame.jTextField3.getText() + 
                    meuFrame.jTextField4.getText() + meuFrame.jTextField5.getText() + meuFrame.jTextField6.getText() +
                    meuFrame.jTextField7.getText() + meuFrame.jTextField8.getText() + meuFrame.jTextField9.getText());
            System.out.println("Esta foi uma jogada: " + jogadas);
            this.mensagem = new Message(null, jogadas.toString());
            this.channel.send(this.mensagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(meuFrame, "Algo ocorreu de errrado ao enviar sua jogada!!");
        }

    }

    public void enviar(String frase, String participante) {
        try {
            if (participante == null) {
                /*
                 * cria uma instancia da classe Message do JGrupos com a mensagem.
                 * O primeiro parâmetro é o endereço do destinatário. Caso seja null, a mensagem é enviada para todos do grupo
                 * O segundo parâmetro é a mensagem enviada através de um buffer de bytes (convertida automaticamente)
                 */
                this.mensagem = new Message(null, frase);
            } else {
                for (int i = 0; i < this.listaMembros.size(); i++) {
                    if (participante.equals(listaMembros.get(i).toString())) {
                        System.out.println("Achouuuu");
                        this.mensagem = new Message(listaMembros.get(i), frase);
                        break;
                    }
                }
            }
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
        Date dt = new Date();
        System.out.println("Mensagem chegando de um usuario: " + msg.getObject().toString());
        if (msg.getObject().toString().contains("#")) {
            String msgTratada = msg.getObject().toString().replace("#", "");
            
            this.meuFrame.getjTextArea_mensagensGerais().append("[" + dt.toString() + "] " + msg.getSrc()
                    + " disse: " + msgTratada + "\n");
        } else {
            this.meuFrame.getjTextArea_mensagensGerais().append("[" + dt.toString() + "] " + msg.getSrc()
                    + " fez uma jogada\n");
            
            this.meuFrame.jTextField1.setText(""+msg.getObject().toString().charAt(0));
            this.meuFrame.jTextField2.setText(""+msg.getObject().toString().charAt(1));
            this.meuFrame.jTextField3.setText(""+msg.getObject().toString().charAt(2));
            this.meuFrame.jTextField4.setText(""+msg.getObject().toString().charAt(3));
            this.meuFrame.jTextField5.setText(""+msg.getObject().toString().charAt(4));
            this.meuFrame.jTextField6.setText(""+msg.getObject().toString().charAt(5));
            this.meuFrame.jTextField7.setText(""+msg.getObject().toString().charAt(6));
            this.meuFrame.jTextField8.setText(""+msg.getObject().toString().charAt(7));
            this.meuFrame.jTextField9.setText(""+msg.getObject().toString().charAt(8));
        }

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
        this.listaMembros = view_atual.getMembers();
        //System.out.println(listaMembros);
        this.membrosStringBuffer = new StringBuffer();
        this.meuFrame.getjTextArea_listaMembros().setText("");
        for (int i = 0; i < listaMembros.size(); i++) {
            membrosStringBuffer.append(listaMembros.get(i) + "\n");
        }

        this.meuFrame.getjTextArea_listaMembros().setText(membrosStringBuffer.toString());
        
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

}
