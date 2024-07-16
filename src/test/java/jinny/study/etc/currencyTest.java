package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.util.Currency;

public class currencyTest {

    @Test
    public void currencyTest() {
        System.out.println(Currency.getAvailableCurrencies());
        String krwSymbol = Currency.getInstance("KRW").getSymbol();
        System.out.println(krwSymbol);
    }
}
