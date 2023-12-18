package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoPointer(int[] nums,int  target){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(i, nums[i]);
           // list.get(i).equals(1);
        }
        Arrays.sort(nums);
        int start = 0;
        int last = nums.length-1;
        while(start<last){
            int sum = nums[start]+nums[last];
            if(sum == target){
                return new int[] {list.indexOf(nums[start]), list.lastIndexOf(nums[last])};
            }else if(sum>target){
                last--;
            }else{
                start++;
            }
        }
        return new int[]{};
    }
    public int[] maplogic(int[] nums,int  target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int first = nums[i];
            int second = target - first;
            if(map.containsKey(second)){
                return new int[] {i, map.get(second)};
            }else {
                map.put(first, i);
            }
        }

        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(obj.maplogic(nums, target)));
        System.out.println(Arrays.toString(obj.twoPointer(nums, target)));
    }
}
