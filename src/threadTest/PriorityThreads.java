package threadTest;

public class PriorityThreads implements Runnable{
    public void run(){
        System.out.println("Current Running Thread - " + Thread.currentThread().getName()
                + " is running with priority " + Thread.currentThread().getPriority());
    }
}

class TestThread{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PriorityThreads());
        Thread thread2 = new Thread(new PriorityThreads());
        Thread thread3 = new Thread(new PriorityThreads());

        thread3.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(8);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
