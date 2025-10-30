package stream;

import java.util.stream.IntStream;

public class MultiplyFirstAndLastElement {
    public static void main(String[] args) {
         int[] arr = {4, 5, 1, 7, 2, 9};

        IntStream.range(0, arr.length/2)
                .map(x -> arr[x]*arr[arr.length-x-1])
                .forEach(System.out::println);
    }
}
