package Blind75.DP;

import java.util.HashMap;

public class LC_377_combinationSum4 {
    private int combination(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=1;i<=target;i++){
            map.put(i,0);
            for (int t :nums){
                if(map.containsKey(i-t)){
                    map.put(i, map.get(i)+ map.getOrDefault(i-t,0));
                }

            }
        }
        return map.get(target);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        LC_377_combinationSum4 obj = new LC_377_combinationSum4();
        System.out.println(obj.combination(nums, target));
    }
}
