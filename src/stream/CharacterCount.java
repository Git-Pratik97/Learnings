package stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterCount {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        int countChars = charCount(chars);
        System.out.println("Number of total Characters - " + countChars);
    }

    public static int charCount(char[] chars){
        int charCount = IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .keySet()
                .size();

        return charCount;
    }
}
