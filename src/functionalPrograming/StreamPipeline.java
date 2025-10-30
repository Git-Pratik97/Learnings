package functionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPipeline {

    public static void main(String[] args) {
        Stream<Integer> numsStream = Arrays.asList(1, 2, 4, 5, 3, 8, 11, 9, 10).stream();
        Stream<Integer> evenNumStream = numsStream.filter(n -> n % 2 == 0);
//        evenNumStream.forEach(n -> System.out.println(n));

        long sumEven = evenNumStream.reduce(0, (a, b) -> a + b);
        System.out.println(sumEven);

        List<String> names = Arrays.asList("Shivam", "Anamika", "Tejas", "Praveen");
        String joinedNames = names.stream()
                .sorted((s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0)))
                .collect(Collectors.joining("-"));

        System.out.println("Joined Names : " + joinedNames);
        Stream<String> nameStream = names.stream();
        Stream<Integer> lengthStream = nameStream.map(String::length);
        Stream<Integer> sortedLengths = lengthStream.sorted();
        List<Integer> lengths = sortedLengths.collect(Collectors.toList());

        lengths.forEach(System.out::println);
    }

}
