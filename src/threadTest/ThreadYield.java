package threadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadYield {
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable printer = () -> {
            for(int i = 0; i < 3; i++){
                System.out.println("Thread with name " + Thread.currentThread().getName() + " is running. " + i );
                count.getAndIncrement();
                Thread.yield();
            }
        };

        Thread t1 = new Thread(printer, "Demo-1");
        Thread t2 = new Thread(printer, "Demo-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finally Atomic Counter is - " + count.get());


    }
}
