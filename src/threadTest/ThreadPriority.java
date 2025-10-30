package threadTest;

import java.util.Random;

public class ThreadPriority extends Thread {
    public void run() {
        System.out.println("Thread started with name " + Thread.currentThread().getName());
        for(int i = 0; i < 10; i++){
            System.out.println(i + " => " + Thread.currentThread().getName());
        }
    }
}

class MyThread{
    public static void main(String[] args) {
        ThreadPriority thread1 = new ThreadPriority();
        ThreadPriority thread2 = new ThreadPriority();

        thread1.start();
        thread2.start();

        System.out.println("Starting thread -> " + Thread.currentThread().getName());
    }
}
