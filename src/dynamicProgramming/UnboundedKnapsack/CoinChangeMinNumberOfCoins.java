package dynamicProgramming.UnboundedKnapsack;

public class CoinChangeMinNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {1};
        int sum = 0;

        int minCoins = miniMumCoins(coins, coins.length, sum);

        System.out.println("Minimum Coins - " + minCoins);
//        System.out.println(Integer.MAX_VALUE + 1);
    }

    public static int miniMumCoins(int[] arr, int n, int sum){
        n = arr.length;
        int[][] matrix = new int[n+1][sum+1];

        for(int j = 1; j <= n; j++){
            matrix[j][0] = 0;
        }

        for(int i = 0; i <= sum; i++){
            matrix[0][i] = Integer.MAX_VALUE - 1;
            if(i % arr[0] == 0){
                matrix[1][i] = i/arr[0];
            }
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i - 1] <= j){
                    matrix[i][j] = Math.min(matrix[i][j - arr[i-1]] + 1, matrix[i-1][j]);
                }
                else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        return matrix[n][sum];
    }
}
