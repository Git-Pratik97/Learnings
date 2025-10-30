package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySubsetRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();

        printSubset(arr, 0, new ArrayList<>(), res);

        for(List<Integer> list : res){
            System.out.println(list);
        }
    }

    public static void printSubset(int[] arr, int idx, List<Integer> ans, List<List<Integer>> all_subsets){
        if(idx == arr.length){
            all_subsets.add(new ArrayList<>(ans));
            for(int i = 0; i < ans.size(); i++){
                System.out.print(ans.get(i) + " ");
            }
            System.out.println(" ");
            return;
        }

        ans.add(arr[idx]);
        printSubset(arr, idx + 1, ans, all_subsets);

        ans.remove(ans.size() - 1);
        printSubset(arr, idx + 1, ans, all_subsets);
    }
}

