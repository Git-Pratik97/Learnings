package threadTest;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable task = () -> {
            Thread.sleep(2000);
            return "Hello From Callable Service";
        };

        Future<String> future = executorService.submit(task);

        System.out.println("Waiting for results...");

        String results = future.get();

        System.out.println("Results = " + results);

        executorService.shutdown();
    }
}
