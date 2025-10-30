package stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String str = "Hello World !";

        char ans = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity()
                        ,LinkedHashMap::new
                        ,Collectors.counting()))
                        .entrySet().stream()
                        .filter(a -> a.getValue() > 1)
                                .map(a -> a.getKey())
                                        .findFirst().get();

        System.out.println(ans);
    }
}
