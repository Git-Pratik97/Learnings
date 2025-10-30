package stream;

import java.util.*;
import java.util.stream.Collectors;

public class GroupOfAnagrams {
    public static void main(String[] args) {
        String[] s = {"pat", "tap", "pan", "nap", "team", "tree", "meat"};

        List<String> strs = Arrays.asList(s);

        Collection<List<String>> list =  strs.stream()
                .collect(Collectors.groupingBy(x -> Arrays.stream(x.split(""))
                        .sorted().collect(Collectors.toList())))
                .values();

        System.out.println(list);
    }
}
