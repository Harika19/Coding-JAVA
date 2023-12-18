package Blind75;

import java.util.HashMap;

public class Minimum_Window_Substring {
    private String logic(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i: t.toCharArray()){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int c= map.size();
        int l=0,r=0;
        int len = Integer.MAX_VALUE;
        String window = "";
        while(r<s.length()){
            char ele = s.charAt(r);
            if(map.containsKey((ele))){
                map.put(ele, map.get(ele)-1);
                if(map.get(ele)==0) c--;
            }
            r++;
            while(c==0){
                 if(r-l<len){
                    len = r-l;
                     window=  s.substring(l,r);
                }
                 char temp = s.charAt(l);
                if(map.containsKey((temp))){
                    map.put(temp, map.get(temp)+1);
                    if(map.get(temp)>0) c++;
                }
                l++;
            }
        }
        return  window;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Minimum_Window_Substring obj = new Minimum_Window_Substring();
        System.out.println(obj.logic(s, t));

    }
}
