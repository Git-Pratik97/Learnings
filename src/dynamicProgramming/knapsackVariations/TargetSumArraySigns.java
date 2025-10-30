package dynamicProgramming.knapsackVariations;

public class TargetSumArraySigns {
    public static void main(String[] args) {
        //Count the number of subsets with given sum when signs(-, +) are assigned to the elements
        int[] arr = {1, 1, 2, 4};
        int sum = 1;

        int count = countSubsetsDifference(arr, arr.length, sum);

        System.out.println("Subsets with given requirement - " + count);
    }

    public static int countSubsetsDifference(int[] arr, int n, int diff){
        int total = 0;
        n = arr.length;
        for(int e: arr){
            total += e;
        }

        int sum = (total + diff)/2;

        int[][] subs = new int[n+1][sum+1];
        subs[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(arr[i-1] <= j){
                    subs[i][j] += subs[i-1][j - arr[i-1]] + subs[i-1][j];
                }else{
                    subs[i][j] = subs[i-1][j];
                }
            }
        }
        return subs[n][sum];
    }
}
