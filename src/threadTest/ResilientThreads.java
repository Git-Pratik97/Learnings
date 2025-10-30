package threadTest;

public class ResilientThreads extends Thread{
    public void run(){
        for(int i = 0; i < 4; i++){
            System.out.println(i + " => " + Thread.currentThread().getName());

            if(Thread.currentThread().getName().equals("Thread-1") && i == 0){
                throw new RuntimeException("Stopped Thread due to it's name");
            }
        }
    }
}

class ThreadException {
    public static void main(String[] args) {
        ResilientThreads t1 = new ResilientThreads();
        ResilientThreads t2 = new ResilientThreads();
        ResilientThreads t3 = new ResilientThreads();

        t1.start();
        t2.start();
        t3.start();
    }
}
