package Sorting;

public class InsertionSortTest {
    public static void main(String[] args) {
//        Insertion Sort O(n^2)
        int arr[] = {7, 5, 23, 45, 76, 4, 8, 10, 12};

        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        printArray(arr);
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
