package recursion;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUniqueSubsetRecursive {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = {1, 2, 2};
        findUniqueSubset(arr, 0, new ArrayList<>(), res);

        for(List<Integer> list : res){
            System.out.println(list);
        }
    }

    public static void findUniqueSubset(int[] arr, int idx, List<Integer> ans, List<List<Integer>> res){
        Arrays.sort(arr);

        if(idx == arr.length){

            res.add(new ArrayList<>(ans));
//            for(int i = 0; i < ans.size(); i++){
//                System.out.print(ans.get(i) + " ");
//            }
            System.out.println(" ");
            return;
        }
        ans.add(arr[idx]);
        findUniqueSubset(arr, idx + 1, ans, res);

        ans.remove(ans.size() - 1);
        int i = idx + 1;
        while(i < arr.length && arr[i] == arr[i-1]){
            i++;
        }

        findUniqueSubset(arr, i, ans, res);
    }
}
