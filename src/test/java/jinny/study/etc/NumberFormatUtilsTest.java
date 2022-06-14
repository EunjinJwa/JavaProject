package jinny.study.etc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class NumberFormatUtilsTest {

    NumberFormatUtils numberFormatUtils = new NumberFormatUtils();

    @Test
    public void test() {
        float testNumber = 100000.546f;
        Assertions.assertThat(numberFormatUtils.currencyNumberFormat(testNumber, Locale.US)).isEqualTo("$100,000.55");
    }
}
