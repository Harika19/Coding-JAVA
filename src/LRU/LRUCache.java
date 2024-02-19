package LRU;

import java.util.HashMap;

// LRU Cache implementation using a Doubly Linked List and a HashMap
// This class adheres to the SRP by focusing solely on cache management
public class LRUCache<K, V> implements Cache<K, V> {
    private final int capacity;
    private final HashMap<K, ListNode<K, V>> map;
    private ListNode<K, V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode<>(null, null); // Dummy head
        this.tail = new ListNode<>(null, null); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Adheres to the Open/Closed Principle (OCP) by allowing extension of getting and putting methods
    // without modifying the existing code structure.
    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            ListNode<K, V> node = map.get(key);
            removeNode(node);
            node.value = value; // Update the value
            addNode(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key); // Remove LRU from map
                removeNode(tail.prev); // Remove LRU from list
            }
            ListNode<K, V> newNode = new ListNode<>(key, value);
            map.put(key, newNode);
            addNode(newNode);
        }
    }

    @Override
    public V get(K key) {
        if (map.containsKey(key)) {
            ListNode<K, V> node = map.get(key);
            removeNode(node);
            addNode(node); // Move to head as most recently used
            return node.value;
        }
        return null; // Follows Liskov Substitution Principle (LSP) by returning null for a missing key, adhering to the Cache interface's contract
    }

    // Utility method to add a node right after head
    private void addNode(ListNode<K, V> node) {
        ListNode<K, V> headNext = head.next;
        node.next = headNext;
        node.prev = head;
        head.next = node;
        headNext.prev = node;
    }

    // Utility method to remove a node from the list
    private void removeNode(ListNode<K, V> node) {
        ListNode<K, V> nextNode = node.next;
        ListNode<K, V> prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

// Usage example
