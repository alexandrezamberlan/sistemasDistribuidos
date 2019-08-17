
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usrlab01
 */
public class JFrame_jogoFrutinha extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_jogoFrutinha
     */
    public JFrame_jogoFrutinha() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_jogador1 = new javax.swing.JButton();
        jButton_jogador2 = new javax.swing.JButton();
        jButton_fruta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da frutinha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jButton_jogador1.setText("1");
        jButton_jogador1.setFocusable(false);

        jButton_jogador2.setText("2");
        jButton_jogador2.setFocusable(false);

        jButton_fruta.setBackground(new java.awt.Color(255, 204, 0));
        jButton_fruta.setText("@");
        jButton_fruta.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton_jogador2)
                .addGap(18, 18, 18)
                .addComponent(jButton_jogador1)
                .addGap(82, 82, 82)
                .addComponent(jButton_fruta)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_fruta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jButton_jogador1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Random gerador = new Random();
        JOptionPane.showMessageDialog(this, "Pronto para começar????");
        jButton_fruta.setBounds(gerador.nextInt(this.getWidth() - 80), gerador.nextInt(this.getHeight() - 80), jButton_fruta.getWidth(), jButton_fruta.getHeight());
        jButton_jogador1.setBounds(gerador.nextInt(this.getWidth() - 80), gerador.nextInt(this.getHeight() - 80),
                jButton_jogador1.getWidth(), jButton_jogador1.getHeight());
        jButton_jogador2.setBounds(gerador.nextInt(this.getWidth() - 80), gerador.nextInt(this.getHeight() - 80),
                jButton_jogador2.getWidth(), jButton_jogador2.getHeight());
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        largura = this.getWidth();
        altura = this.getHeight();

        this.t = new Thread() {
            @Override
            public void run() {
                switch (evt.getKeyChar()) {
                    case 'o':
                        Movimenta.irCima(jButton_jogador2);
                        break;
                    case 'l':
                        Movimenta.irBaixo(jButton_jogador2, altura);
                        break;
                    case 'k':
                        Movimenta.irEsquerda(jButton_jogador2);
                        break;
                    case 'ç':
                        Movimenta.irDireita(jButton_jogador2, largura);
                        break;
                }

            }
        };
        t.start();
        
        switch (evt.getKeyChar()) {
            case 'w':
                Movimenta.irCima(jButton_jogador1);
                break;
            case 's':
                Movimenta.irBaixo(jButton_jogador1, altura);
                break;
            case 'a':
                Movimenta.irEsquerda(jButton_jogador1);
                break;
            case 'd':
                Movimenta.irDireita(jButton_jogador1, largura);
                break;
        }
        if (Movimenta.pegou(jButton_fruta, jButton_jogador1)) {
            Movimenta.sorteiaPosicao(jButton_fruta, this);
        }
        if (Movimenta.pegou(jButton_fruta, jButton_jogador2)) {
            Movimenta.sorteiaPosicao(jButton_fruta, this);
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(JFrame_jogoFrutinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_jogoFrutinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_jogoFrutinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_jogoFrutinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrame_jogoFrutinha().setVisible(true);
            }
        });
    }

    Thread t = new Thread();
    int largura;
    int altura;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_fruta;
    public javax.swing.JButton jButton_jogador1;
    public javax.swing.JButton jButton_jogador2;
    // End of variables declaration//GEN-END:variables
}
