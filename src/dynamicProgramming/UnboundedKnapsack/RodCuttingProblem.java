package dynamicProgramming.UnboundedKnapsack;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 18, 17, 17, 20};
        int len = 8;

        int max_price = maxCutting(lengths, prices, len, lengths.length);

        System.out.println("Max_Price so far - " + max_price);
    }

    public static int maxCutting(int[] arr, int[] prices, int len, int n){
        n = arr.length;
        int[][] matrix = new int[n+1][len+1];

        matrix[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= len; j++){
                if(arr[i-1] <= j){
                    matrix[i][j] = Math.max(prices[i-1] + matrix[i][j - arr[i-1]], matrix[i-1][j]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix[n][len];
    }


}
