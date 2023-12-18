package Blind75.DP;

import java.util.Arrays;

public class LC_198_house_robber {
    private int robber(int[] nums, int ind, int[] dp){
        if(ind < 0) return 0;
        if(dp[ind]!=-1) return  dp[ind];
        if(ind==0) return  nums[ind];

        int notPick = 0+ robber(nums, ind-1, dp);
        int pick = nums[ind] + robber(nums, ind-2, dp);
        return dp[ind] = Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        LC_198_house_robber obj = new LC_198_house_robber();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        System.out.println(obj.robber(nums, nums.length-1, dp));
    }
}
