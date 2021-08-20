// package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrezamberlan
 */
public class Principal {
    public static void main(String[] args) {
        MinhaRunnable r = new MinhaRunnable();
        
		// Thread t = new Thread() {
		// 	public void run() {
		// 		System.out.println("oi");
		// 	}
		// };
		
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
        
        //espera as threads terminarem
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(r.x);
        
        
    }
}
