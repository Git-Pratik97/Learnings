package recursion;

public class PowerFunction {
    public static int calcPower(int x, int n){
        if(x == 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        return x * (int)Math.pow(x, n - 1);
    }

    public static int calcPowerLogN(int x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }

        if(n % 2 == 0){
            return calcPowerLogN(x, n/2) * calcPowerLogN(x, n/2);
        }
        else{
            return calcPowerLogN(x, n/2) * calcPowerLogN(x, n/2) * x;
        }
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        int num = calcPower(x, n);

        System.out.println("In O(n) time : " + num);

        int logn = calcPowerLogN(x, n);

        System.out.println("In O(logN) time : " + logn);
    }
}
