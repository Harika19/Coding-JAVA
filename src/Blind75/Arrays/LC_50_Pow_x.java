package Blind75.Arrays;

public class LC_50_Pow_x {
    private double myPow(double x, int n){
        double ans = 1;
        int p=n;
        if(n<0) p=p*-1;
       while(p!=0){
            if(p%2==0){
                p=p/2;
                x=x*x;
            }else{
                ans = ans*x;
                p-=1;
            }
        }

        return (n<0)? 1/ans : ans;
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n=10;
        LC_50_Pow_x obj = new LC_50_Pow_x();
        System.out.println(obj.myPow(x,n));
    }
}
