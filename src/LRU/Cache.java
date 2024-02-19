package LRU;


// Interface for Cache operations following the Single Responsibility Principle (SRP)
// and Interface Segregation Principle (ISP)

// <k,v> - CONCEPT OF GENERIC
public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
}
