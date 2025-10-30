package recursion;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumberSubset {
    public static void findSubset(int n, List<Integer> list){
        if(n == 0){
            if(!list.isEmpty()){
                System.out.println(list);
            }
            return;
        }
        //Adding to the list
        findSubset(n-1, list);
        list.add(n);

        //Without Adding to subset
        findSubset(n-1, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> subset = new ArrayList<>();
        findSubset(n, subset);
    }
}
