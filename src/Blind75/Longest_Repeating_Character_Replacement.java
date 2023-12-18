package Blind75;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {
    private int logic(String s, int k){
        int l=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxi =0;
        int freq=0;
        for(int r=0;r<s.length();r++){
            char s1 = s.charAt(r);
            map.put(s1, map.getOrDefault(s1,0)+1);
            freq = Math.max(freq, map.get(s1));
            while((r-l+1)-freq>k){
                char leftc = s.charAt(l);
                map.put(leftc, map.get(leftc)-1);
                l++;
            }
            maxi = Math.max(maxi, r-l+1);
        }

        return maxi;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        Longest_Repeating_Character_Replacement obj = new Longest_Repeating_Character_Replacement();
        System.out.println(obj.logic(s, k));

    }
}
