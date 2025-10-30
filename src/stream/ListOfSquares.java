package stream;

import java.util.Arrays;
import java.util.List;

public class ListOfSquares {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squareList = list.stream()
                .map(a-> a*a)
                .toList();

        System.out.println(squareList);
    }
}
