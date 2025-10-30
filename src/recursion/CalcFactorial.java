package recursion;

public class CalcFactorial {
    public static int calcFact(int n){
        if(n == 1 || n ==0){
            return 1;
        }
        System.out.println("Number is : " + n);
        return n*calcFact(n-1);
    }

    public static void main(String[] args) {
        int k = 5;
        int factorial = calcFact(k);

        System.out.println("Factorial of " + k + " : " + factorial);
    }
}
