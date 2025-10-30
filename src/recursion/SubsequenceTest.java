package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceTest {
    public static List <String> list = new ArrayList<>();

    public static void subsequence(String str, int index, String newString){
        if(index == str.length()){
            System.out.println("SubSequence is :" + newString);
            list.add(newString);
            return;
        }
        char c = str.charAt(index);

        //Without Adding the character
        subsequence(str, index + 1, newString);

        //With Addtion of Character
        subsequence(str, index + 1, newString + c);
    }

    public static void main(String[] args) {
        String str = "abc";

        subsequence(str, 0, "");

        System.out.println(list);
    }
}
