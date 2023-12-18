package Blind75.Arrays;

import java.util.Arrays;

public class LC_48_rotate_matrix {
    private void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private int[][] rotate_matrix(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i=0;i<row;i++) {
            reverse(arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        LC_48_rotate_matrix obj = new LC_48_rotate_matrix();
        int[][] res = obj.rotate_matrix(arr);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}
