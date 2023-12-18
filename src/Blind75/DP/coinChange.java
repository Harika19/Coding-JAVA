package Blind75.DP;

import java.util.Arrays;

public class coinChange {
    private int logic(int[] coins, int amount){
       int[] dp = new int[amount+1];
       dp[0]=0;
       for (int i=1;i<=amount;i++){
           dp[i]=amount+1;
           for (int c: coins){
               if(i-c>=0) {
                   dp[i] = Math.min(dp[i], 1 + dp[i - c]);
               }
           }
       }
       return dp[amount] == (amount+1) ? -1: dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        coinChange obj = new coinChange();
        System.out.println(obj.logic(coins, amount));
    }
}
