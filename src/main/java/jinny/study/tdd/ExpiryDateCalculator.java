package jinny.study.tdd;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addMonth = payData.getPayAmount() / 10000;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidatedExp = payData.getBillingDate().plusMonths(addMonth);
            if (candidatedExp.getDayOfMonth() != payData.getFirstBillingDate().getDayOfMonth()) {
                return candidatedExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addMonth);
    }
}
