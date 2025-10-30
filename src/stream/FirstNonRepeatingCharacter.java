package stream;

import java.util.Arrays;
import java.util.Optional;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "Hello World!";

        String first = Arrays.stream(s.split("")).distinct().findFirst().get();

        String firstOccurrence = Arrays.stream(s.split(""))
                .filter(c->s.indexOf(c)!=s.lastIndexOf(c))
                .findFirst().get();

        System.out.println(first);

        System.out.println(firstOccurrence);

    }
}
