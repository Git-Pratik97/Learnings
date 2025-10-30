package dynamicProgramming.UnboundedKnapsack;

public class CoinChangeNoOfWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;

        int ways = waysCoinsChange(coins, sum, coins.length);

        System.out.println("Ways of coins change - " + ways);
    }

    public static int waysCoinsChange(int[] arr, int sum, int n){
        n = arr.length;
        int[][] matrix = new int[n+1][sum+1];

        matrix[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(arr[i-1] <= j){
                    matrix[i][j] += matrix[i][j - arr[i-1]] + matrix[i-1][j];
                }
                else{
                    matrix[i][j] = matrix[i-1][j];
                    System.out.print(i + " - " + j + " ");
                }
            }
            System.out.println("");
        }
        return matrix[n][sum];
    }


}
