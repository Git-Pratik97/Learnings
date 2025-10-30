package threadTest;

public class RunnableThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hi From " + Thread.currentThread().getName());
        for(int i = 0; i < 4; i++){
            System.out.println("Thread with " + i + " and with name " + Thread.currentThread().getName());
        }
    }
}

class ThreadTestRun{
    public static void main(String[] args) {
        RunnableThread t1 = new RunnableThread();
        RunnableThread t2 = new RunnableThread();

        t1.run();
        t2.run();
        System.out.println("Hello now running thread " + Thread.currentThread().getName());
    }
}
