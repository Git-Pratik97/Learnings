package stream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateInString {
    public static void main(String[] args) {
        String str = "Test Java With Java 8 and Java 8 features";

        Set<String> duplicates = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
        System.out.println(duplicates);
    }
}
