package Blind75.Arrays;

import java.util.HashMap;

public class LC_Largest_subarray_with_0_sum {
    private int subarray(int[] nums){
        HashMap<Integer, Integer>  map = new HashMap();
        int sum=0,maxi=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==0){
                maxi=i+1;
            }else if(map.containsKey(sum)){
                maxi = Math.max(maxi, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        LC_Largest_subarray_with_0_sum obj = new LC_Largest_subarray_with_0_sum();
        int[] nums = {15,-2,2,-8,1,7,10,23};
        System.out.println(obj.subarray(nums));
    }
}
