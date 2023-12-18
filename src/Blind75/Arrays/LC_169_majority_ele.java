package Blind75.Arrays;

public class LC_169_majority_ele {
    public int majorityElement(int[] nums) {
        int c=0, ele=0;
        for(int i=0;i<nums.length;i++){
            if(c==0){
                c++;
                ele=nums[i];
            }else if(ele == nums[i]){
                c++;
            }else{
                c--;
            }
        }
        c=0;
        int n= nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(ele == nums[i]){
                c++;
            }
        }
        if(c>=n){
            return ele;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        LC_169_majority_ele obj = new LC_169_majority_ele();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(obj.majorityElement(nums));
    }
}
