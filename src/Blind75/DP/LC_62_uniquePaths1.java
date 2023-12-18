package Blind75.DP;

import java.util.Arrays;

public class LC_62_uniquePaths1 {
    private int logic(int i, int j, int  m, int n, int[][] dp,int c){
        if(i>=m || j>=n) return  0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==m-1 && j==n-1) {
            c+=1;
            return c;
        }

        return dp[i][j] = logic(i+1, j, m, n,dp, c)+ logic(i, j+1, m, n,dp, c);
    }
    public static void main(String[] args) {
        int m =3;
        int n=7;
        int[][] dp = new int[m][n];
        for (int rows[]: dp){
            Arrays.fill(rows,-1);
        }
        int c=0;
        LC_62_uniquePaths1 obj = new LC_62_uniquePaths1();
        System.out.println(obj.logic(0,0, m,n, dp, c));
    }
}
