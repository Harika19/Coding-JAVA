package Blind75.Arrays;

import java.util.*;

public class LC_49_grp_anagrams {

    private ArrayList<List<String>> grp_anagram(String[] arr){
        HashMap<String,List<String>> map = new HashMap<>();

        for(String i: arr){
            char[] str = i.toCharArray();
            Arrays.sort(str);
            String sorted = String.valueOf(str); /// or  String str = new String(sorted);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(i);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        LC_49_grp_anagrams obj = new LC_49_grp_anagrams();
        System.out.println(obj.grp_anagram(arr));
    }
}
