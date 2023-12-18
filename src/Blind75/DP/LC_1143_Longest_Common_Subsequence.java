package Blind75.DP;

import java.util.Arrays;

public class LC_1143_Longest_Common_Subsequence {
    private int Subsequence(String text1, String text2,int ind1, int ind2, int[][] dp){
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return (dp[ind1][ind2] = 1 + Subsequence(text1, text2,ind1 - 1, ind2 - 1, dp));
        } else {
            return (dp[ind1][ind2] = Math.max(Subsequence(text1, text2,ind1, ind2 - 1, dp), Subsequence(text1, text2,ind1 - 1, ind2, dp)));
        }
    }
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LC_1143_Longest_Common_Subsequence obj = new LC_1143_Longest_Common_Subsequence();
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println(obj.Subsequence(text1, text2,text1.length() - 1, text2.length() - 1, dp));
    }
}
