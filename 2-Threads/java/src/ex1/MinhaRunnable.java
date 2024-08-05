//package ex1;

import java.lang.Thread;// package ex1;

//Com uso de threads sem memória compartilhada, usa-se a classe Thread
//Com uso de threads com memória compartilhada, usa-se a interface Runnable

public class MinhaRunnable implements Runnable {
    int x = 0;
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            // synchronized(this){ //
                x++;
                Thread currentThread = Thread.currentThread();
                System.out.println(x + " | " + currentThread.getName());
            // }
            
        }
    }
}
