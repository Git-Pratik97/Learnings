package stream;

import java.util.Arrays;
import java.util.List;

public class SumOfElementsInList {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);

        int sum = num.stream().reduce(0, (a, b) -> a + b);

        int mapSum = num.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Using mapSum = " + mapSum);

        System.out.println(sum);
    }
}
