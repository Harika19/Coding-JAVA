package Blind75.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubsequenceWithSumK {

    public int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];

            PriorityQueue<Integer> mQ = new PriorityQueue<>((a, b) -> (nums[a]-nums[b]));
            for(int i = 0; i< nums.length; i++) {
                mQ.offer(i);
                if(mQ.size()>k){
                    mQ.poll();
                }
            }
            PriorityQueue<Integer> resQ = new PriorityQueue<>((a,b) -> (a-b));
            resQ.addAll(mQ);
            for(int i = 0; i < k; i++) {
                res[i] = nums[resQ.poll()];
            }

            return res;

    }
    public static void main(String[] args) {
        MaxSubsequenceWithSumK obj = new MaxSubsequenceWithSumK();
        int[] nums ={-1,-2,3,4};
        int k=3;
        System.out.println(Arrays.toString(obj.maxSubsequence(nums, k)));
    }
}
