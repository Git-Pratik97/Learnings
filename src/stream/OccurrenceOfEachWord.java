package stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurrenceOfEachWord {
    public static void main(String[] args) {

        String s = "I am leaning Streams APU in Java Java";

        Map<String, Long> map = Arrays.stream(s.split(" "))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(map);
    }
}
