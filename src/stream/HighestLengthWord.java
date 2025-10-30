package stream;

import java.util.Arrays;
import java.util.Comparator;

public class HighestLengthWord {
    public static void main(String[] args) {
        String sentence = "I am learning Streams API in Java";

        String[] strings = sentence.trim().split(" ");

        String max_size_String = Arrays.stream(strings)
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println(max_size_String);
    }
}
