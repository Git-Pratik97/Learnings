package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortAlphabeticalOrder {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Zudio", "Puma", "Adidas", "MAC", "H&M");

        List<String> sortedList = str.stream()
                .sorted(Comparator.comparing(a -> a.charAt(0)))
                .toList();

        System.out.println(sortedList);
    }
}
