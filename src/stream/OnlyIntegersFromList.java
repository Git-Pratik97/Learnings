package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OnlyIntegersFromList {
    public static void main(String[] args) {
        String[] s = {"abc", "123", "456", "xyz"};

        List<Integer> list = Arrays.stream(s)
                .filter(x-> x.matches("[0-9]+"))
//                .map(x -> Integer.valueOf(x))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
