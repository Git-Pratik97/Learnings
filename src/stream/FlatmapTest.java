package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatmapTest {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(1, 2), List.of(3, 4));

        list.stream().map(List::stream).forEach(System.out::println);

        list.stream().flatMap(List::stream).forEach(System.out::println);

        List<Integer> nums = List.of(3, 7, 2, 8, 8);

        Optional<Integer> max = nums.stream().max(Integer::compare);

        System.out.println(max.get());

        int sum = nums.stream().mapToInt(Integer::intValue).sum();

        Map<String, List<Integer>> map = nums.stream()
                .collect(Collectors.groupingBy(x -> (x % 2 == 0) ? "EVEN" : "ODD", HashMap::new, Collectors.toList()));

        System.out.println(map);
    }
}
