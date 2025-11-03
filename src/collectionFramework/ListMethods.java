package collectionFramework;

import java.util.*;

public class ListMethods {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 8, 9, 10, 11, 12, 3, 6, 3, 7, 8);

//        Collections.sort(list);
//        Collections.reverse(list);
//        Collections.sort(list, Collections.reverseOrder());
//        Collections.shuffle(list);
//        Collections.rotate(list, 4);
        System.out.println(Collections.frequency(list, 3));

        System.out.println(Collections.binarySearch(list, 8));


        List<Integer> list2 = new ArrayList<>();
        Collections.copy(list2, list);
        System.out.println(list2);

    }
}
