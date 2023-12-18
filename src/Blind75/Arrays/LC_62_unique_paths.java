package Blind75.Arrays;


public class LC_62_unique_paths {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int R = m-1;
        int res=1;
        for(int i=1;i<=R;i++){
            res = (res * (N-R+i))/i;
        }
        return res;
    }
    public static void main(String[] args) {
        int m=2;
        int n=3;
        LC_62_unique_paths obj = new LC_62_unique_paths();
        System.out.println(obj.uniquePaths(m,n));
    }



}
