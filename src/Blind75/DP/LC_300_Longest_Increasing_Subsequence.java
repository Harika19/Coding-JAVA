package Blind75.DP;

import java.util.Arrays;

public class LC_300_Longest_Increasing_Subsequence {
    private int Subsequence(int[] arr, int ind, int prev, int[][] dp){
        if(ind == arr.length) return 0;
        int notPick = 0+ Subsequence(arr, ind+1, prev, dp);
        int pick =0;
        if(prev==-1 || arr[prev]< arr[ind]){
            pick = 1+ Subsequence(arr, ind+1, ind, dp);
        }
        dp[ind][prev+1] = Math.max(pick, notPick);
        return dp[ind][prev + 1];
    }
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LC_300_Longest_Increasing_Subsequence obj = new LC_300_Longest_Increasing_Subsequence();
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(obj.Subsequence(nums, 0, -1, dp));
    }
}
