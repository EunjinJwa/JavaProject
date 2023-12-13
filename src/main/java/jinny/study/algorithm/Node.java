package jinny.study.algorithm;

public class Node {

    private String key;
    private String val;
    public Node pre;
    public Node next;

    public Node (String key, String val) {
        this.key = key;
        this.val = val;
    }
}
