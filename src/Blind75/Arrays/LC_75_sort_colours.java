package Blind75.Arrays;

import java.util.Arrays;

public class LC_75_sort_colours {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private int[] sort_colour(int[] nums) {
        int l = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, l, mid);
                l++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        LC_75_sort_colours obj = new LC_75_sort_colours();
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(obj.sort_colour(nums)));
    }
}
