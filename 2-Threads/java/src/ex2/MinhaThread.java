package ex2;

import ex1.*;

public class MinhaThread extends Thread {
    int x = 0;
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(" " + this.getName());
            x++;
        }
    }
}
