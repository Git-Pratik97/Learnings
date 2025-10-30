package functionalPrograming;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> isPassed = marks -> marks >= 35;
        System.out.println(isPassed.test(35));
        System.out.println(isPassed.test(34));

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(36));

        Predicate<Integer> evenPassed = isPassed.and(isEven);

        System.out.println(evenPassed.test(34));


    }
}
