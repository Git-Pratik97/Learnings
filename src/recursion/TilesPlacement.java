package recursion;

public class TilesPlacement {
    public static int placeTiles(int n, int m){
        if(m == n){
            return 2;
        }
        if(n < m){
            return 1;
        }
        int vertically = placeTiles(n - m, m);
        int horizontally = placeTiles(n - 1, m);

        return vertically + horizontally;
    }

    public static void main(String[] args) {
        int m = 2, n = 4;

        int tiles = placeTiles(n, m);

        System.out.println("Number of ways tiles can be arranged : " + tiles);
    }
}
