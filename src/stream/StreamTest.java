package stream;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        //Printing Even Numbers using stream
        System.out.println("Printing Even Numbers");
        nums.stream()
                .filter(n -> n % 2 == 0)
                .forEach(a -> System.out.print(a + " "));

        System.out.println();
        //Finding squares of numbers
        nums.stream()
                .map(a -> a*a)
                .skip(2)
                .findFirst()
                .get();
        System.out.println(
                nums.stream()
                        .map(a -> a*a)
                        .skip(2)
                        .findFirst()
                        .get()
        );
        System.out.println();
        Predicate<String> startsWithA = a -> a.toLowerCase().startsWith("a");
        List<String> list = Arrays.asList("apple", "Anjir", "Banana", "Orange");
        list.stream()
                .filter(startsWithA)
                .map(a -> a.toUpperCase())
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        System.out.println("Counting Elements Using Stream");
        System.out.println(list.stream()
                .count());


        Stream<Integer> stream = Stream.of(9, 7, 5, 3, 1, 6);
//        int max_value = stream.max((a , b) -> a.compareTo(b)).get();
//        System.out.println("Maxixmum Element of the stream : " + max_value);

        int min_Value = stream.min((a, b) -> a.compareTo(b)).get();
        System.out.println("Minimum Value from the stream : " + min_Value);
        System.out.println();

        List<Integer> list100 = Arrays.asList(7, 12, 54, 4234, 63, 22, 6, 1, 5);
        System.out.println("Sorted List - ");
        list100.stream().
                sorted(Comparator.reverseOrder())
                .forEach(a -> System.out.print(a + " "));

        System.out.println();
        System.out.print("Sum of All numbers in the list100 - ");
        int sum = list100.stream()
                .mapToInt(a -> Integer.valueOf(a))
                .sum();
        System.out.print(sum);

        int[] nums100 = {1, 2, 3, 4, 5, 6, 7, 8};
        int sum100 = Arrays.stream(nums100)
                        .sum();
        System.out.println("Sum100 - " + sum100);
        System.out.println();

        int[] nums99 = {1, 2, 23, 2, 2, 3, 3, 4, 1, 1, 4, 5, 6, 7};
        List<Integer> uniqueElem = Arrays.stream(nums99)
                .boxed()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct Elements from the list - " + uniqueElem);
        System.out.println();

        Map<Integer, Long> map = Arrays.stream(nums99)
                .boxed()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        List<String> names100 = Arrays.asList("Pratik", "Ravi", "Suman", "Kiran", "Amar", "Charan");

        System.out.println("Names with Uppercase Strings");
        List<String> upperCaseNames = names100.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperCaseNames);
        System.out.println();

        //Check if the Element matches condition
        boolean hasEven = Stream.of(1, 2, 4, 5, 6, 6, 7)
                .anyMatch(a -> a % 2 == 0);
        System.out.println(hasEven);
        System.out.println();

        boolean isPositive = Stream.of(1, 2, 3, 4, 5, 6, 9)
                .allMatch(a -> a > 0);
        System.out.println("If all are positive : " + isPositive);
        System.out.println();

        boolean isNegative = Stream.of(1, 2, 4, 5, 6, 7, 8, 8, 9)
                .noneMatch(a -> a > 0);
        System.out.println("If Negative - " + isNegative);
        System.out.println();

        int[] nums98 = {3, 23, 34, 1, 12, 13, 67, 72};
        int first = Arrays.stream(nums98)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .get();

        System.out.println("First Element - " + first);
        System.out.println();

        List<String> list98 = Arrays.asList("Hi", "I", "am", "Java");
        List<Integer> length98 = list98.stream()
                .map(a -> a.length())
                .toList();

        System.out.println("Length of the list elements - " + length98);
        System.out.println();

        List<String> limitStreamList = list98.stream()
                .limit(2)
                .toList();

        System.out.println(limitStreamList);
        System.out.println();

        List<String> list97 = Arrays.asList("Java", "Python", "cpp", "Scala");

        Map<String, Long> mapCount = list97.stream()
                .collect(Collectors.toMap(a -> a, b -> Long.valueOf(1), Long::sum));

        String longest = list97.stream()
                        .max(Comparator.comparing(String::length))
                                .get();

        System.out.println("Longest String is - " + longest);

        System.out.println("Frequency of String - " + mapCount);
        System.out.println();

        List<Integer> list96 = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3, 12, 1, 4, 5, 5, 4, 3,6, 7);
        Map<Integer, Long> freqMap97 = list96.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freqMap97);
        System.out.println();

        String name = "Hello Java";
        List<Character> chars97 = name.chars().mapToObj(a -> (char) a)
                .distinct()
                .sorted(Comparator.comparing(Character::toLowerCase))
                .collect(Collectors.toList());

        System.out.println("Characters - " + chars97);
        System.out.println();

        List<Integer> list95 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        double avg = list95.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println("Average of Numbers : " + avg);
    }
}
