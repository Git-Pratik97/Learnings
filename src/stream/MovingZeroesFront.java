package stream;

import java.util.*;
import java.util.stream.Collectors;

public class MovingZeroesFront {
    public static void main(String[] args) {
        int[] arr = {5, 0, 1, 0, 8, 0};

        List<Integer> list = Arrays.stream(arr).boxed().toList();

        //Approach 1
        List<Integer> zeroes = list.stream()
                .filter(x -> x == 0)
                .toList();

        List<Integer> nonZeroes = list.stream()
                .filter(x -> x != 0)
                .toList();

        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(zeroes);
        finalList.addAll(nonZeroes);

//        System.out.println(finalList.toString());


        //Approach 2
        Map<Boolean, List<Integer>> partitionMap = list.stream().collect(Collectors.partitioningBy(x -> x != 0));

        Collection<List<Integer>> collectionView = partitionMap.values();

        List<Integer> finals = collectionView.stream().flatMap(x -> x.stream()).toList();
        System.out.println(finals);
    }
}
