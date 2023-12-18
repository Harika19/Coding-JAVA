package Gow_Assignment;

import java.util.Arrays;
import java.util.HashMap;

public class Two_sum {
    private int[] sum(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int first = arr[i];
            int second = target-first;
            if(map.containsKey(second)){
                return new int[]{i, map.get(second)};
            }else{
                map.put(first, i);
            }
        }
        return  new int[]{};
    }
    public static void main(String[] args) {
        int arr[] = {2,4,5,7};
        int target = 7;
        Two_sum obj = new Two_sum();
        System.out.println(Arrays.toString(obj.sum(arr, target)));
    }
}
