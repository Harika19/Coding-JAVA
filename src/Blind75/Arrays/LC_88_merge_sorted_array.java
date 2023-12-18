package Blind75.Arrays;

import java.util.Arrays;

public class LC_88_merge_sorted_array {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }
        public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 =  {2, 5, 6};
        int m = 3;
        int n=3;
        LC_88_merge_sorted_array obj = new LC_88_merge_sorted_array();
        System.out.println(Arrays.toString(obj.merge(arr1,m,arr2,n)));
    }
}
