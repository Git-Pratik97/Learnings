package dynamicProgramming.knapsackVariations;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};

        int minDiff = minSumSubset(arr, 3);

        System.out.println(minDiff);
    }

    public static int minSumSubset(int[] arr, int n){
        int range = 0;
        for(int num : arr){
            range += num;
        }
        System.out.println("Range - " + range);
        boolean[][] dp = new boolean[n+1][range+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= range; j++){
//                if(i == 0){
//                    dp[i][j] = true;
//                }else if(j == 0){
//                    dp[i][j] = false;
//                }
                if(arr[i-1] <= j){
                    dp[i][j] = (dp[i-1][j - arr[i-1]]) || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i = 0; i <= range; i++){
            System.out.print(dp[n][i] + "\t");
        }
        int mn = Integer.MAX_VALUE;
        for(int i = 1; i <= range/2; i++){
            if(dp[n][i] == true){
//                System.out.print("Number - " + i +"\t");
                mn = Math.min(mn, range - 2*i);
            }
        }
        return mn;
    }
}
