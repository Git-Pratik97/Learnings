package stream;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "dabcadefg";

        s.chars().distinct().mapToObj(c -> (char)c).forEach(n -> System.out.print(n));
        System.out.println();
        Arrays.stream(s.split("")).distinct().forEach(c -> System.out.printf(c));
    }
}
