package Blind75.Strings;

import java.util.HashMap;

public class LC_76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        int len = Integer.MAX_VALUE;
        String str = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        System.out.println(map);
        int c=map.size();
        while (r<s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.get(s.charAt(r))-1);
                if(map.get(s.charAt(r))==0) c--;
            }
            r++;
            while (c==0){
                if(r-l<len){
                    len = r-l;
                     str = s.substring(l,r);
                }
                char left = s.charAt(l);
                if(map.containsKey(s.charAt(l))){
                    map.put(left, map.get(left)+1);
                    if(map.get(left)>0) c+=1;
                }
                l++;
            }
        }
        return str;

    }


    public static void main(String[] args) {
        LC_76_Minimum_Window_Substring obj = new LC_76_Minimum_Window_Substring();
        String s ="ADOBECODEBANC";
        String t ="ABC";
        System.out.println(obj.minWindow(s,t));
    }
}
