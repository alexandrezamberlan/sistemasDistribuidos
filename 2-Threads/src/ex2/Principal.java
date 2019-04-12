/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(t1.x);
        System.out.println(t2.x);
        
        
    }
}
