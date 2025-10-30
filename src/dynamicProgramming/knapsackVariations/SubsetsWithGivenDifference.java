package dynamicProgramming.knapsackVariations;

public class SubsetsWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        int count = countSubsetDifference(arr, diff, arr.length);

        System.out.println("Count of subset is - " + count);
    }

    public static int countSubsetDifference(int[] arr, int diff, int n){
        int total = 0;
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }

        int sum = (diff + total)/2;
        n = arr.length;

        int[][] subs = new int[n+1][sum + 1];
        subs[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
//                if(i == 0){
//                    subs[i][j] = 1;
//                }
//                else if(j == 0){
//                    subs[i][j] = 0;
//                }
                if(arr[i-1] <= j){
                    subs[i][j] += subs[i-1][j - arr[i-1]] + subs[i-1][j];
                }else{
                    subs[i][j] += subs[i-1][j];
                }
            }
        }
        return subs[n][sum];
    }
}
