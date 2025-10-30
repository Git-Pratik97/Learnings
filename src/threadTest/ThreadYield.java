package threadTest;

public class ThreadYield {
    public static void main(String[] args) {
        Runnable printer = () -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Thread with name " + Thread.currentThread().getName() + " is running. " + i );
                Thread.yield();
            }
        };

        Thread t1 = new Thread(printer, "Demo-1");
        Thread t2 = new Thread(printer, "Demo-2");

        t1.start();
        t2.start();


    }
}
