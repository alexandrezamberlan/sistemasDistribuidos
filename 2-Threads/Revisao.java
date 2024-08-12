class ExemploThreadSemCompartilharMemoria extends Thread {
    public ExemploThreadSemCompartilharMemoria(String str) {
        super(str); //enviando o parametro para o construtor pai
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i +  " " + getName());
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
        ExemploThreadSemCompartilharMemoria t1 = new ExemploThreadSemCompartilharMemoria("Gustavo");
        t1.start();

        ExemploThreadSemCompartilharMemoria t2 = new ExemploThreadSemCompartilharMemoria("Jose");
        t2.start();

        //opcao sem nome
        new ExemploThreadSemCompartilharMemoria("Zeni").start();
        new ExemploThreadSemCompartilharMemoria("Regis").start();

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
