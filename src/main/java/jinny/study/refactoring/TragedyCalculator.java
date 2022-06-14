package jinny.study.refactoring;

import jinny.study.refactoring.domain.InvoicePerformance;
import jinny.study.refactoring.domain.PlayForm;

public class TragedyCalculator extends PerformanceCalculator{
    public TragedyCalculator(InvoicePerformance performance, PlayForm play) {
        super.performance = performance;
        super.play = play;
    }

    @Override
    public long getAmount() {
        long resut = 40000;
        if (performance.audience > 30) {
            resut += 1000 * (performance.audience - 30);
        }
        return resut;
    }
}
