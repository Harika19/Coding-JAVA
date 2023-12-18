package Gow_Assignment;
// only ascending order and ..rotated
public class Min_ele_rotated_sorted_array {
    private int min_ele(int[] nums){
        int left= 0;
        int right = nums.length-1;

        while (left<right){
            if(nums[left]<nums[right]) return nums[left];
            int mid = (left+right)/2;
            if(nums[right]<nums[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        Min_ele_rotated_sorted_array obj = new Min_ele_rotated_sorted_array();
        int nums[]= {3,4,5,1,2};
        System.out.println(obj.min_ele(nums));
    }
}
