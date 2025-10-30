package Sorting;

public class SelectionSortTest {
    public static void main(String[] args) {
//        Selection Sort -> Time Complexity = O(n^2)
        int arr[] = {7, 5, 23, 45, 76, 4, 8, 10, 12};

        for(int i = 0; i < arr.length; i++){
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[smallest] > arr[j]){
                    int temp = arr[smallest];
                    arr[smallest] = arr[j];
                    arr[j] = temp;
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
