package dynamicProgramming.knapsackVariations;

// Eliminating recursion and repeatations
public class KnapsackProblemTopDown {
    public static void main(String[] args) {
        int[] weights = {3, 4, 2, 1};
        int[] values = {1, 4, 5, 7};
        int w = 7;

        System.out.println("Max Profit = " + knapsackDPTopDown(w, weights, values, values.length));

    }

    public static int knapsackDPTopDown(int capacity, int[] weights, int[] values, int n){
        int i, j;
        int[][] matrix = new int[n+1][capacity + 1];

        matrix[0][0] = 0;
        //Creating sub-problems to fill in the dp matrix
        for(i = 1; i <= n; i++){
            //Every iteration has it's own capacity to start with and base condition
            for(j = 0; j <= capacity; j++){
//                if(i == 0 || j == 0){
//                    matrix[i][j] = 0;
//                }
                if(weights[i-1] <= j){
                    matrix[i][j] = Math.max(values[i-1] + matrix[i-1][j - weights[i-1]], matrix[i-1][j]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }
        return matrix[n][capacity];
    }

}
