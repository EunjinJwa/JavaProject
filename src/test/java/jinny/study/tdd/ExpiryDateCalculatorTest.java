package jinny.study.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ExpiryDateCalculatorTest {
    /**
     * 테스트 조건
     * - 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한 달 뒤가 서비스 만료일이다.
     * - 2개월 이상 요금을 납부할 수 있다.
     * - 10만원을 납부하면 서비스를 1년 제공한다.
     */

    @Test
    void 만원납부_만료일은한달뒤() {
        // case1
        PayData payData1 = PayData.builder()
                .billingDate(LocalDate.of(2022, 06, 8))
                .payAmount(10000)
                .build();
        assertExpiryDate(payData1, LocalDate.of(2022,07,8));

        // case2
        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2022, 02, 28))
                .payAmount(10000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2022,03,28));

        // case3
        PayData payData3 = PayData.builder()
                .billingDate(LocalDate.of(2020, 01, 31))
                .payAmount(10000)
                .build();
        assertExpiryDate(payData3, LocalDate.of(2020,02,29));
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();

        Assertions.assertEquals(cal.calculateExpiryDate(payData), expectedExpiryDate);


    }

}
