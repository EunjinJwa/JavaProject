package jinny.study.junit;

import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestsTest {

    /*
     *@ValueSource : 문자열 배열을 입력 값으로 지정
     * @EnumSource : 파라미터에 열거형(enum)을 사용
     * @CsvSource : CSV 형식으로 파라미터 제공
     * @CsvFileSource : CSV 파일을 파라미터의 소스로 사용 가능
     */

    @ParameterizedTest
    @ValueSource(strings = {"TEST_param1", "TEST_param2", "TEST_param3"})
    void stringStartWithTEST(String sentence) {
        assertTrue(sentence.startsWith("TEST"));
    }

    @ParameterizedTest
    @EnumSource(TestSentence.class)
    void enumStartWithTest(TestSentence enumValue, TestReporter testReporter) {
        testReporter.publishEntry("value", enumValue.toString());

        assertTrue(enumValue.toString().startsWith("TEST"));
    }

    @ParameterizedTest
    @EnumSource(value = TestSentence.class, names = {"TEST_param1", "TEST_param2"})
    void selectedEnumStartWithTest(TestSentence enumValue, TestReporter testReporter) {
        testReporter.publishEntry("value", enumValue.toString());

        assertTrue(enumValue.toString().startsWith("TEST"));
    }


    enum TestSentence {
        TEST_param1,
        TEST_param2,
        TEST_param3
    }
}

