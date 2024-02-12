package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class test {
    public ArrayList<List<Integer>> productExceptSelf(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;;
            int j=i+1;
            int k= nums.length-1;
            System.out.println(i +""+ j +""+  k);
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(nums[j]==nums[j+1]) j++;
                    while (nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }else if(sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test obj = new test();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println((obj.productExceptSelf(nums)));
    }
}