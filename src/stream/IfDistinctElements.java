package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IfDistinctElements {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, 0, 8, 0};

        List<Integer> list = Arrays.stream(arr).boxed().toList();

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(map);
        Collection<Long> mapValues = map.values();

//        System.out.println(mapValues);

        boolean distinctCheck =  mapValues.stream().noneMatch(x -> x > 1);
        System.out.println(distinctCheck);
    }
}
