package threadTest;

import java.util.Collections;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        MessageBox messageBox = new MessageBox();
        Producer producer = new Producer(messageBox);
        Consumer consumer = new Consumer(messageBox);

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread{
    private MessageBox messageBox;

    public Producer(MessageBox messageBox) throws InterruptedException {
        this.messageBox = messageBox;
    }

    public void run(){
        try {
            messageBox.put("Hello From Producer...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer extends Thread{
    MessageBox messageBox;

    public Consumer(MessageBox messageBox){
        this.messageBox = messageBox;
    }

    public void run(){
        try{
            messageBox.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MessageBox{
    private String message;
    private boolean hasMessage = false;

//    public MessageBox(String message){
//        this.message = message;
//        this.hasMessage = hasMessage;
//    }

    public synchronized void put(String message) throws InterruptedException{
        while(hasMessage){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.message = message;
        System.out.println("Message Loaded" + message);
        hasMessage = true;
        notify();
    }

    public synchronized void get() throws InterruptedException{
        while(!hasMessage){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Message received... " + message);
        hasMessage = false;
        notify();
    }
}
