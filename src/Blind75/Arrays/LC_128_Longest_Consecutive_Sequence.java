package Blind75.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class LC_128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int c=0;
        int maxi = Integer.MIN_VALUE;
        for (int num: set){ // remember for optimization check in set not in array
            if(!set.contains(num-1)){
                c=1;
                int temp = num;
                while (set.contains(temp+1)){
                    c++;
                    temp++;
                }
                maxi = Math.max(maxi, c);
            }
        }
        return maxi;

    }
    public static void main(String[] args) {
        LC_128_Longest_Consecutive_Sequence obj = new LC_128_Longest_Consecutive_Sequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(obj.longestConsecutive(nums));
    }
}
