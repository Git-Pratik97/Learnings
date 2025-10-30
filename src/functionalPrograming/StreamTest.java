package functionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Kareem", "Neha", "Dheeraj", "");
        Predicate<String> isNonEmpty = s -> !s.isEmpty();

        Stream<String> nameStream = names.stream();

        nameStream.forEach(System.out::println);
//        nameStream.forEach(System.out::println); //Cannot call the stream again



        Predicate<String> startsWithK = s -> !s.isEmpty() && s.charAt(0) == 'K';

        names.stream()
                .filter(isNonEmpty)
                .forEach(System.out::println);

        names.stream()
                .filter(startsWithK.and(isNonEmpty))
                .forEach(System.out::println);

        String joinedString = names.stream()
                        .filter(isNonEmpty)
                                .collect(Collectors.joining()).toLowerCase();

        long count = names.stream()
                .filter(startsWithK)
                                .count();

        System.out.println(joinedString + " " + count);

        System.out.println();
        Predicate<String> isValidEmail = s -> s.contains("@") && s.endsWith(".com");

        System.out.println(isValidEmail.test("pratik@gmail.com"));
    }




}
