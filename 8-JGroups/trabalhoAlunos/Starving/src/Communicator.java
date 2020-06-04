
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Communicator extends ReceiverAdapter implements Runnable {
    JChannel channel;
    Bird player;
    Fruit fruit;
    String group;

    Communicator(Bird player, Fruit f, String group){
        this.player = player;
        this.fruit = f;
        this.group = group;
    }
    
    @Override
    public void run() {
        start();
        synchronized(channel){
            while (true) 
            {
                try {
                    Message msg = new Message(null, player.info);
                    //System.out.println("sending: " + player.info.name);
                    channel.send(msg);
                    Thread.sleep(3);
                    
                   if(fruit.info.caught){
                        fruit.info.generatePosition();
                        fruit.info.caught = false;
                        Message message = new Message(null, fruit.info);
                        try {
                            channel.send(message);
                            System.out.println(fruit.info.caught);
                        } catch (Exception ex) {
                            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void start(){
        System.setProperty("java.net.preferIPv4Stack", "true");//desabilita ipv6, para que só sejam aceitas conexões via ipv4
        try {
            channel = new JChannel();
            channel.setReceiver(this);
            channel.connect(group);
        } catch (Exception ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        }
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
       Info info = (Info) msg.getObject();
       if(info.type == Info.FRUIT){
           fruit.setInfo(info);
       }else{
           boolean in_list = false;
           for(Bird bird:Game.players){
               if(bird.info.name.equals(info.name)){
                   bird.setInfo(info);
                   in_list = true;
               }
           }
           if(!in_list)
           {
               Bird b = new Bird(info);
               Game.players.add(b);
           }
           in_list = false;
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

        System.out.println("ID da view: "+view_atual.getViewId().getId());
        System.out.println("Coordenador: "+view_atual.getCreator());
        System.out.print("Membros: ");
        List<Address> membros = view_atual.getMembers();
        fruit.info.generatePosition();
        Message message = new Message(null, fruit.info);
        try {
            channel.send(message);
            System.out.println(fruit.info.caught);
            
        } catch (Exception ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        fruit.info.caught = false;
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
}
