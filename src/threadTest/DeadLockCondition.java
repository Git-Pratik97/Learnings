package threadTest;

public class DeadLockCondition {
    static final Object LOCK_A = new Object();
    static final Object Lock_B = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_A){
                System.out.println("Thread 1 - Acquired LOCK_A");

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 1 - Waiting for LOCK_B");
                synchronized (Lock_B){
                    System.out.println("Thread 1 - Acquired LOCK_B ");
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            synchronized (Lock_B){
                System.out.println("Thread 2 - Acquired LOCK_A");

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 2 - Waiting for LOCK_A");
                synchronized (LOCK_A){
                    System.out.println("Thread 2 - Acquired LOCK_A ");
                }
            }
        });


        thread1.start();
        thread2.start();
    }
}
