package randomTests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTests {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj","Kamal","Mohan", "Pratik", "Suraj", "Andy", "Candy");

//        Collections.sort(names, (s1, s2) -> Character.compare(s1.charAt(s1.length()/2), s2.charAt(s2.length()/2)));
        Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        names.forEach(name -> System.out.println(name));
//        names.forEach(a -> {
//            if(a.startsWith("P")){
//                System.out.println("Starts with P");
//            }
//            else{
//                System.out.println("Doesn't start with P");
//            }
//            System.out.println("Testing....");
//        });
    }
}
