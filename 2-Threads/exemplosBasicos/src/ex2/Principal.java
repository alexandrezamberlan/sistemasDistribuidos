//package ex2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author alexandrezamberlan
 */
public class Principal {
    public static void main(String[] args) {
        
        MinhaThread t1 = new MinhaThread();
        MinhaThread t2 = new MinhaThread();
        
        t1.start();
        t2.start();
        
        //espera as threads terminarem
        // try {
        //     t1.join();
        //     t2.join();
        // } catch (InterruptedException ex) {
        //     Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        // }
        
        System.out.println(t1.x);
        System.out.println(t2.x);


        Thread t3 = new Thread() {
            int x = 0;
    
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println(" " + this.getName());
                    x++;
                }
            }
        };
        t3.start();

        List<Thread> listaThreads = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            listaThreads.add( new Thread() {
                int x = 0;
        
                public void run(){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(" " + this.getName());
                        x++;
                    }
                }
            }

            );
            listaThreads.get(i).start();
        }       
    }
}
