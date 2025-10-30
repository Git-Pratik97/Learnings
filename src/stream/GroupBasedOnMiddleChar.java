package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupBasedOnMiddleChar {
    public static void main(String[] args) {
        String[] str = {"ewe", "jji", "jhj", "kwk", "aha"};

        Map<Character, List<String>> mapString = Arrays.stream(str)
                .collect(Collectors.groupingBy(x-> x.charAt(x.length()/2), Collectors.toList()));

        System.out.println(mapString);
    }
}
