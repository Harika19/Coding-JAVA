package Blind75.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LC_238_product_of_array_itself {
    public int[] productExceptSelf(int[] nums) {
        int c=0, prod=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }else{
                prod*= nums[i];
            }
        }

        if(c>1){
            for(int i=0;i<nums.length;i++){
                nums[i]=0;
            }
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            if(c==1){
                if(nums[i]==0){
                    nums[i]=prod;
                }else{
                    nums[i]=0;
                }
            }else{
                nums[i]=prod/nums[i];
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        LC_238_product_of_array_itself obj = new LC_238_product_of_array_itself();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for(int i=0;i<size;i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));

    }
}
