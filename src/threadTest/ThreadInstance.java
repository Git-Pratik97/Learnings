package threadTest;

public class ThreadInstance {
    public static void main(String[] args) throws InterruptedException {
        Worker work = new Worker();
        Thread w = new Thread(work, "Thread_1");
        w.start();
        System.out.println("Thread state after start - " + w.getState());

        Thread.sleep(2000);
        w.join();
        System.out.println("Thread State while sleep - " + w.getState());
    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println("Implementing Runnable Interface");
    }
}
