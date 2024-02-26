package Companies.Nvidia;

import java.util.*;

public class URLShortner {
    public static List<List<String>> getStatForRequests(int m, List<String> database, List<String> requests) {
        class Pair {
            final int userId;
            final String actualUrl;

            Pair(int userId, String actualUrl) {
                this.userId = userId;
                this.actualUrl = actualUrl;
            }
        }

        Map<Integer, Integer> userCountMap = new HashMap<>();
        Map<String, Pair> databaseMap = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        for (String entry : database) {
            String[] parts = entry.split(" ");
            String userId = parts[0];
            String shortUrl = parts[1];
            String actualUrl = parts[2];

            databaseMap.put(shortUrl, new Pair(Integer.parseInt(userId), actualUrl));
        }

        for (String request : requests) {
            Pair pair = databaseMap.get(request);
            userCountMap.put(pair.userId, userCountMap.getOrDefault(pair.userId, 0) + 1);
            int count = userCountMap.get(pair.userId);

            result.add(List.of(new String[]{
                    pair.actualUrl,
                    String.valueOf(count)
            }));
        }

        return result;
    }

    public static void main(String[] args) {
        int m = 3;
        String[] database = {
                "0 sdsf www.google.com",
                "1 juytf www.google.com",
                "0 opoit www.kaggle.com"
        };
        String[] requests = {"juytf", "sdsf", "opoit"};
        System.out.println(getStatForRequests(m, List.of(database), List.of(requests)));

        List<String> database1 = List.of(
                "0 tezox www.google.com",
                "0 rrakl www.facebook.com",
                "0 crona www.hackerrank.com",
                "0 hckrk www.hackerrank.com"
        );
        List<String> requests1 = List.of("rrakl", "crona");
        System.out.println(getStatForRequests(1, database1, requests1));

    }
}
