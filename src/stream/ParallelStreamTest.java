package stream;

import java.util.Arrays;

public class ParallelStreamTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 7, 8, 8, 20, 121, 12, 13, 14, 16};

        int sumParallel = Arrays.stream(nums)
                .parallel()
                .sum();

        System.out.println("Sum of Numbers - " + sumParallel);
    }
}
