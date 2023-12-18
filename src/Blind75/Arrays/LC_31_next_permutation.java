package Blind75.Arrays;

import java.util.*;

public class LC_31_next_permutation {

    private void reverse(int[] arr, int start,int end){
        while(start<=end){
            int temp=arr[start];
         temp= arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private int[] permutation(int[] arr){
        int index =-1;
        int[] res = new int[3];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;
            }
        }
        if(index==-1){
            reverse(arr, 0, arr.length-1);
        }

        for(int i=arr.length-1;i>=index;i--){
            if(arr[i]>arr[index]){
                int temp=arr[i];
                temp= arr[i];
                arr[i]= arr[index];
                arr[index] = temp;
                break;
            }
        }
        reverse(arr, index+1, arr.length-1);
    return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        LC_31_next_permutation obj = new LC_31_next_permutation();
        System.out.println(Arrays.toString(obj.permutation(arr)));
    }
}
