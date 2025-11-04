/**
 * pacote que coordena o frame do chat no que se  refere a interface gráfica e comunicação com o usuário
 */
package chatMulticast;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.ComunicadorUDP;

/**
 *
 * @author Turma Sistemas Distribuídos 2019-2
 */
public class JFrame_chatMulticast extends javax.swing.JFrame {

    public JFrame_chatMulticast() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Mensagens = new javax.swing.JTextArea();
        jTextField_textoDeEnvio = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jLabel_Porta = new javax.swing.JLabel();
        jTextField_Porta = new javax.swing.JTextField();
        jLabel_ServidorIP = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jTextField_GrupoIP = new javax.swing.JTextField();
        jLabel_Nick = new javax.swing.JLabel();
        jTextField_Nick = new javax.swing.JTextField();
        jButton_Conectar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_usuariosOnline = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea_Mensagens.setEditable(false);
        jTextArea_Mensagens.setColumns(20);
        jTextArea_Mensagens.setRows(5);
        jTextArea_Mensagens.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea_Mensagens);

        jTextField_textoDeEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_textoDeEnvioKeyPressed(evt);
            }
        });

        jButton_Enviar.setText("Enviar");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jLabel_Porta.setText("Porta");

        jTextField_Porta.setText("3456");

        jLabel_ServidorIP.setText("Grupo IP:");

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jTextField_GrupoIP.setText("239.1.2.3");

        jLabel_Nick.setText("Nick:");

        jButton_Conectar.setText("Conectar");
        jButton_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConectarActionPerformed(evt);
            }
        });

        jList_usuariosOnline.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList_usuariosOnline);

        javax.swing.GroupLayout jPanel_ChatLayout = new javax.swing.GroupLayout(jPanel_Chat);
        jPanel_Chat.setLayout(jPanel_ChatLayout);
        jPanel_ChatLayout.setHorizontalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel_ServidorIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Porta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Nick)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_Conectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton_Sair)
                .addGap(2, 2, 2))
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addComponent(jTextField_textoDeEnvio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Enviar))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );
        jPanel_ChatLayout.setVerticalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_textoDeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ServidorIP)
                    .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Porta)
                    .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nick)
                    .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Conectar)
                    .addComponent(jButton_Sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_Chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * classe interna que garante que o processo de ler/ouvir mensagens seja executado concomitantemente
     */
    class ThreadReceptora extends Thread {
        @Override
        public void run() {
            JFrame meuFrame = JFrame_chatMulticast.this;
            while (true) {
                try {
                    DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);
                    String msgRecebida = new String(pacote.getData(), 0, pacote.getLength());
                    lista.add(msgRecebida);
                    Iterator i = lista.iterator();
                    jTextArea_Mensagens.setText("");
                    while (i.hasNext()) {
                        jTextArea_Mensagens.append(i.next().toString() + "\n");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(meuFrame, e.getMessage());
                }
            }
        }
    }

    /**
     * método privado que avisa que um computador saiu do grupo e encerra a conexão
     * @throws IOException
     * @throws NumberFormatException
     * @throws NullPointerException 
     */
    private void sairDoSistema() throws IOException, NumberFormatException, NullPointerException {
        try {
            String msg = jTextField_Nick.getText() + " saiu da sala";
            DatagramPacket pacote = ComunicadorUDP.montaMensagem(msg, jTextField_GrupoIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            socket.send(pacote);

        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                JOptionPane.showMessageDialog(this, "Você está saindo sem ter se conectado");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } finally {
            System.exit(0);
        }
    }

    /**
     * método privado que realiza a conexão do computador em um grupo multicast,
     * tendo como referência endereço virtual do grupo e a porta do socket. O processo de escuta/leitura
     * é circundado por thread de leitura
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConectarActionPerformed
        jTextField_GrupoIP.getText();
        jTextField_Porta.getText();
        try {
            if (jTextField_Nick.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha seu nick");
            } else {
                //DEFINO O IP DO GRUPO
                grupo = InetAddress.getByName(jTextField_GrupoIP.getText());
                
                //CRIO O SOCKET MULTICAST COM A PORTA ESPECIFICADA
                socket = new MulticastSocket(Integer.parseInt(jTextField_Porta.getText()));
                
                //ENTRA NO GRUPO MULTICAST PARA RECEBER AS MENSAGENS
                socket.joinGroup(grupo);
                
                //CRIO A THREAD PARA RECEBER AS MENSAGENS
                ThreadReceptora tR = new ThreadReceptora();
                tR.start();
                
                JOptionPane.showMessageDialog(this, "Conectado com sucesso!");
                jButton_Conectar.setEnabled(false);
                jTextField_Nick.setEnabled(false);
                jTextField_GrupoIP.setEnabled(false);
                jTextField_Porta.setEnabled(false);

                String msg = jTextField_Nick.getText() + " entrou na sala";
                DatagramPacket pacote = ComunicadorUDP.montaMensagem(msg, jTextField_GrupoIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
                socket.send(pacote);
                jTextField_textoDeEnvio.requestFocus();
            }
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton_ConectarActionPerformed
   
    /**
     * método privado que captura a mensagem escrita na caixa de texto mais o apelido da caixa de texto nick
     * monta a mensagem e a envia ao grupo
     * @throws IOException
     * @throws NumberFormatException
     * @throws NullPointerException 
     */
    private void enviarMsg() throws IOException, NumberFormatException, NullPointerException {
        try {
            String msg = jTextField_Nick.getText() + ": " + jTextField_textoDeEnvio.getText();
            DatagramPacket pacote = ComunicadorUDP.montaMensagem(msg, jTextField_GrupoIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            socket.send(pacote);
            jTextField_textoDeEnvio.setText("");
        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                JOptionPane.showMessageDialog(this, "Você precisa conectar antes de enviar msgs");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    /**
     * método privado que trata o envio de mensagens escritas na caixa de texto de mensagens 
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        try {
            this.enviarMsg();
            jTextField_textoDeEnvio.requestFocus();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    /**
     * método privado que trata o evento do botão sair, ou seja, finaliza o sistema
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        try {
            this.sairDoSistema();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_SairActionPerformed

    /**
     * método privado que trata o pressionamento das teclas Enter ou Esc quando o foco estiver na caixa de envio de texto
     * @param evt contém o evento recebido pelo tratador
     */
    private void jTextField_textoDeEnvioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_textoDeEnvioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.enviarMsg();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            try {
                this.sairDoSistema();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }
    }//GEN-LAST:event_jTextField_textoDeEnvioKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_chatMulticast().setVisible(true);
            }
        });
    }

    InetAddress grupo;
    MulticastSocket socket;
    LinkedList<String> lista = new LinkedList<>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Conectar;
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel_Nick;
    private javax.swing.JLabel jLabel_Porta;
    private javax.swing.JLabel jLabel_ServidorIP;
    private javax.swing.JList<String> jList_usuariosOnline;
    private javax.swing.JPanel jPanel_Chat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_Mensagens;
    private javax.swing.JTextField jTextField_GrupoIP;
    private javax.swing.JTextField jTextField_Nick;
    private javax.swing.JTextField jTextField_Porta;
    private javax.swing.JTextField jTextField_textoDeEnvio;
    // End of variables declaration//GEN-END:variables
}
