package Blind75.Strings;

import java.util.HashMap;

public class LC_3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int c=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r<s.length()){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r))+1);
            }
            c= Math.max(c, r-l+1);
            map.put(s.charAt(r), r);
            r++;
        }
        return c;
    }
    public static void main(String[] args) {
        LC_3_Longest_Substring_Without_Repeating_Characters obj = new LC_3_Longest_Substring_Without_Repeating_Characters();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
