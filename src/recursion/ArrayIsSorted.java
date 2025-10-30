package recursion;

public class ArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 1, 2, 4, 5, 12, 1};
        int n = arr.length;

        System.out.println("Is True ? : " + isSorted(arr, n));
    }

    public static boolean isSorted(int[] arr, int n) {
        if(n == 0 || n == 1){
            return true;
        }

        return arr[n-1] >= arr[n-2] && isSorted(arr, n-1);
    }
}
