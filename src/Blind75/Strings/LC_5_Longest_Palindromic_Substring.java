package Blind75.Strings;

public class LC_5_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        int len =1;
        int maxi_len=1;
        int start=0 ,last=0;
        // odd length
        for(int i=0;i<s.length()-1;i++){
            int l=i;
            int r=i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    l--;r++;
                }else{
                    break;
                }
            }
             len = r-l-1;
            if(len> maxi_len){
                 start = l+1;
                 last = r-1;
                maxi_len = len;
            }
        }
        // even length
        for(int i=0;i<s.length()-1;i++){
            int l=i,r=i+1;
            while(l>=0 && r<=s.length()){ // both can be clubbed to singe while statement
                if(s.charAt(l)==s.charAt(r)){
                    l--;r++;
                }else{
                    break;
                }
            }
             len = r-l-1;
            if(len> maxi_len){
                 start = l+1;
                 last = r-1;
                maxi_len = len;
            }
        }

        return s.substring(start, last+1);
    }
    public static void main(String[] args) {
        LC_5_Longest_Palindromic_Substring obj = new LC_5_Longest_Palindromic_Substring();
        String s = "babad";
        System.out.println(obj.longestPalindrome(s));
    }
}
