package collectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetUnion {
    public static Set<Integer> getUnionSet(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        return unionSet;
    }

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,4));

        Set<Integer> set2 = new HashSet<>();
        Integer[] arr = {5,6,3};
        set2.addAll(Arrays.asList(arr));

        Set<Integer> unionSet = getUnionSet(set1, set2);

        System.out.println(unionSet);

    }
}
