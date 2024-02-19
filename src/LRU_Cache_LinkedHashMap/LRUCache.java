package LRU_Cache_LinkedHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

 public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity)
    {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };
    }

    // This method works in O(1)
    public int get(int key)
    {
        System.out.println("get for key  " + key );
        return map.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public void set(int key, int value)
    {
        System.out.println("set " + key + "-> " + value);
        map.put(key, value);
    }
}