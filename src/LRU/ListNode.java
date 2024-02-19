package LRU;

// Represents a Node in the Doubly Linked List
public class ListNode<K, V> {
    K key;
    V value;
    ListNode<K, V> prev;
    ListNode<K, V> next;

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
