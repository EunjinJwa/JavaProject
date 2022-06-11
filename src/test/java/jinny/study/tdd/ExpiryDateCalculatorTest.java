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

    @Test
    public void 첫납부일_만료일납부일_다를때_만원납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,31))
                .billingDate(LocalDate.of(2019, 02, 28))
                .payAmount(10000)
                .build();

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,30))
                .billingDate(LocalDate.of(2019, 02, 28))
                .payAmount(10000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2019,03,30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,5,31))
                .billingDate(LocalDate.of(2019, 06, 30))
                .payAmount(10000)
                .build();
        assertExpiryDate(payData3, LocalDate.of(2019,07,31));
    }

    @Test
    public void 이만원이상납부_비례하여_만료일_계산() {
        PayData payData1 = PayData.builder()
                .billingDate(LocalDate.of(2019, 03, 1))
                .payAmount(20000)
                .build();
        assertExpiryDate(payData1, LocalDate.of(2019,05,1));

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2019, 03, 1))
                .payAmount(30000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2019,06,1));

        PayData payData3 = PayData.builder()
                .billingDate(LocalDate.of(2019, 03, 1))
                .payAmount(50000)
                .build();
        assertExpiryDate(payData3, LocalDate.of(2019,8,1));
    }

    @Test
    public void 첫납부일과_만료일일자가_다를때_2만원이상납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 01, 31))
                .billingDate(LocalDate.of(2019, 02, 28))
                .payAmount(20000)
                .build();
        assertExpiryDate(payData, LocalDate.of(2019,4,30));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 03, 31))
                .billingDate(LocalDate.of(2019, 04, 30))
                .payAmount(30000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2019,7,31));
    }

    @Test
    public void 십만원납부시_1년제공() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(null)
                        .billingDate(LocalDate.of(2019,01,28))
                        .payAmount(100_000)
                        .build()
                , LocalDate.of(2020,01,28)
        );

    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();

        Assertions.assertEquals(cal.calculateExpiryDate(payData), expectedExpiryDate);

    }

}
