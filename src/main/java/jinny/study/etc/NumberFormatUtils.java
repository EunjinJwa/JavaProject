package jinny.study.etc;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatUtils {


    public static String currencyNumberFormat(float number, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(number);
    }

}
