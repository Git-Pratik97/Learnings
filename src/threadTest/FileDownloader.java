package threadTest;

public class FileDownloader extends Thread implements Runnable{
    public void run(){
        try{
            System.out.println("File Downloading...");
            Thread.sleep(3000);
            System.out.println("File Downloaded !");
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

class FileProcessor extends Thread{
    public void run(){
        try{
            System.out.println("Processing File...");
            Thread.sleep(2000);
            System.out.println("File Processing Done !");
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

class FileDownloaderAndProcessor {
    public static void main(String[] args) throws InterruptedException {
        FileDownloader fileDownloader = new FileDownloader();
        FileProcessor fileProcessor = new FileProcessor();

        fileDownloader.start();
        fileDownloader.join();
        fileProcessor.start();
    }
}
