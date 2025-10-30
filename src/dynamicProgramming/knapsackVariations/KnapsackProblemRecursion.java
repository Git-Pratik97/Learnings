package dynamicProgramming.knapsackVariations;

public class KnapsackProblemRecursion {
    public static void main(String[] args) {
        int[] weights = {3, 4, 2, 1};
        int[] values = {1, 4, 5, 7};
        int w = 7;

        int max_profit = dp(weights, values, w, 4);
        System.out.println("Max_profit -> " + max_profit);
    }

    //Check and validate the return type of the question
    public static int dp(int[] wt, int[] vals, int w, int n){
        if(n == 0 || w == 0){ //Generate a base condition from the smallest valid input
            return 0;
        }
        int max_profit = 0;

        //Creating a choice diagram for Knapsack
        // 1. Case where the items weight is less than capacity
        if(wt[n-1] <= w){
            //If yes the again two choices
            //Whether to include
            int ifIncluded = vals[n-1] + dp(wt, vals, w - wt[n-1], n - 1);
            //Whether not to include
            int ifNotIncluded = dp(wt, vals, w, n -1);

            // Max Profit will be the maximum value among these two
            max_profit = Math.max(ifIncluded, ifNotIncluded);
            return max_profit;
        }
        // Else case is for when item exceeds the capacity (We are excluding the item that's why n - 1)
        else{
            return dp(wt, vals, w, n -1);
        }
    }
}
