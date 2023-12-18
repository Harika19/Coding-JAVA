package Blind75.Arrays;

import java.util.Arrays;

public class LC_189_rotateArra {
    public void reverse(int[] nums, int a, int b){
        while(a<=b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
    public int[] rotate(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        k = k%nums.length;
        if(nums.length>1) {
            int first = nums.length-k;
            reverse(nums, 0, first-1);
            reverse(nums, first, nums.length-1);
            reverse(nums, 0, nums.length-1);
        }
        return nums;
    }

    public static void main(String[] args) {
        LC_189_rotateArra obj = new LC_189_rotateArra();
        int[] nums = {1,2,3,4,5,6,7};
        int k =3;
        System.out.println(Arrays.toString(obj.rotate(nums,k)));
    }
}
