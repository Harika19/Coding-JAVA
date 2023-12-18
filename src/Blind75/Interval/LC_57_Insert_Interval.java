package Blind75.Interval;

import Blind75.DP.LC_62_uniquePaths1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_57_Insert_Interval {
    private int[][] insertInterval(int[][] intervals, int[] newInterval){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        pq.addAll(Arrays.asList(intervals));
        pq.add(newInterval);
        System.out.println("1111"+ pq);
        while (!pq.isEmpty()){
            int[] mergeInt = pq.poll();
            if(!res.isEmpty() && res.get(res.size()-1)[1]>= mergeInt[0]){
                res.get(res.size()-1)[1]= Math.max(res.get(res.size()-1)[1], mergeInt[1]);
            }else{
                res.add(mergeInt);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        LC_57_Insert_Interval obj = new LC_57_Insert_Interval();
        int[][] result = obj.insertInterval(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }
}
