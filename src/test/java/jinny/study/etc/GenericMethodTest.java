package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenericMethodTest {

    @Test
    void methodTest() {
        GenericMethod<String> test = new GenericMethod<>("TEST");
        test.callAny(1L);
        test.callAny("any");
        Set<Long> union = GenericMethod.union(new HashSet<Long>());
        union.add(100L);

    }

}
