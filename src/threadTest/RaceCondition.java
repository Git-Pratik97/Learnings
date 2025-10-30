package threadTest;

public class RaceCondition {
    int count = 0;
    public void increment(){
        synchronized(this){
            count++;
        }

    }
}

class CounterTest{
    public static void main(String[] args) throws InterruptedException {
        RaceCondition counter = new RaceCondition();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 15000; i++){
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 15000; i++){
                counter.increment();
            }
        }) ;

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count of the counter is - " + counter.count);

    }
}
