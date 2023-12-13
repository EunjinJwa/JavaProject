package jinny.study.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNodeTest {

    private Map<String, Node> cacheMap;
    private int capacity;
    private Node head;      // 최근 데이터
    private Node tail;      // 마지막 데이터

    public LRUCacheNodeTest (int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new Node("","");
        tail = new Node("","");
        head.next = tail;
        head.pre = head;
    }


}
