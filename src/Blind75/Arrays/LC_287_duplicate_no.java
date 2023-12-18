package Blind75.Arrays;

public class LC_287_duplicate_no {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return  slow;
    }
    public static void main(String[] args) {
        LC_287_duplicate_no obj = new LC_287_duplicate_no();
        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }
}
