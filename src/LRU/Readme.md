for more info - https://www.baeldung.com/java-lru-cache
DS - JAVA - https://github.com/eugenp/tutorials/tree/master/data-structures

To make this container thread-safe, we need to synchronize all public methods.

Let’s add :

ReentrantReadWriteLock
ConcurrentHashMap

/*
public class LRUCache<K, V> implements Cache<K, V> {
private int size;
private final Map<K, LinkedListNode<CacheElement<K,V>>> linkedListNodeMap;
private final DoublyLinkedList<CacheElement<K,V>> doublyLinkedList;
private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int size) {
        this.size = size;
        this.linkedListNodeMap = new ConcurrentHashMap<>(size);
        this.doublyLinkedList = new DoublyLinkedList<>();
    }
// ...
}
*/

We prefer to use a reentrant read/write lock rather than declaring methods as synchronized
because it gives us more flexibility in deciding when to use a lock on reading and writing.

When we use **writeLock** on the resource, only the thread holding the lock can write to or read from the resource. 
So, all other threads that are either trying to read or write on the resource will have to wait until the current lock holder releases it.

This is very important to prevent a deadlock. If any of the operations inside the try block fails,
we still release the lock before exiting the function with a finally block at the end of the method.


writeLock - put method start
readLock - get method start

// put - writeLock

public boolean put(K key, V value) {
this.lock.writeLock().lock();
try {
//..
} finally {
this.lock.writeLock().unlock();
}
}