package Blind75.Arrays;

class LC_152_Max_Product_Subarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int temp;
        for(int i=1;i<nums.length;i++){
            temp = max;
            System.out.println("temp"+ temp);
            max = Math.max(nums[i], Math.max(nums[i]*min, nums[i]*max));
            System.out.println("max"+ max);
            min = Math.min(nums[i], Math.min(nums[i]*min, nums[i]*temp));
            System.out.println("min"+ min);
            res = Math.max(res, max);
            System.out.println("res"+ res);
        }
        return res;
    }

    public static void main(String[] args) {
        LC_152_Max_Product_Subarray obj = new LC_152_Max_Product_Subarray();
        int[] nums = {2,3,-2,4, -3};
        System.out.println(obj.maxProduct(nums));
    }
}