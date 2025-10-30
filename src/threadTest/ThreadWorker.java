package threadTest;

public class ThreadWorker extends Thread{
    private String name;

    public ThreadWorker(String name){
        this.name = name;
    }

    public void run(){

        try{
            System.out.println(name + " Started ");
            Thread.sleep(2000);
            System.out.println(name + " Completed ");
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

class JoinExample{
    private static ThreadWorker thread1;

    public static void main(String[] args) throws InterruptedException {
        ThreadWorker thread1 = new ThreadWorker("Thread_1");
        ThreadWorker thread2 = new ThreadWorker("Thread_2");
        System.out.println("Thread_1 Id = " + thread1.getId());
        thread1.start();
        thread1.join();
        thread2.start();

//        thread2.join();
//        System.out.println("Thread_1 has finished Now Waiting for Thread_2");
//
//        System.out.println("Thread_2 has finished Now Waiting for Thread_2");
        System.out.println("Both Threads have finished, Main thread to proceed");
    }
}
