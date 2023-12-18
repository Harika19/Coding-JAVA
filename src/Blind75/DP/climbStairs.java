package Blind75.DP;

import java.util.Arrays;

public class climbStairs {
    private int logic(int n){
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        System.out.println(arr);
        arr[0]=1;
        arr[1]=1;
        for (int i=2;i<arr.length;i++){
            arr[i] = arr[i-1]+ arr[i-2];
        }
        return arr[n];
    }
    public static void main(String[] args) {
        int n = 3;
        climbStairs obj = new climbStairs();
        System.out.println(obj.logic(n));
    }
}
