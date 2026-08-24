package comunicacao;

import java.util.List;
import java.util.Scanner;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class ExemploDescomentado extends ReceiverAdapter {

    JChannel channel;

    private void iniciar() throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");//desabilita ipv6, para que só sejam aceitas conexões via ipv4
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String linha = scanner.nextLine();
                if (linha.equals("quit") || linha.equals("exit")) {
                    break;
                }
                Message msg = new Message(null, linha);
                channel.send(msg);
            } catch (Exception e) {
            }
        }
        channel.close();

    }

    @Override
    public void receive(Message msg) {

        System.out.println("\n"+msg.getSrc()+" disse: "+msg.getObject());

    }

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

    @Override
    public void suspect(Address mbr) {

        System.out.println("PROCESSO SUSPEITO DE FALHA: " + mbr);
    }

    public static void main(String[] args) throws Exception {

        new ExemploDescomentado().iniciar();

    }
}
