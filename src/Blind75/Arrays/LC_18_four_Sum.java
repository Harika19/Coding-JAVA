package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_18_four_Sum {

    private List<List<Integer>> sum(int[] arr, int target){
        Arrays.sort(arr); // ********* sort the array
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<arr.length;j++){
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                int k=j+1;
                int n = arr.length-1;
                while (k<n){
                    int sum = arr[i]+arr[j]+arr[k]+arr[n];
                    if(sum ==target){
                        res.add(Arrays.asList(arr[i],arr[j],arr[k],arr[n]));
                        while (k != arr.length-1 && arr[k]==arr[k+1]) k++;
                        while (n != arr.length-1 && arr[n]==arr[n+1]) n--;
                        k++;
                        n--;
                    }else if(sum<target){
                        k++;
                    }else{
                        n--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        LC_18_four_Sum obj = new LC_18_four_Sum();
        System.out.println(obj.sum(arr, target));
    }
}
