package threadTest;

public class ThreadName extends Thread{
    @Override
    public void run() {
        System.out.println("Name of this thread is " + Thread.currentThread().getName());
    }
}

class TestThreadName{
    public static void main(String[] args) {
        ThreadName t1 = new ThreadName();
        t1.setName("Thread-t1");

        ThreadName t2 = new ThreadName();
        Thread t21 = new Thread(t2, "Thread-t2");
        Thread t3 = new Thread(new ThreadName(), "Thread-t3");
        t1.start();

        t21.start();
        t3.start();
    }
}
