package Blind75.Arrays;

public class LC_136_single_element {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans= ans^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_136_single_element obj = new LC_136_single_element();
        int[] nums= {4,1,2,1,2};
        System.out.println(obj.singleNumber(nums));
    }
}
