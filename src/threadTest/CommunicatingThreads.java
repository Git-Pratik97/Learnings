package threadTest;

public class CommunicatingThreads {
    private boolean isOdd = true;

    public synchronized void printOdd(int num) throws InterruptedException{
        while(!isOdd){
            wait();
        }
        System.out.println("Odd - " + num);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int num) throws InterruptedException{
        while(isOdd){
            wait();
        }
        System.out.println("Even - " + num);
        isOdd = true;
        notify();
    }
}

class PrintingNums{
    public static void main(String[] args) {
        CommunicatingThreads printer = new CommunicatingThreads();

        Thread oddThread = new Thread(() ->
        {
            for(int i = 1; i <= 10; i+=2){
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread evenThread = new Thread(() -> {

            for(int i = 2; i <= 10; i+=2){
                try{
                    printer.printEven(i);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
