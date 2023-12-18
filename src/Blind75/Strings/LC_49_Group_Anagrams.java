package Blind75.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String,List<String>> map = new HashMap<>();
        ArrayList<List<String>> res = new ArrayList();
        for(String i: arr){
            char[] ele = i.toCharArray();
            Arrays.sort(ele);
            String sorted = String.valueOf(ele);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(i);
        }
        res.addAll(map.values());
        return res;
    }
    public static void main(String[] args) {
        LC_49_Group_Anagrams obj = new LC_49_Group_Anagrams();
       String[]  arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(obj.groupAnagrams(arr));
    }
}
