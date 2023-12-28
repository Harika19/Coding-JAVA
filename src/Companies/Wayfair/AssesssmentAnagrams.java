package Companies.Wayfair;

import java.util.*;

public class AssesssmentAnagrams {

    public static List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        // Map to hold sorted word as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        // Fill the map with sorted words and their anagrams
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
            System.out.println(map);
        }

        // Prepare the result list
        List<List<String>> result = new ArrayList<>();

        // For each query find the anagrams
        for (String query : queries) {
            char[] chars = query.toCharArray();
            Arrays.sort(chars);
            String sortedQuery = new String(chars);
            List<String> anagrams = map.getOrDefault(sortedQuery, new ArrayList<>());
            System.out.println("anaaa   "+ anagrams);
            Collections.sort(anagrams);
            result.add(anagrams);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("duel", "speed", "dule", "cars");
        List<String> queries = Arrays.asList("spede", "deul");
        System.out.println(getSearchResults(words, queries));
    }
}
