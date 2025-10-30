package recursion;

public class CallGuests {
    public static int guests(int n){
        if(n <= 1){
            return 1;
        }

        int alone = guests(n-1);

        int pairs = (n-1) * guests(n - 2);

        return alone + pairs;
    }

    public static void main(String[] args) {
        int n = 4;

        int ans = guests(n);

        System.out.println("Number of ways to call guests : " + ans);
    }
}
