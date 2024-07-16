package jinny.study.collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {

    @Test
    public void emptyCollection() {
        List<String> results = Collections.emptyList();

        Assertions.assertThat(results).isNotNull();
        Assertions.assertThat(results.isEmpty()).isTrue();
        Assertions.assertThat(results.size()).isEqualTo(0);
    }

    @Test
    public void emptyArrayList() {
        List<String> results = new ArrayList<>();

        Assertions.assertThat(results).isNotNull();
        Assertions.assertThat(results.isEmpty()).isTrue();
        Assertions.assertThat(results.size()).isEqualTo(0);
    }
}
