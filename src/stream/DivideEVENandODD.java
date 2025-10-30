package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivideEVENandODD {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 7, 8};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Map<Boolean, List<Integer>> map  = list.stream().collect(Collectors.groupingBy(x->x%2==0, Collectors.toList()));

        System.out.println(map);

        List<List<Integer>> numbers = list.stream()
                .collect(Collectors.partitioningBy(x->x%2 == 0, Collectors.toList()))
                .entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());

        System.out.println(numbers);
    }
}
