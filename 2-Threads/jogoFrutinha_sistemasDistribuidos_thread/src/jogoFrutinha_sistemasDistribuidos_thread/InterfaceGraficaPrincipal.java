package jogoFrutinha_sistemasDistribuidos_thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.awt.event.KeyAdapter;

public class InterfaceGraficaPrincipal {

	private JFrame frmJogoDaFrutinha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficaPrincipal window = new InterfaceGraficaPrincipal();
					window.frmJogoDaFrutinha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGraficaPrincipal() {
		initialize();
		
        sorteiaPosicoes();
        
        new Thread() {
        	public void run() {
        		Movimenta.esquerdaDireita(btn_barreira, frmJogoDaFrutinha);
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
                            System.out.println("Erro na chamada do sleep()");
                        }
                    } catch (Exception e) {
                        System.out.println("Deu pau na concorrência");
                    }
                }

            }
        }.start();
	}
	
	/**
	 * 
	 */
	private void sorteiaPosicoes() {
        Random gerador = new Random();
        JOptionPane.showMessageDialog(null, "Pronto para começar????");
        
        btn_frutinha.setBounds(gerador.nextInt(frmJogoDaFrutinha.getWidth() - 80), gerador.nextInt(frmJogoDaFrutinha.getHeight() - 80), 
        		btn_frutinha.getWidth(), btn_frutinha.getHeight());
        btn_jogador1.setBounds(gerador.nextInt(frmJogoDaFrutinha.getWidth() - 80), gerador.nextInt(frmJogoDaFrutinha.getHeight() - 80),
        		btn_jogador1.getWidth(), btn_jogador1.getHeight());
        btn_jogador2.setBounds(gerador.nextInt(frmJogoDaFrutinha.getWidth() - 80), gerador.nextInt(frmJogoDaFrutinha.getHeight() - 80),
        		btn_jogador2.getWidth(), btn_jogador2.getHeight());
    }
	
	
	private void btn_frutinhaKeyPressed(java.awt.event.KeyEvent evt) {                                         
        //System.out.println(evt.getKeyCode() + ", " + evt.getKeyChar());
        synchronized (frmJogoDaFrutinha) {
            pressed.add(evt.getKeyCode());
        }
    }    
	
	private void btn_frutinhaKeyReleased(java.awt.event.KeyEvent evt) {                                          
        synchronized (frmJogoDaFrutinha) {
            pressed.remove(evt.getKeyCode());
        }
    }  
	
	
	/**
	 * 
	 */
	public void verificaTeclas() {
        for (Integer c : pressed) {
            switch (c) {
                case KeyEvent.VK_UP:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irCima(btn_jogador2);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_DOWN:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irBaixo(btn_jogador2, frmJogoDaFrutinha.getHeight());
                        }
                    }.start();
                    break;
                case KeyEvent.VK_LEFT:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irEsquerda(btn_jogador2);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_RIGHT:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irDireita(btn_jogador2, frmJogoDaFrutinha.getWidth());
                        }
                    }.start();
                    break;
                case KeyEvent.VK_W:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irCima(btn_jogador1);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_S:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irBaixo(btn_jogador1, frmJogoDaFrutinha.getHeight());
                        }
                    }.start();
                    break;
                case KeyEvent.VK_A:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irEsquerda(btn_jogador1);
                        }
                    }.start();
                    break;
                case KeyEvent.VK_D:
                    new Thread() {
                        @Override
                        public void run() {
                            Movimenta.irDireita(btn_jogador1, frmJogoDaFrutinha.getWidth());
                        }
                    }.start();
                    break;
            }
        }
        if (Movimenta.pegou(btn_jogador1, btn_frutinha)) {
            Movimenta.sorteiaPosicao(btn_frutinha, frmJogoDaFrutinha);
        }
        if (Movimenta.pegou(btn_jogador2, btn_frutinha)) {
            Movimenta.sorteiaPosicao(btn_frutinha, frmJogoDaFrutinha);
        }
        if (Movimenta.pegou(btn_jogador1, btn_barreira)) {
            System.out.println("Jogador 1 foi pego pela barreira....");
        }
        if (Movimenta.pegou(btn_jogador2, btn_barreira)) {
            System.out.println("Jogador 2 foi pego pela barreira....");
        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDaFrutinha = new JFrame();
		frmJogoDaFrutinha.setTitle("Jogo da frutinha - THREADS");
		frmJogoDaFrutinha.setBounds(100, 100, 450, 300);
		frmJogoDaFrutinha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDaFrutinha.getContentPane().setLayout(null);
		
		btn_jogador2.setBounds(58, 178, 30, 22);
		frmJogoDaFrutinha.getContentPane().add(btn_jogador2);
		
		btn_jogador1.setBounds(63, 201, 30, 22);
		frmJogoDaFrutinha.getContentPane().add(btn_jogador1);
		
		btn_frutinha.setBackground(new Color(255, 200, 0));
		btn_frutinha.setBounds(147, 61, 21, 29);
		frmJogoDaFrutinha.getContentPane().add(btn_frutinha);
		btn_barreira.setBounds(6, 124, 98, 29);
		
		frmJogoDaFrutinha.getContentPane().add(btn_barreira);
		
		btn_frutinha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_frutinhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_frutinhaKeyReleased(evt);
            }
        });

	}
	
	JButton btn_jogador1 = new JButton("1");
	JButton btn_jogador2 = new JButton("2");
	JButton btn_frutinha = new JButton("@");
	public Set<Integer> pressed = new HashSet<Integer>();
	JButton btn_barreira = new JButton("====");
}
