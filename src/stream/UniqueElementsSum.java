package stream;

import java.util.Arrays;

public class UniqueElementsSum {
    public static void main(String[] args) {
        int[] arr = {1, 6, 7, 8, 1, 1, 8, 8, 7, 5};

        int[] arr1 = {7, 7, 7, 7};

        int sum = Arrays.stream(arr).mapToObj(x -> x).distinct().reduce(0, (a, b) -> a + b);

        int add = Arrays.stream(arr1).distinct().sum();

        System.out.println("sum is: " + sum + " and add is: " + add);
    }
}
