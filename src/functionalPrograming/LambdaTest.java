package functionalPrograming;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Kamal", "Mohan", "Sejal");
        names.forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        nums.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println("Number is Even");
            } else {
                System.out.println("Number is Odd");
            }
        });
    }
}
