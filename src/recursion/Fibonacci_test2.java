package recursion;

public class Fibonacci_test2 {
    public static void main(String[] args) {
        System.out.println(fibona(6));
    }

    public static int fibona(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fibona(n-1) + fibona(n-2);
    }
}
