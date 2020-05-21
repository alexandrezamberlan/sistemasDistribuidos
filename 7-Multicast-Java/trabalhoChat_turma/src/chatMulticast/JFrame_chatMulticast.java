package chatMulticast;

import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
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
    InetAddress group;
    MulticastSocket s;
    ComunicadorUDP com = new ComunicadorUDP();
    LinkedList<String> lista = new LinkedList<>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Mensagens = new javax.swing.JTextArea();
        jTextField_Requisicao = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jLabel_Porta = new javax.swing.JLabel();
        jTextField_Porta = new javax.swing.JTextField();
        jLabel_ServidorIP = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jTextField_ServidorIP = new javax.swing.JTextField();
        jLabel_Nick = new javax.swing.JLabel();
        jTextField_Nick = new javax.swing.JTextField();
        jButton_Conectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea_Mensagens.setEditable(false);
        jTextArea_Mensagens.setColumns(20);
        jTextArea_Mensagens.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Mensagens);

        jTextField_Requisicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_RequisicaoKeyPressed(evt);
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

        jLabel_ServidorIP.setText("Servidor IP:");

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jTextField_ServidorIP.setText("239.1.2.3");

        jLabel_Nick.setText("Nick:");

        jButton_Conectar.setText("Conectar");
        jButton_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ChatLayout = new javax.swing.GroupLayout(jPanel_Chat);
        jPanel_Chat.setLayout(jPanel_ChatLayout);
        jPanel_ChatLayout.setHorizontalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel_ServidorIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_ServidorIP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Sair)
                .addGap(2, 2, 2))
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addComponent(jTextField_Requisicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Enviar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ChatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_ChatLayout.setVerticalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Requisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ServidorIP)
                    .addComponent(jTextField_ServidorIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    class ThreadReceptora extends Thread {
        @Override
        public void run() {
            JFrame meuFrame = JFrame_chatMulticast.this;
            while (true) {
                try {
                    DatagramPacket pacote = com.recebeMensagem(s);
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

    private void sairDoSistema() throws IOException, NumberFormatException, NullPointerException {
        try {
            String msg = jTextField_Nick.getText() + " saiu da sala";
            DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            s.send(pacote);
            
        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                JOptionPane.showMessageDialog(this, "Você está saindo sem ter se conectado");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }  finally {
            System.exit(0);
        }      
    }

    //ESPECIFICO UMA THREAD EMISSORA DE MENSAGENS DO GRUPO
    private void jButton_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConectarActionPerformed
        jTextField_ServidorIP.getText();
        jTextField_Porta.getText();
        try {
            if (jTextField_Nick.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha seu nick");
            } else {
                //DEFINO O IP DO GRUPO
                group = InetAddress.getByName(jTextField_ServidorIP.getText());
                //CRIO O SOCKET MULTICAST COM A PORTA ESPECIFICADA
                s = new MulticastSocket(Integer.parseInt(jTextField_Porta.getText()));
                //ENTRA NO GRUPO MULTICAST PARA RECEBER AS MENSAGENS
                s.joinGroup(group);
                //CRIO A THREAD PARA RECEBER AS MENSAGENS
                ThreadReceptora tR = new ThreadReceptora();
                tR.start();
                JOptionPane.showMessageDialog(this, "Conectado com sucesso!");
                jButton_Conectar.setEnabled(false);
                jTextField_Nick.setEnabled(false);
                jTextField_ServidorIP.setEnabled(false);
                jTextField_Porta.setEnabled(false);

                String msg = jTextField_Nick.getText() + " entrou na sala";
                DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
                s.send(pacote);
                jTextField_Requisicao.requestFocus();
            }
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton_ConectarActionPerformed

    private void enviarMsg() throws IOException, NumberFormatException, NullPointerException {
        try {
            String msg = jTextField_Nick.getText() + ": " + jTextField_Requisicao.getText();
            DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            s.send(pacote);
            jTextField_Requisicao.setText("");
        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                JOptionPane.showMessageDialog(this, "Você precisa conectar antes de enviar msgs");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        try {
                this.enviarMsg();
                jTextField_Requisicao.requestFocus();
            } catch (IOException | NumberFormatException | NullPointerException e) {
                
            }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        try {
            sairDoSistema();
        } catch (IOException | NumberFormatException | NullPointerException e) {
            
        }
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void jTextField_RequisicaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_RequisicaoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.enviarMsg();
            } catch (IOException | NumberFormatException | NullPointerException e) {
                
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_jTextField_RequisicaoKeyPressed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Conectar;
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel_Nick;
    private javax.swing.JLabel jLabel_Porta;
    private javax.swing.JLabel jLabel_ServidorIP;
    private javax.swing.JPanel jPanel_Chat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_Mensagens;
    private javax.swing.JTextField jTextField_Nick;
    private javax.swing.JTextField jTextField_Porta;
    private javax.swing.JTextField jTextField_Requisicao;
    private javax.swing.JTextField jTextField_ServidorIP;
    // End of variables declaration//GEN-END:variables
}
