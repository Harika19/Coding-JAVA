package Blind75.Interval;

import java.util.Arrays;

public class LC_435_NoN_overlapping_Intervals {
    private int noN_overlappingInterval(int[][] intervals){
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
    int prev =0;
    int c=0;
    for (int i=1;i<intervals.length;i++){
        if(intervals[prev][1]>intervals[i][0]){
            c++;
        }else{
            prev=i;
        }
    }
    return  c;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 2},{2, 3}, { 3,4}, {1,3}};
        LC_435_NoN_overlapping_Intervals obj = new LC_435_NoN_overlapping_Intervals();
        int result = obj.noN_overlappingInterval(intervals);
        System.out.println(result);
    }
}
