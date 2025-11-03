package stream;

import java.util.Arrays;
import java.util.List;

public class ProductOfFirstTwoElements {
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 9, 2, 4};

        int ans = Arrays.stream(arr)
                .boxed()
//                .toList()
//                .stream()
                .limit(2)
                .reduce(1, (a, b) -> a*b);

        System.out.println(ans);
    }
}
