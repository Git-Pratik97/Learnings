package recursion;

public class SumOfNumbers {
    public static int sum_Num(int n){
        if(n == 1){
            return 1;
        }

        return n + sum_Num(n-1);
    }

    public static void main(String[] args) {
        int sum = sum_Num(5);

        System.out.println("Sum is: " + sum);
    }
}
