package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_leader_in_array {
    public List<Integer> leader(int[] nums){
        ArrayList<Integer> arr = new ArrayList<>();
        int ele = nums[nums.length-1];
        arr.add(ele);
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>ele){
                arr.add(nums[i]);
                ele = nums[i];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        LC_leader_in_array obj = new LC_leader_in_array();
        int[] nums = {11,4, 7, 1, 0};
        System.out.println(obj.leader(nums));
    }
}
