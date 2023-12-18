package Blind75.Strings;

import java.util.HashMap;

public class LC_424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int freq=0;
        int l=0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            freq = Math.max(freq, map.get(s.charAt(i)));
            while((i-l+1 )- freq>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            maxi = Math.max(maxi, i-l+1);
        }
        return  maxi;
    }
    public static void main(String[] args) {
        LC_424_Longest_Repeating_Character_Replacement obj = new LC_424_Longest_Repeating_Character_Replacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(obj.characterReplacement(s,k));
    }
}
