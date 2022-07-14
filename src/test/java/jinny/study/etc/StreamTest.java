package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamGetTest() {
        List<String> stringList = Stream.of("AAA", "BBB", "ccc").collect(Collectors.toList());

        String item = stringList.stream().filter(s -> s.equals("ff")).findFirst().orElse(null);

        if (item != null) {
            System.out.println(item);
        }
        System.out.println(item);

    }


}
