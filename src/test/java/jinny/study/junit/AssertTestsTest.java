package jinny.study.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertTestsTest {

    @Test
    @DisplayName("예외가 발생하는지 검증한다")
    void testExpectedException() {
        List<String> tests = Arrays.asList("TEST");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> tests.get(1));
    }
}
