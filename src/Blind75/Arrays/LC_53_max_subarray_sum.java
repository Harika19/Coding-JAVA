package Blind75.Arrays;

public class LC_53_max_subarray_sum {

    public int maxSubArray(int[] nums) {
        int sum =0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            maxi= Math.max(sum, maxi);
            if(sum<0){
                sum =0;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        LC_53_max_subarray_sum obj = new LC_53_max_subarray_sum();
        System.out.println(obj.maxSubArray(nums));

    }
}
