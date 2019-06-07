package chatMulticast;

import ex3.EmissorReceptor;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.ComunicadorUDP;

/**
 *
 * @author Frederico
 * @author Patrick
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
        jLabel_ServidorIP = new javax.swing.JLabel();
        jTextField_ServidorIP = new javax.swing.JTextField();
        jLabel_Nick = new javax.swing.JLabel();
        jTextField_Nick = new javax.swing.JTextField();
        jButton_Conectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Mensagens = new javax.swing.JTextArea();
        jTextField_Requisicao = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jLabel_Porta = new javax.swing.JLabel();
        jTextField_Porta = new javax.swing.JTextField();
        jButton_Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_ServidorIP.setText("Servidor IP:");

        jTextField_ServidorIP.setText("239.1.2.3");
        jTextField_ServidorIP.setEnabled(false);

        jLabel_Nick.setText("Nick:");

        jButton_Conectar.setText("Conectar");
        jButton_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConectarActionPerformed(evt);
            }
        });

        jTextArea_Mensagens.setColumns(20);
        jTextArea_Mensagens.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Mensagens);

        jTextField_Requisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_RequisicaoActionPerformed(evt);
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
        jTextField_Porta.setEnabled(false);

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ChatLayout = new javax.swing.GroupLayout(jPanel_Chat);
        jPanel_Chat.setLayout(jPanel_ChatLayout);
        jPanel_ChatLayout.setHorizontalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ChatLayout.createSequentialGroup()
                        .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                                .addComponent(jTextField_Requisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Enviar)
                                .addGap(0, 53, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel_ChatLayout.createSequentialGroup()
                        .addComponent(jLabel_ServidorIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ServidorIP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Porta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Porta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Nick)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Conectar)
                        .addGap(1, 1, 1)
                        .addComponent(jButton_Sair))))
        );
        jPanel_ChatLayout.setVerticalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ServidorIP)
                    .addComponent(jTextField_ServidorIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nick)
                    .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Conectar)
                    .addComponent(jLabel_Porta)
                    .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Sair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Requisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_Chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ThreadReceptora extends Thread {

        public void run() {
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
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }

    //ESPECIFICO UMA THREAD EMISSORA DE MENSAGENS DO GRUPO

    private void jButton_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConectarActionPerformed
        jTextField_ServidorIP.setText("239.1.2.3");
        jTextField_Porta.setText("3456");
        try {
            if (jTextField_Nick.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha seu nick");
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
                JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
                jButton_Conectar.setEnabled(false);
                jTextField_Nick.setEnabled(false);
                String msg = jTextField_Nick.getText() + " entrou na sala";
                DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
                s.send(pacote);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão");
        }
    }//GEN-LAST:event_jButton_ConectarActionPerformed

    private void jTextField_RequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_RequisicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_RequisicaoActionPerformed

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed

        try {
            String msg = jTextField_Nick.getText() + ": " + jTextField_Requisicao.getText();
            DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            s.send(pacote);
            jTextField_Requisicao.setText("");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        try {
            String msg = jTextField_Nick.getText() + " saiu da sala";
            DatagramPacket pacote = com.montaMensagem(msg, jTextField_ServidorIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            s.send(pacote);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        System.exit(0);
    }//GEN-LAST:event_jButton_SairActionPerformed

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
