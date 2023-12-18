package Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.addAll(Arrays.asList(intervals));
        ArrayList<int[]> res = new ArrayList();
        while(!pq.isEmpty()){
            int[] ele = pq.poll();
            if(!res.isEmpty() && res.get(res.size()-1)[1]>=ele[0]){
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], ele[1]);
            }else{
                res.add(ele);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        LC_56_merge_intervals obj = new LC_56_merge_intervals();
        int[][] result = obj.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
