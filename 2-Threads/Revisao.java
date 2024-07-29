public class ExemploThreadSemCompartilharMemoria extends Thread {
    public ExemploThreadSemCompartilharMemoria(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE! " + getName());
    }
}

public class Revisao {
    public static void main(String a[]) {
        //opcao com nome de variável
        ExemploThreadSemCompartilharMemoria nomeThread = new ExemploThreadSemCompartilharMemoria("Gustavo");
        nomeThread.start();

        //opcao sem nome
        new ExemploThreadSemCompartilharMemoria("Zeni").start();
        new ExemploThreadSemCompartilharMemoria("Regis").star();

        //opcao sem nome e aninhada
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + getName());
                    try {
                        sleep((long)(Math.random() * 1000));
                    } catch (InterruptedException e) {}
                }
                System.out.println("DONE! " + getName());
            } 
        }.start();        
    }
}
