package Blind75;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    private int usingHashMap(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int c=0;
        int longest = 0;
        for (int i =0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                c=1;
                while (set.contains(nums[i]+1)){
                    c+=1;
                    nums[i]++;
                }
                longest = Math.max(longest, c);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence ob = new LongestConsecutiveSequence();
        int result = ob.usingHashMap(nums);
        System.out.println(" RESULT: "+result);
    }
}
