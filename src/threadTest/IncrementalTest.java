package threadTest;

public class IncrementalTest {
    private int number = 1;
    private final int max_val = 10;
    private final int thread_count = 3;

    public synchronized void printNumbers(int threadId){
        while(number <= max_val){
            while(number % thread_count != threadId && number <= max_val){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if(number <= max_val){
                System.out.println("Thread - " + (threadId + 1) + " prints " + number);
                number++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        IncrementalTest test = new IncrementalTest();
        Thread t1 = new Thread(() -> test.printNumbers(1));
        Thread t2 = new Thread(() -> test.printNumbers(2));
        Thread t3 = new Thread(() -> test.printNumbers(0));

        t1.start();
        t2.start();
        t3.start();
    }
}
