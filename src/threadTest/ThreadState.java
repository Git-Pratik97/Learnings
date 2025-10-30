package threadTest;

import org.w3c.dom.ls.LSOutput;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class ThreadState implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is Running.");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

class ThreadStateExample{
    public static void main(String[] args) throws InterruptedException {
        ThreadState thread = new ThreadState();

        Thread newThread = new Thread("newThread");

        Thread mainThread = new Thread(thread, "DemoThread");

        System.out.println("State of " + mainThread.getName() + " is " + mainThread.getState());

        mainThread.start();

        System.out.println(mainThread.getName() + " state after start() " + mainThread.getState());
        Thread.sleep(200);

        System.out.println(mainThread.getName() + " State during sleep() " + mainThread.getState());

        mainThread.join();
        System.out.println(mainThread.getName() + " State after completion " + mainThread.getState());
    }


}
