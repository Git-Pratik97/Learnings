package recursion;

public class Recursion_print {
    public static void main(String[] args) {
        int n = 1;
//        printNum(n);

        printSum(1, 5, 0);
    }

    public static void printNum(int n){
        if(n == 6){
            return;
        }
        System.out.println(n + " ");
        printNum(n+1);
    }

    public static void printSum(int i, int n, int sum){
        if(i == n){
            sum += i;
            System.out.println(sum);
            return;
        }
        printSum(i+1, n, sum+=i);

    }
}
