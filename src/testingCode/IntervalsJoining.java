package testingCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IntervalsJoining {
    public static void main(String[] args) {
//        intervals = [[1,3],[6,9]], newInterval = [2,5]
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] ans = intervalInsert(intervals, newInterval);

        for(int[] nums : ans){
            if(nums != null){
                System.out.println(nums[0] + " " + nums[1]);
            }

        }
    }

    public static int[][] intervalInsert(int[][] intervals, int[] newInterval){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < intervals.length; i++){
            pq.offer(intervals[i]);
        }
        pq.offer(newInterval);

        int[][] ans = new int[pq.size()][];
        int i = 0;
        int[] prev = pq.poll();
        while(!pq.isEmpty()){
           int[] curr = pq.poll();
           System.out.println("Prev - " + prev[0] + " " + prev[1]
                        + " Curr - " + curr[0] + " " + curr[1]);
           if(curr[0] <= prev[1]){
               ans[i] = new int[]{prev[0], curr[1]};
               prev = ans[i];
               System.out.println("Ans - " + ans[i][0] + " " + ans[i][1]);
           }
           else{
               ans[i] = curr;
               prev = curr;
               System.out.println("Ans - " + ans[i][0] + " " + ans[i][1]);
           }
           i++;

        }
//        ans[i] = prev;

        return ans;
    }
}
