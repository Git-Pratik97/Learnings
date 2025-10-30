package Sorting;

public class BubbleSortTest {
    public static void main(String[] args) {
//        Bubble Sort -> Time Complexity = O(n^2)
        int arr[] = {7, 5, 23, 45, 76, 4, 8, 10, 12};

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
