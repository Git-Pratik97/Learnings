package threadTest;

public class ThreadTest extends Thread{
    public void run(){
        System.out.println("Thread is Running " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest thread = new ThreadTest();
        thread.start();
    }
}

class ThreadRunnable implements Runnable{
    public void run(){
        System.out.println("Thread started with Runnable Interface " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread thread = new Thread(threadRunnable);

        thread.start();
    }
}

class LambdaThreadTest{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Created Thread using Lambda Expression " + Thread.currentThread().getName());
        });
        thread.start();
    }
}
