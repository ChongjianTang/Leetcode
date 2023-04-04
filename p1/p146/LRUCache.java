package leetcode.p1.p146;

import java.util.HashMap;

/**
 * HashMap + Double Linked List
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else {
            Node node = map.get(key);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            node.prev.next = node;

            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            node.prev.next = node;

            node.value = value;
        } else {
            if (capacity == 0) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            } else {
                capacity--;
            }
            Node node = new Node(key, value);

            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            node.prev.next = node;
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache;
        cache = new LRUCache(2);
        System.out.println(cache.get(2) == -1);
        cache.put(2, 6);
        System.out.println(cache.get(1) == -1);
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1) == 2);
        System.out.println(cache.get(2) == 6);
        System.out.println();

        cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1) == 1);
        cache.put(3, 3);
        System.out.println(cache.get(2) == -1);
        cache.put(4, 4);
        System.out.println(cache.get(1) == -1);
        System.out.println(cache.get(3) == 3);
        System.out.println(cache.get(4) == 4);
        System.out.println();

        cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4) == 4);
        System.out.println(cache.get(3) == 3);
        System.out.println(cache.get(2) == 2);
        System.out.println(cache.get(1) == -1);
        cache.put(5, 5);
        System.out.println(cache.get(1) == -1);
        System.out.println(cache.get(2) == 2);
        System.out.println(cache.get(3) == 3);
        System.out.println(cache.get(4) == -1);
        System.out.println(cache.get(5) == 5);
    }
}
