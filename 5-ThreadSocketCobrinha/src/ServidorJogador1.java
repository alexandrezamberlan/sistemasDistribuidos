
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alexandrezamberlan
 */
public class ServidorJogador1 extends javax.swing.JFrame {

    /**
     * Creates new form ServidorJogador1
     */
    public ServidorJogador1() {
        initComponents();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Servidor esperando o cliente conectar-se...porta 12345");
                    servidor = new ServerSocket(12345);

                    Socket socket_jogador2 = servidor.accept();
                    // o método accept() bloqueia a execução até que
                    // o servidor receba um pedido de conexão
                    saida = new ObjectOutputStream(socket_jogador2.getOutputStream());
                    entrada = new ObjectInputStream(socket_jogador2.getInputStream());
                    System.out.println("Cliente conectado: " + socket_jogador2.getInetAddress().getHostAddress());

                    //para enviar ao jogador 2
                    //saida = new ObjectOutputStream(socket_jogador2.getOutputStream());
                    while (true) {
                        c = (Componente) entrada.readObject();
                        //se for jogador
                        if (c.tipo == Componente.JOGADOR) {
                            jButtonJogador2.setBounds(c.x, c.y, c.largura, c.altura);
                        } //se for fruta
                        else if (c.tipo == Componente.FRUTA) {
                            jButtonFruta.setBounds(c.x, c.y, c.largura, c.altura);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelJogador1 = new javax.swing.JPanel();
        jButtonJogador1 = new javax.swing.JButton();
        jButtonJogador2 = new javax.swing.JButton();
        jButtonFruta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogador 1 - SERVIDOR");

        jButtonJogador1.setText("j1");
        jButtonJogador1.setFocusable(false);

        jButtonJogador2.setText("j2");
        jButtonJogador2.setFocusable(false);

        jButtonFruta.setBackground(new java.awt.Color(255, 204, 0));
        jButtonFruta.setText("@");
        jButtonFruta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonFrutaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelJogador1Layout = new javax.swing.GroupLayout(jPanelJogador1);
        jPanelJogador1.setLayout(jPanelJogador1Layout);
        jPanelJogador1Layout.setHorizontalGroup(
            jPanelJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogador1Layout.createSequentialGroup()
                .addGroup(jPanelJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelJogador1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonJogador2))
                    .addGroup(jPanelJogador1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jButtonFruta)
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelJogador1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButtonJogador1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJogador1Layout.setVerticalGroup(
            jPanelJogador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogador1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButtonJogador1)
                .addGap(64, 64, 64)
                .addComponent(jButtonFruta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButtonJogador2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelJogador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFrutaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonFrutaKeyPressed
        // TODO add your handling code here:

        switch (evt.getKeyCode()) {
            case 37:
                //System.out.println("indo para esquerda");
                Movimenta.irEsquerda(jButtonJogador1);
                break;
            case 38:
                //System.out.println("indo para cima");
                Movimenta.irCima(jButtonJogador1);
                break;
            case 39:
                //System.out.println("indo para direita");
                Movimenta.irDireita(jButtonJogador1, jPanelJogador1.getBounds().width);
                break;
            case 40:
                //System.out.println("indo para baixo");
                Movimenta.irBaixo(jButtonJogador1, jPanelJogador1.getBounds().height);
                break;
        }
        if (Movimenta.pegou(jButtonJogador1, jButtonFruta)) {
            Movimenta.posicionaAleatorio(jButtonFruta,
                    jPanelJogador1.getBounds().width,
                    jPanelJogador1.getBounds().height);
            try {
                saida.flush();
                c = new Componente(jButtonFruta.getBounds().x,
                        jButtonFruta.getBounds().y,
                        jButtonFruta.getBounds().width,
                        jButtonFruta.getBounds().height);
                c.tipo = Componente.FRUTA;
                saida.writeObject(c);
            } catch (Exception e) {
                System.out.println("Erro ao enviar a fruta");
            }
        }

        //enviando o botao do jogador1 e o botao da fruta para o cliente
        try {
            saida.flush();
            c = new Componente(jButtonJogador1.getBounds().x,
                    jButtonJogador1.getBounds().y,
                    jButtonJogador1.getBounds().width,
                    jButtonJogador1.getBounds().height);
            c.tipo = Componente.JOGADOR;
            saida.writeObject(c);

        } catch (Exception e) {
            System.out.println("Erro.... sem servidor: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonFrutaKeyPressed

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
            java.util.logging.Logger.getLogger(ServidorJogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorJogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorJogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorJogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorJogador1().setVisible(true);
            }
        });
    }
    ServerSocket servidor;
    ObjectOutputStream saida;
    ObjectInputStream entrada;
    Componente c;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFruta;
    private javax.swing.JButton jButtonJogador1;
    private javax.swing.JButton jButtonJogador2;
    private javax.swing.JPanel jPanelJogador1;
    // End of variables declaration//GEN-END:variables
}
