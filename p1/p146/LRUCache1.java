package leetcode.p1.p146;

import java.util.*;


/**
 * Too slow
 * Time Limit Exceeded
 */
class LRUCache1 {
    HashMap<Integer, Integer> storage;
    Queue<Integer> queue;
    int capacity;

    public LRUCache1(int capacity) {
        storage = new HashMap<>();
        queue = new ArrayDeque<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (storage.get(key) == null) {
            return -1;
        } else {
            queue.remove(key);
            queue.add(key);
            return storage.get(key);
        }
    }

    public void put(int key, int value) {
        queue.remove(key);
        queue.add(key);
        storage.put(key, value);
        if (queue.size() > capacity) {
            storage.remove(queue.poll());
        }
    }

    public static void main(String[] args) {
        LRUCache1 cache;
        cache = new LRUCache1(2);
        System.out.println(cache.get(2) == -1);
        cache.put(2, 6);
        System.out.println(cache.get(1) == -1);
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1) == 2);
        System.out.println(cache.get(2) == 6);

        cache = new LRUCache1(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1) == -1);
        System.out.println(cache.get(2) == 3);
    }
}
