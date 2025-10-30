package dynamicProgramming.knapsackVariations;

public class CountSubsetSum {
    public static void main(String[] args) {

        //Knapsack Problem -> (t[n+1][w+1])
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;

        int countSubsets = countSubsetSum(arr, sum, n);

        System.out.println("Subset Count = " + countSubsets);

    }

    public static int countSubsetSum(int[] arr, int sum, int n){
        int[][] subset = new int[n+1][sum+1];
        subset[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
//                if(i == 0){
//                    subset[i][j] = 1;
//                }else if(j == 0){
//                    subset[i][j] = 0;
//                }
                if(arr[i-1] <= j){
                    subset[i][j] += subset[i-1][j - arr[i-1]] + subset[i-1][j];
                }else{
                    subset[i][j] += subset[i-1][j];
                }
            }
        }
        return subset[n][sum];
    }


}
