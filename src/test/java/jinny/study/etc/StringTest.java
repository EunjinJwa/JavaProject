package jinny.study.etc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class StringTest {

    @Test
    public void asciiCodeTest() {

        assert_asciiCodeTest("abdeekr", false);
        assert_asciiCodeTest("sdfklj3455d", true);
        assert_asciiCodeTest("sdfklj3455c", false);
        assert_asciiCodeTest("sdfklj345sd6455P", true);
    }

    private void assert_asciiCodeTest(String value, boolean expectedValue) {
        byte[] bytes = value.getBytes(StandardCharsets.US_ASCII);
        int byteNum = bytes[bytes.length-1];
        Assertions.assertThat(byteNum % 5 == 0).isEqualTo(expectedValue);
    }

}
