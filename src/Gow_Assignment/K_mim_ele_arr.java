

package Gow_Assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_mim_ele_arr {
    private int min_ele_1(int[] arr, int highest_ele){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
        }
//        while (!queue.isEmpty()) {
//            System.out.print(queue.poll() + " ");
//        }
        int res =-1;
        for(int i=0;i<highest_ele;i++){
            res = queue.poll();
        }
        return  res;
    }

    public static void main(String[] args) {
        K_mim_ele_arr obj = new K_mim_ele_arr();
        int[] arr = { 2,6,1,8,3,9};
        int highest_ele = 5;
        System.out.println(obj.min_ele_1(arr, highest_ele));
    }
}

