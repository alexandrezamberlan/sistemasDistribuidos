package comunicacao;
/*
 * JGroups é uma API para comunicação confiável em grupo. 
Ele pode ser utilizado para a criação de grupos/clusters
 * em que as instancias podem enviar mensagens umas as outras.
 * As principais características são:
 * --> Criação e exclusão de clusters/grupos.
 * --> Entrada e saída de clusters
 * --> Detecção de falhas e notificação de entrada/saída/falha de membros de um grupo
 * --> Detecção e remoção de nodos falhos
 * --> Envio e recebimento de mensagens em grupo
 * --> Envio e recebimento de mensagens ponto-a-ponto
 * 
 */

import java.util.List;
import java.util.Scanner;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/*
 * Para poder receber mensagens enviadas a um grupo, a classe
 * deve estender ReceiverAdapter
 */
public class Exemplo extends ReceiverAdapter {

    JChannel channel;

    private void iniciar() throws Exception {

        System.setProperty("java.net.preferIPv4Stack", "true");//desabilita ipv6, para que só sejam aceitas conexões via ipv4
        /*
         * JGroups utiliza um JChannel como principal forma de conectar
         * a um cluster/grupo. É atraves dele que enviaremos e recebermos mensagens
         * bem como registrar os eventos callback quando acontecer alguma
         * mudança (por exemplo, entrada de um membro no grupo).
         * 
         * Neste caso, criamos uma instancia deste objeto, utilizando configurações default.
         */
        channel = new JChannel();
        /*
         * Definimos através do método setReceiver qual classe implementará
         * o método callback receive, que será chamado toda vez que alguém
         * enviar uma mensagem ao cluster/grupo. Neste caso, a própria classe
         * implementa o método receive mais abaixo.
         */
        channel.setReceiver(this);
        /*
         * O método connect faz com que este processo entre no cluster/grupo ChatCluster.
         * Não há a necessidade de se criar explicitamente um cluster, pois o método connect
         * cria o cluster caso este seja o primeiro membro a entrar nele.
         */
        channel.connect("ChatCluster");

        /*
         * A partir daqui o programa lê, continuamente, dados do teclado, e envia a mensagem ao grupo
         */
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                /*
                 * bloqueia aguardando uma leitura do teclado
                 */
                System.out.print("Digite algo: ");
                String linha = scanner.nextLine();

                /*
                 * caso tenha digitado quit ou exit, termina o laço, e consequentemente o método
                 */
                if (linha.equals("quit") || linha.equals("exit") || linha.equals("sair")) {
                    break;
                }

                /*
                 * cria uma instancia da classe Message do JGrupos com a mensagem.
                 * O primeiro parâmetro é o endereço do destinatário. Caso seja null, a mensagem é enviada para todos do grupo
                 * O segundo parâmetro é a mensagem enviada através de um buffer de bytes (convertida automaticamente)
                 */
                Message msg = new Message(null, linha);
                /*
                 * envia a mensagem montada acima ao grupo
                 */
                channel.send(msg);
                
            } catch (Exception e) {
            }
        }
        channel.close();

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
        System.out.println("\n"+msg.getSrc()+" disse: "+msg.getObject());
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

        System.out.println("---VISÃO DO GRUPO ATUALIZADA---");
        System.out.println("ID da view: "+view_atual.getViewId().getId());
        System.out.println("Coordenador: "+view_atual.getCreator());
        System.out.print("Membros: ");
        List<Address> membros = view_atual.getMembers();
        for (int i = 0; i < membros.size(); i++) {
            System.out.print(membros.get(i)+", ");
        }
        System.out.println();

    }

    /*
     * Este método callback é chamado toda vez que um membro é 
     * suspeito de ter falhado, porém ainda não foi excluído
     * do grupo. Esse método só é executado no coordenador do grupo.
     */
    
    @Override
    public void suspect(Address mbr) {

        System.out.println("PROCESSO SUSPEITO DE FALHA: " + mbr);
    }

    public static void main(String[] args) throws Exception {

        Exemplo ex = new Exemplo();
        ex.iniciar();

    }
}
