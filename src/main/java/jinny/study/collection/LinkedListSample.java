package jinny.study.collection;

import javax.sound.sampled.Line;
import java.util.LinkedList;

public class LinkedListSample {

    public static void main (String[] args) {
        test();
    }

    public static void test() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Mango");
        list.add("Kiwi");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

}
