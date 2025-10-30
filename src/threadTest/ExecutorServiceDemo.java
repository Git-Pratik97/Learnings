package threadTest;

import com.sun.tools.javac.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i <= 5; i++){
            String studentName = "Student_"+i;

            Runnable task = () -> System.out.println("Name of the student : " + studentName
                    + " with thread : " + Thread.currentThread().getName());

            executorService.execute(task);
        }

        executorService.shutdown();
    }
}
