package Blind75.Arrays;

import java.util.Arrays;

public class LC_283_moveZero {
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp;
    }
    public int[] moveZeroes(int[] nums) {
        int low=0,high=low+1;
        while(high<=nums.length-1){
            if(nums[low]!=0){
                low++;high++;
            }else{
                if(nums[high]!=0){
                    swap(nums,low,high);
                    low++;
                }else{
                    high++;
                }
            }
        }
        return  nums;
    }
    public static void main(String[] args) {
        LC_283_moveZero obj = new LC_283_moveZero();
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(obj.moveZeroes(nums)));
    }
}
