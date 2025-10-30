package recursion;

public class Fibonacci_Recursion {
    public static void printFib(int a, int b, int n){
        if(n == 0){
            return;
        }

        int c = a + b;
        System.out.print(c + " ");
        printFib(b, c, n-1);
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        System.out.print(0 + " ");
        System.out.print(1 + " ");
        printFib(a, b, 10);
    }
}
