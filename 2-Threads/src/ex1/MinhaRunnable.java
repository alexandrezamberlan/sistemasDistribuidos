
package ex1;

public class MinhaRunnable implements Runnable {
    int x = 0;
    
    public void run(){
        for (int i = 0; i < 10000; i++) {
            synchronized(this){
                x++;
            }
        }
    }
}
