package Blind75.Arrays;

public class LC_74_search_in_2D_matrix {
    private boolean search_2D(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int high = row*col-1;
        int low =0;
        while(low<=high){
            int mid = (low+high)/2;
            int row1= mid/col;
            int col1 = mid%col;
            if(matrix[row1][col1]==target){
                return true;
            }else if(matrix[row1][col1] < target){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC_74_search_in_2D_matrix obj = new LC_74_search_in_2D_matrix();
        int target = 3;
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(obj.search_2D(matrix, target));
    }
}
