package recursion;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9};
        boolean elementFound = findElementRecursive(arr, 0, arr.length - 1, 7);

        System.out.println(elementFound);

    }

    public static boolean findElementRecursive(int[] arr, int start, int end, int target){
        if(start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (target < arr[mid]) {
                return findElementRecursive(arr, start, mid - 1, target);
            } else {
                return findElementRecursive(arr, mid + 1, end, target);
            }
        }else{
            return false;
        }

    }
}


