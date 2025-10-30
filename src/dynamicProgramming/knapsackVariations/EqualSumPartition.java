package dynamicProgramming.knapsackVariations;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean isEqualSum = false;

        isEqualSum = equalSumPartition(arr, 22, arr.length);

        System.out.println(isEqualSum);


    }

    public static boolean equalSumPartition(int[] arr, int sum, int n){

        int arrSum = 0;
        for(int i = 0; i < arr.length; i++){
            arrSum += arr[i];
        }

        if(sum % 2 != 0) {
            return false;
        }
        boolean[][] subs = new boolean[arr.length + 1][arrSum/2 + 1];
        subs[0][0] = true;
        for(int i = 1; i <= arr.length; i++){
            for(int j = 0; j <= sum/2; j++){
//                if(i == 0){
//                    subs[i][j] = true;
//                }else if(j == 0){
//                    subs[i][j] = false;
//                }
                if(arr[i-1] <= j){
                    subs[i][j] = (subs[i-1][j - arr[i-1]]) || subs[i-1][j];
                }else{
                    subs[i][j] = subs[i-1][j];
                }
            }
        }
        return subs[arr.length][arrSum/2];
    }

}
