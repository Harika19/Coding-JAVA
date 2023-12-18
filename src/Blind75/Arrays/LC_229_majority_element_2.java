package Blind75.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC_229_majority_element_2 {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0, ele1 = 0;
        int c2=0, ele2 = 0;
        for(int i=0;i<nums.length;i++){
            if(c1==0  && ele2 != nums[i]){
                c1=1;
                ele1 = nums[i];
            }else if(c2==0 && ele1 !=nums[i]){
                c2=1;
                ele2 = nums[i];
            }else if(ele1 ==nums[i]){
                c1++;
            }else if(ele2==nums[i]){
                c2++;
            } else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length/3;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                c1++;
            } else if (nums[i]==ele2) {
                c2++;
            }
        }
        if(c1>n){
            res.add(ele1);
        }
        if(c2>n){
            res.add(ele2);
        }
        return res;

    }
    public static void main(String[] args) {
        LC_229_majority_element_2 obj = new LC_229_majority_element_2();
        int[] nums= {3,2,3};
        System.out.println(obj.majorityElement(nums));
    }
}
