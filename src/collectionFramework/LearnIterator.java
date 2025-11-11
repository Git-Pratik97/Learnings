package collectionFramework;

import java.util.*;

public class LearnIterator {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("Apple", "Ball", "Cat"));

        //Iterate using enhanced for loop
        System.out.println("using Enhanced For loop");
        for(String ele: arr){
            System.out.println(ele);
        }
        System.out.println();

        //Iterate using ForEach Iterator
        System.out.println("Using For-Each Loop");
        arr.forEach((ele) -> System.out.println(ele));
        System.out.println();

        System.out.println("Using Iterator...");
        //Iterate using an Iterator
        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

        Map<String, Integer> map = new HashMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){

        }

        }
}
