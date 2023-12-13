package jinny.study.etc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void streamGetTest() {
        List<String> stringList = Stream.of("AAA", "BBB", "ccc").collect(Collectors.toList());

        String item = stringList.stream().filter(s -> s.equals("ff")).findFirst().orElse(null);

        Assertions.assertThat(item).isNull();
    }

    @Test
    public void findAnyIsPresend() {
        List<String> stringList = Stream.of("AAA", "BBB", "ccc").collect(Collectors.toList());

        boolean presentTrue = stringList.stream()
                .filter(x -> x.equals("AAA"))
                .findAny()
                .isPresent();

        Assertions.assertThat(presentTrue).isTrue();

        boolean presentFalse = stringList.stream()
                .filter(x -> x.equals("FFF"))
                .findAny()
                .isPresent();

        Assertions.assertThat(presentFalse).isFalse();

    }

}
