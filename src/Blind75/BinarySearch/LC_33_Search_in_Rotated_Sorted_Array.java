package Blind75.BinarySearch;

public class LC_33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target) return mid;
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        LC_33_Search_in_Rotated_Sorted_Array obj = new LC_33_Search_in_Rotated_Sorted_Array();
        int[] nums = {4,5,6,7,0,1,2};
        int target=0;
        System.out.println(obj.search(nums, target));
    }
}
