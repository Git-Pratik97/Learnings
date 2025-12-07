package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CobinationSum_1 {
    public static void combinationSum(int idx, int target, int[] arr, List<List<Integer>> ans, List<Integer> helper){
        //Check if index has reached to length of the array
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(helper));
            }
            return;
        }

        //When arr[idx] <= target which means the element has to be included
        if(arr[idx] <= target){
            helper.add(arr[idx]);
            combinationSum(idx, target - arr[idx], arr, ans, helper);
            helper.remove(helper.size() - 1);
        }

//        When we do not want to include the element and continue with next element
        combinationSum(idx + 1, target, arr, ans, helper);
    }

    public static List<List<Integer>> findCombinations(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(0, target, arr, ans, new ArrayList<>());

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};

        int target = 7;

        List<List<Integer>> ans = findCombinations(arr, target);

        System.out.println(ans);
    }
}
