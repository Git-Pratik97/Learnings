package stream;

import java.util.*;
import java.util.stream.Collectors;

public class RangeGrouping {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 14, 20, 24, 40, 34, 40, 44, 50, 54};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Map<Integer, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(x -> x/10*10
                        , TreeMap::new
                        ,Collectors.toList()));

        System.out.println(map);
    }
}
