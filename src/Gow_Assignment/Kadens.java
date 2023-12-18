package Gow_Assignment;

import java.util.Scanner;

public class Kadens {
    private int maxSubarraysum(int[] nums){
        int sum=0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxi = Math.max(maxi, sum);
            if (sum<0){
                sum=0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        //int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for(int i=0;i<size;i++){
            nums[i] = scanner.nextInt();
        }
        Kadens obj = new Kadens();
        System.out.println(obj.maxSubarraysum(nums));
    }
}
