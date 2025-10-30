package functionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 13, 12, 16, 18, 20, 22, 24);
        System.out.println("Parallel Stream Test - ");
        nums.parallelStream().forEach(System.out::println);
        System.out.println();
        System.out.println("Sequential Stream using parallel() - ");
        nums.stream().parallel().forEach(System.out::println);

        Random random = new Random();
        System.out.println("Random Number - " + random.nextInt(10));
    }
}
