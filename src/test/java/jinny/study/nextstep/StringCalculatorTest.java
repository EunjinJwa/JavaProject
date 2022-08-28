package jinny.study.nextstep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 2.3. 문자열 계산기 작성하기
 * 요구사항
 *  - 쉼표(,), 콜론(:)을 구분자로 가지는 문자열(숫자로 된 문자열)을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
 *  - 커스텀 구분자는 "//" 와 "\n" 사이에 위치한다. ex) "//;\,1;2;3"
 *  - 음수가 전달된 경우 RuntimeException을 반환한다.
 */

public class StringCalculatorTest {

    StringCalculator c;

    @BeforeEach
    public void setup() {
        c = new StringCalculator();
    }

    @Test
    @DisplayName("빈문자일경우 0을 반환한다")
    public void convertNummToZero() {
        Assertions.assertThat(c.sum("")).isEqualTo(0);
        Assertions.assertThat(c.sum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("custom 구분자의 텍스트를 문자열배열로 반환")
    public void customSplit() {
        String a = "//;\n3;5;10";
        int result = c.sum(a);

        Assertions.assertThat(result).isEqualTo(18);
    }


    @Test
    @DisplayName("콜론과 콤마 문자열의 합계 계산")
    public void convertStringToIntArrTest() {
        String a = "2:4:5";
        int result = c.sum(a);
        Assertions.assertThat(result).isEqualTo(11);

        String b = "2,4,5";
        int result2 = c.sum(b);
        Assertions.assertThat(result2).isEqualTo(11);
    }

    @Test
    @DisplayName("0보다 작은 수가 있을 경우 Exception 발생")
    public void lessThan0_RuntimeException() {
        String a = "2:4:-3:5";
        Assertions.assertThatThrownBy(() -> c.sum(a)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정의된 구분자로 구성된 문자열의 합 구하기")
    public void commSplitTypeSum() {
        String a = "2:4:5";
        int result = c.sum(a);
        Assertions.assertThat(result).isEqualTo(11);
    }


}
