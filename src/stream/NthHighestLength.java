package stream;

import java.util.Arrays;
import java.util.Comparator;

public class NthHighestLength {
    public static void main(String[] args) {

        String s = "I am learning streams API in Java";

        String secondLength = Arrays.stream(s.split(" "))
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1).findFirst().get();

        int thirdLength = Arrays.stream(s.split(" "))
                        .map(x -> x.length()).sorted(Comparator.reverseOrder())
                        .skip(2).findFirst().get();

        System.out.println(secondLength);

        System.out.println("Length of third largest String - " + thirdLength);

    }
}
