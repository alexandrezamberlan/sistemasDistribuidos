
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alexandrezamberlan
 */
public class JFrame_principal extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_principal
     */
    public JFrame_principal() {
        initComponents();
        meuFrame = this;
        JOptionPane.showMessageDialog(meuFrame, "Pronto para começar ????");
        new Thread() {
            public void run() {
                Movimenta.movimentaBola(jButton_bola, meuFrame, jButton_goleiro1, jButton_goleiro2, jTextField_golsGoleiro1, jTextField_golsGoleiro2);
            }
        }.start();
        
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        verificaTeclas();
                        try {
                            sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JFrame_principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (Exception e) {
                        System.out.println("Deu problema na concorrência");
                    }
                }
            }
        }.start();
    }
    
    public void verificaTeclas() {
        for (Integer c : pressed) {
            switch (c) {
                case KeyEvent.VK_UP:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irCima(jButton_goleiro2);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_DOWN:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irBaixo(jButton_goleiro2, altura);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_W:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irCima(jButton_goleiro1);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_S:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irBaixo(jButton_goleiro1, altura);
                        }
                    }.start();
                    break;
            }
        }
//        if (Movimenta.pegou(jButton_fruta, jButton_jogador1)) {
//            Movimenta.sorteiaPosicao(jButton_fruta, meuFrame);
//            pontosJogador1++;
//            jTextField_jogador1.setText("" + pontosJogador1);
//        }
//        if (Movimenta.pegou(jButton_fruta, jButton_jogador2)) {
//            Movimenta.sorteiaPosicao(jButton_fruta, meuFrame);
//            pontosJogador2++;
//            jTextField_jogador2.setText("" + pontosJogador2);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_goleiro1 = new javax.swing.JButton();
        jButton_goleiro2 = new javax.swing.JButton();
        jButton_bola = new javax.swing.JButton();
        jTextField_golsGoleiro1 = new javax.swing.JTextField();
        jTextField_golsGoleiro2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_goleiro1.setText("1");
        jButton_goleiro1.setFocusable(false);

        jButton_goleiro2.setText("2");
        jButton_goleiro2.setFocusable(false);

        jButton_bola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_bolaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton_bolaKeyReleased(evt);
            }
        });

        jTextField_golsGoleiro1.setText("0");
        jTextField_golsGoleiro1.setFocusable(false);

        jTextField_golsGoleiro2.setText("0");
        jTextField_golsGoleiro2.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField_golsGoleiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton_goleiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(263, 263, 263)
                .addComponent(jButton_bola, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 459, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_goleiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_golsGoleiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_golsGoleiro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField_golsGoleiro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_goleiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_goleiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton_bola, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_bolaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_bolaKeyPressed
        // TODO add your handling code here:
        largura = this.getWidth();
        altura = this.getHeight();
//        System.out.println(evt.getKeyCode() + ", " + evt.getKeyChar());
        synchronized (meuFrame) {
            pressed.add(evt.getKeyCode());
            //verificaTeclas();
        }
    }//GEN-LAST:event_jButton_bolaKeyPressed

    private void jButton_bolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_bolaKeyReleased
        // TODO add your handling code here:
        synchronized (meuFrame) {
            pressed.remove(evt.getKeyCode());
        }
    }//GEN-LAST:event_jButton_bolaKeyReleased

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
            java.util.logging.Logger.getLogger(JFrame_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_principal().setVisible(true);
            }
        });
    }

    public Set<Integer> pressed = new HashSet<>();
    JFrame meuFrame;
    int largura;
    int altura;
    int pontosJogador1 = 0;
    int pontosJogador2 = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_bola;
    public javax.swing.JButton jButton_goleiro1;
    public javax.swing.JButton jButton_goleiro2;
    public javax.swing.JTextField jTextField_golsGoleiro1;
    public javax.swing.JTextField jTextField_golsGoleiro2;
    // End of variables declaration//GEN-END:variables
}
