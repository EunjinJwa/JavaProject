package jinny.study.pattern.strategy;

public class BubbleSorter {
    private int operation = 0;
    private int length = 0;
    private SortHandle itsSortHandle = null;

    public BubbleSorter(SortHandle itsSortHandle) {
        this.itsSortHandle = itsSortHandle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        operation = 0;
        if (length < 1) {
            return operation;
        }

        for (int nextToLast = length-2; nextToLast >= 0; nextToLast--) {
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index);
                }
                operation++;
            }
        }
        return operation;
    }
}
