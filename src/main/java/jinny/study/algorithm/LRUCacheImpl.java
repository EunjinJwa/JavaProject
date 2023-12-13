package jinny.study.algorithm;

import java.util.LinkedList;

public class LRUCacheImpl {

    private LinkedList<Integer> cache;
    private int capacity;

    public LRUCacheImpl (int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedList<>();
    }

    public int get (int key) {
        if (cache.contains(key)) {
            cache.removeFirstOccurrence(key);
            cache.addFirst(key);
            return key;
        } else {
            return -1;
        }
    }

    public void put (int key) {
        if (cache.contains(key)) {
            cache.removeFirstOccurrence(key);
            cache.addFirst(key);
        } else {
            if (cache.size() == capacity) {
                int last = cache.removeLast();
                System.out.println("Remove " + last + " from cache");
            }
            cache.addFirst(key);
        }
        System.out.println(cache);
    }


    public static void main (String[] args) {
        LRUCacheImpl lruCache = new LRUCacheImpl(3);
        lruCache.put(10);
        System.out.println("===============================");
        lruCache.put(20);
        System.out.println("===============================");
        lruCache.put(30);
        System.out.println("===============================");
        lruCache.put(20);
        System.out.println("===============================");
        lruCache.put(40);

    }
}
