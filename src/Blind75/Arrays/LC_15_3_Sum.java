package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15_3_Sum {
    public ArrayList<List<Integer>> sum(int[] arr){
        Arrays.sort(arr);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k = arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==0){
                    res.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    while(arr[j]==arr[j+1]) j++;
                    while(k!= arr.length-1 && arr[k]==arr[k+1]) k--;
                    j++;
                    k--;

                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        LC_15_3_Sum obj = new LC_15_3_Sum();
        System.out.println(obj.sum(arr));
    }
}


