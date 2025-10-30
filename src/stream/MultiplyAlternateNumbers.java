package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyAlternateNumbers {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 7, 2, 9, 2};

        List<Integer> list = Arrays.stream(arr).boxed().toList();

        int sum = list.stream()
                .filter(a -> list.indexOf(a) % 2 != 0)
                .reduce(1, (a, b) -> a*b);

        System.out.println(sum);
    }
}
