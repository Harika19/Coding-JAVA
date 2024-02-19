package LRU_Cache_LinkedHashMap;

public class TestLRUCacheWithLinkedHashMap {

    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40

    }
}