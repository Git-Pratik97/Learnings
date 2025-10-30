package recursion;

public class CountPathsMaze {
    public static void main(String[] args) {
        int m = 3, n = 3;

        int totalPaths = countPaths(0, 0, m, n);

        System.out.println("Total Paths in the maze : " + totalPaths);
    }

    public static int countPaths(int i, int j, int m, int n){
        if(i == m || j == n){
            return 0;
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        int downPath = countPaths(i+1, j, m, n);
        System.out.println("Moving Horizontally from " + i + " to " + (i+1));
        int rightPath = countPaths(i, j+1, m, n);
        System.out.println("Moving Vertically from " + j + " to " + (j+1));

        return downPath + rightPath;
    }
}
