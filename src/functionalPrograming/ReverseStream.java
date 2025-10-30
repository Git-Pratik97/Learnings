package functionalPrograming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStream {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 6, 1, 4, 2, 8, 6, 3);

        List<Integer> reversedNums = nums.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = reversedNums.stream().reduce(0, (a, b) -> 2*a + b);
        System.out.println(sum);

        String num = "123";
        System.out.println(Integer.parseInt(num));
        
    }
}
