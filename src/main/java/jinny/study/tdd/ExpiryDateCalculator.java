package jinny.study.tdd;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addMonth = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10000;
        if (payData.getFirstBillingDate() != null) {
            return cexpiryDateUsingFirstBillingDate(payData, addMonth);
        } else {
            return payData.getBillingDate().plusMonths(addMonth);
        }
    }

    private LocalDate cexpiryDateUsingFirstBillingDate(PayData payData, int addMonth) {
        LocalDate candidatedExp = payData.getBillingDate().plusMonths(addMonth);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if (isSameDayOfMonth(candidatedExp, payData.getFirstBillingDate())) {
            final int dayLenOfCandidate = lastDayOfMonth(candidatedExp);
            if (dayLenOfCandidate < payData.getFirstBillingDate().getDayOfMonth()) {
                return candidatedExp.withDayOfMonth(dayLenOfCandidate);
            }
            return candidatedExp.withDayOfMonth(dayOfFirstBilling);
        }
        return null;
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() != date2.getDayOfMonth();
    }

    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}
