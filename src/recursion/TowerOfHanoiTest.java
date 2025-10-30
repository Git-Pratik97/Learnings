package recursion;

public class TowerOfHanoiTest {
    private static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, "Source", "Helper", "Dest");
        System.out.println("Count is - " + count);
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Transfer disk from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer disk from " + src + " to " + dest);
        count++;
        towerOfHanoi(n-1, helper, src, dest);
//        System.out.println("Transfer disk from " + src + " to " + dest);
        count++;

    }
}
