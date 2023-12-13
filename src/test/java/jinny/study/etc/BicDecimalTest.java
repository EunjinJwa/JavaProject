package jinny.study.etc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BicDecimalTest {

    @Test
    public void compareTest() {
        BigDecimal num1 = new BigDecimal(0);
        BigDecimal num2 = new BigDecimal(10);
        BigDecimal targetNum = new BigDecimal(2);

        Assertions.assertThat(targetNum.compareTo(num1)).isEqualTo(1);
        Assertions.assertThat(targetNum.compareTo(num2)).isEqualTo(-1);
        Assertions.assertThat(new BigDecimal(10).compareTo(num2)).isZero();
    }

    @Test
    public void scaleTest() {
        BigDecimal num1 = new BigDecimal(699.5);
        BigDecimal num2 = num1.setScale(0, RoundingMode.HALF_UP);

        System.out.println(num2);

        Assertions.assertThat(num2).isEqualTo(new BigDecimal(700));
    }



}
