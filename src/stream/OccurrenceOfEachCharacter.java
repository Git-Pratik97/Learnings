package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OccurrenceOfEachCharacter {
    public static void main(String[] args) {
        String str = "Mississippi";

        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        System.out.println(map);
    }
}
