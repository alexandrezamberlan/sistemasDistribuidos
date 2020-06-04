
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import view.Main;

public class Comunicador extends ReceiverAdapter {

    Main chat;
    JChannel channel;
    
    public Comunicador(Main chat) {
        this.chat = chat;
    }

    public boolean iniciarConexao() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        try {
            channel = new JChannel();
            channel.setReceiver(this);
            channel.setName(this.chat.getjTextUsuario().getText());
            channel.connect("Chat JGroups");
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de aviso", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void enviar(String mensagem) {
        Message msg = new Message(null, mensagem);
        try {
            channel.send(msg);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void enviarMP(String destinatario, String mensagem) {
        View view = channel.getView();
        List<Address> listaUsuarios = view.getMembers();
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Address usuario = listaUsuarios.get(i);
            if (usuario.toString().equals(destinatario)) {
                try {
                    Message msg = new Message(usuario, mensagem);
                    channel.send(msg);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de aviso", JOptionPane.ERROR_MESSAGE);
                }                
            }
        }
    }

    @Override
    public void receive(Message msg) {
        String msgChat = msg.getSrc().toString();
        if (msg.getDest() != null) {
            msgChat += " enviou uma MP: " + msg.getObject() + "\n";
        }
        else {
            msgChat += msg.getObject() + "\n";
        }
        this.chat.getjTextAreaChat().append(msgChat);
        this.chat.getVertical().setValue(this.chat.getVertical().getMaximum());
    }

    @Override
    public void viewAccepted(View view_atual) {
        String aux;
        List<Address> listaUsuarios = view_atual.getMembers();

        this.chat.getjComboUsuarios().removeAllItems();
        this.chat.getjComboUsuarios().addItem("Chat geral");
        this.chat.getjTextidView().setText(view_atual.getViewId().getId() + "");
        
        aux = view_atual.getCreator() + " ♕\n";
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Address usuario = listaUsuarios.get(i);
            if (!usuario.equals(view_atual.getCreator())) {
                aux += usuario + "\n";
            }
            this.chat.getjComboUsuarios().addItem(usuario.toString());
        }
        
        this.chat.getjTextAreaUsuarios().setText(aux);
    }
    
    public JChannel getChannel() {
        return channel;
    } 
}
