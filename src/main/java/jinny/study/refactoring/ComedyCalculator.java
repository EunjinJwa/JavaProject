package jinny.study.refactoring;

import jinny.study.refactoring.domain.InvoicePerformance;
import jinny.study.refactoring.domain.PlayForm;
import jinny.study.refactoring.domain.PlayType;

public class ComedyCalculator extends PerformanceCalculator{
    public ComedyCalculator(InvoicePerformance performance, PlayForm play) {
        super(performance, play);
    }

    @Override
    public long getAmount() {
        long resut = 30000;
        if (performance.audience > 20) {
            resut += 10000 + 500 * (performance.audience -20);
        }
        resut += 300 * performance.audience;
        return resut;
    }

    @Override
    public long getVolumeCredits() {
        return (long) (super.getVolumeCredits() + Math.floor(performance.audience / 5));
    }
}
