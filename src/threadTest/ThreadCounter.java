package threadTest;

public class ThreadCounter {
    int count = 0;
    public void increment(){
        synchronized (this){
            count++;
        }
    }
}

class CounterThread{
    public static void main(String[] args) throws InterruptedException{
        ThreadCounter counter = new ThreadCounter();
        Thread t1 = new Thread(() ->
        {
            for(int i = 0; i < 2500; i++){
                counter.increment();
            }
        });

        Thread t2 = new Thread(() ->
        {
            for(int i = 0; i < 1500; i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count after executions is " + counter.count);
    }
}
