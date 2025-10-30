package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WithVowels {
    public static void main(String[] args) {
        String s = "I am learning Streams API in Java";

        List<String> list = Arrays.stream(s.split(" "))
                .filter(str -> str.replaceAll("[^aeiouAEIOU]", "").length() == 2)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(list);
    }
}
