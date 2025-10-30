package dynamicProgramming.knapsackVariations;

public class SubsetSumProblem {
    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 8, 10};
        boolean ans = subsetSum(arr, 11);

        System.out.println(ans);

    }

    public static boolean subsetSum(int[] arr, int sum){
        boolean[][] dp = new boolean[arr.length+1][sum + 1];
        dp[0][0] = true;
        for(int i = 1; i <= arr.length; i++){
            for(int j = 0; j <= sum; j++){
//                if(i == 0){
//                    dp[i][j] = true;
//                }
//                else if(j == 0){
//                    dp[i][j] = false;
//                }
                if(arr[i-1] <= j){
                    dp[i][j] = (dp[i-1][j - arr[i-1]]) || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
