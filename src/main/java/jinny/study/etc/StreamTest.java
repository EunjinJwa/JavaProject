package jinny.study.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main (String[] args) {
        streamFindTest();
    }

    private static void streamFindTest () {
        List<DataObject> list = Arrays.asList(
                new DataObject("a", "1"),
                new DataObject("c", "1"),
                new DataObject("d", null),
                new DataObject("e", "1")
        );

        String var1 = "d";
        String var2 = "2";

        boolean check = list.stream().filter(c -> CheckData(c, var1, var2)).findFirst().orElse(null) != null;
        System.out.println(check);

    }

    public static boolean CheckData(DataObject data, String var1, String var2) {
        return data.param1.equals(var1) && data.param2 != null ? data.param2.equals(var2) : var2 == null;
    }

    static class DataObject {
        String param1;
        String param2;

        public DataObject (String param1, String param2) {
            this.param1 = param1;
            this.param2 = param2;
        }
    }

}
