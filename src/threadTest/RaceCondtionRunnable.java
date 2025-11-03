package threadTest;

public class RaceCondtionRunnable {
//    private static Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter();
        Runnable task = () -> {
          for(int i = 0; i < 3000; i++){
              counter.increment();
          }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();;
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter value is " + counter.count);
    }
}

class Counter {
   int count;

   public void increment() {
       count++;
    }
}
