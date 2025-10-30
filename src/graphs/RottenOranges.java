package graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottenOranges {
    public static void main(String[] args) {

        int[][] grid = {{2,1,1},
                {1,1,0},
                {0,1,1}};

        int time = rottingOranges(grid);

        System.out.println("Time passed = " + time);

    }

    /*
    * [[2,1,1],
    *  [1,1,0],
    *  [0,1,1]]
    *
    * [[2,1,1],
    *  [0,1,1],
    *  [1,0,1]]
    */

    public static boolean isSafe(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public static int rottingOranges(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        boolean changed;

        int timePassed = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0, -1}};

        while(true){
            changed = false;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                   if(grid[i][j] == timePassed + 2){
                       for(int[] dir : directions){
                           int x = i + dir[0];
                           int y = j + dir[1];
                           if(isSafe(x, y, row, col) && grid[x][y] == 1){

                               grid[x][y] = grid[i][j] + 1;
//                               grid[x][y] = 2;
//                               timePassed++;
                               changed = true;
                           }
                       }
                   }
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            if(!changed){
                break;
            }
            timePassed++;

        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return timePassed;
    }
}
