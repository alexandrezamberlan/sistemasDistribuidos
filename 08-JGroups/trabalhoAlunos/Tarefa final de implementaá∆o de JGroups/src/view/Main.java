
package view;

import controller.Comunicador;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main extends javax.swing.JFrame {

    Comunicador com;
    JScrollBar vertical;

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        com = new Comunicador(this);
        vertical = jScrollPane1.getVerticalScrollBar();
        jTextUsuario.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextUsuario = new javax.swing.JTextField();
        jButtonConectar = new javax.swing.JButton();
        jTextStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextMensagem = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboUsuarios = new javax.swing.JComboBox<>();
        jLabelMensagemPrivada = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaUsuarios = new javax.swing.JTextArea();
        jTextidView = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat JGroups");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextUsuario.setBackground(new java.awt.Color(240, 240, 240));
        jTextUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Usuário:"));

        jButtonConectar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonConectar.setText("CONECTAR");
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jTextStatus.setEditable(false);
        jTextStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextStatus.setForeground(new java.awt.Color(255, 0, 0));
        jTextStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextStatus.setText("AGUARDANDO CONEXÃO...");
        jTextStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Status:"));

        jTextAreaChat.setEditable(false);
        jTextAreaChat.setColumns(20);
        jTextAreaChat.setLineWrap(true);
        jTextAreaChat.setRows(5);
        jTextAreaChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextAreaChat);

        jTextMensagem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextMensagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextMensagem.setEnabled(false);
        jTextMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextMensagemKeyPressed(evt);
            }
        });

        jButtonEnviar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEnviar.setText("ENVIAR");
        jButtonEnviar.setEnabled(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jComboUsuarios.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jComboUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chat geral" }));
        jComboUsuarios.setBorder(null);
        jComboUsuarios.setEnabled(false);
        jComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsuariosActionPerformed(evt);
            }
        });

        jLabelMensagemPrivada.setText("Enviar uma mensagem para:");

        jTextAreaUsuarios.setEditable(false);
        jTextAreaUsuarios.setColumns(20);
        jTextAreaUsuarios.setLineWrap(true);
        jTextAreaUsuarios.setRows(5);
        jTextAreaUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextAreaUsuarios);

        jTextidView.setEditable(false);
        jTextidView.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextidView.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextidView.setText("-");
        jTextidView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ID da View:"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMensagemPrivada)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextidView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextidView, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTextMensagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMensagemPrivada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        if (verificarErros() == false && com.iniciarConexao() == true) {
            jButtonConectar.setEnabled(false);
            jTextUsuario.setEditable(false);
            jTextMensagem.setEnabled(true);
            jButtonEnviar.setEnabled(true);
            jComboUsuarios.setEnabled(true);
            jTextStatus.setText("CONEXÃO ESTABELECIDA");
            jTextStatus.setForeground(Color.GREEN);
            jTextMensagem.requestFocus();
        }
    }//GEN-LAST:event_jButtonConectarActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        enviarMensagem();
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMensagemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarMensagem();
        }
    }//GEN-LAST:event_jTextMensagemKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (jComboUsuarios.isEnabled()) {
            com.enviar(" deixou a sala.");
        }
    }//GEN-LAST:event_formWindowClosing

    private void jComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsuariosActionPerformed
        verificarComboBox();
    }//GEN-LAST:event_jComboUsuariosActionPerformed

    public boolean verificarErros() {
        boolean erro = false;

        if (jTextUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo usuário corretamente.", "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
            erro = true;
        }

        return erro;
    }

    public void verificarComboBox() {
        if (jComboUsuarios.getItemCount() > 0) {
            if (!jComboUsuarios.getSelectedItem().toString().equals(jTextUsuario.getText())) {
                jTextMensagem.setEnabled(true);
                jButtonEnviar.setEnabled(true);
            } else {
                jTextMensagem.setText("");
                jTextMensagem.setEnabled(false);
                jButtonEnviar.setEnabled(false);
            }
        }
    }

    public void enviarMensagem() {
        if (!jTextMensagem.getText().isEmpty()) {
            if (jComboUsuarios.getSelectedIndex() == 0) {
                //Mensagem normal
                String msg = ": " + jTextMensagem.getText();
                
                com.enviar(msg);
                jTextMensagem.setText("");
            } else {
                //Mensagem privada
                String user = jComboUsuarios.getSelectedItem().toString();
                String msg = jTextMensagem.getText();

                com.enviarMP(user, msg);
                jTextMensagem.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escreva alguma mensagem para enviar.", "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public JTextField getjTextUsuario() {
        return jTextUsuario;
    }

    public JTextArea getjTextAreaChat() {
        return jTextAreaChat;
    }

    public JComboBox<String> getjComboUsuarios() {
        return jComboUsuarios;
    }

    public JScrollBar getVertical() {
        return vertical;
    }

    public JTextArea getjTextAreaUsuarios() {
        return jTextAreaUsuarios;
    }

    public JTextField getjTextidView() {
        return jTextidView;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JLabel jLabelMensagemPrivada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextArea jTextAreaUsuarios;
    private javax.swing.JTextField jTextMensagem;
    private javax.swing.JTextField jTextStatus;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JTextField jTextidView;
    // End of variables declaration//GEN-END:variables
}
