package functionalPrograming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Ravi", "Kamal", "Mohan", "Kareena");

        Comparator<String> stringCompare = (String a, String b) ->
                Character.compare(a.charAt(0), b.charAt(0));

        Collections.sort(names, stringCompare);

        System.out.println(names);

        List<String> names1 = Arrays.asList("Raj", "Ravi", "Kamal", "Mohan", "Kareena");
        Collections.sort(names1, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(names1);
    }
}
