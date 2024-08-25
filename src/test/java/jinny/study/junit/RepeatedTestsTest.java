package jinny.study.junit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("반복테스트")
public class RepeatedTestsTest {

    private static Set<Integer> integerSet = new HashSet<>();
    private static List<Integer> integerList = new ArrayList<>();

    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}" )
    @DisplayName("Test add operation")
    void addNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @RepeatedTest(value = 5, name = "the list contains {currentRepetition} elements, the set contains 1 element")
    void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {
        int staticNumber = 1;
        int currentRepetitionCount = repetitionInfo.getCurrentRepetition();
        integerSet.add(staticNumber);
        integerList.add(currentRepetitionCount);

        testReporter.publishEntry("Repetition number", String.valueOf(currentRepetitionCount));

        assertEquals(1, integerSet.size());
        assertEquals(currentRepetitionCount, integerList.size());
    }

}
