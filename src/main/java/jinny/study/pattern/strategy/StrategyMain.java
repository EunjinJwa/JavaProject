package jinny.study.pattern.strategy;

import java.util.Arrays;

public class StrategyMain {

    public static void main(String[] args) {
        int[] array = {9, 20, 6, 2, 0, 3, 1, 5};

        BubbleSorter sorter = new BubbleSorter(new IntSortHandle());
        System.out.println(sorter.sort(array));
        System.out.println(Arrays.toString(array));
    }

}
