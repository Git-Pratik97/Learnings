package threadTest;

public class ThreadStates implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Thread with name " + Thread.currentThread().getName() +
                    " is in state of " + Thread.currentThread().getState());
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.getMessage();
        }
    }
}

class StatesDemoThread{
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new ThreadStates(), "Demo-Thread");
        System.out.println("Thread is in state " + t1.getState());
        t1.start();
        System.out.println("Thread is in state " + t1.getState());

        t1.sleep(2000);
        System.out.println("Thread is in state " + t1.getState());

        t1.join();
        System.out.println("Thread is in state " + t1.getState());

        System.out.println("Thread after completion " + t1.getState());
    }
}
