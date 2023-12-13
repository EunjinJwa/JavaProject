package jinny.study.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    @Test
    public void listTest() {
        List<String> list = new ArrayList(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
        printArray(list);

        int size = list.size();

        for (int i = 0; i < size; i++) {
            String remove = list.remove(0);
            System.out.println("remove " + remove);
            printArray(list);
        }

    }

    private void printArray (List<String> array) {
        System.out.print(array.size() + " >> ");
        for (String data : array) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

}
