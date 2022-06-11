package jinny.study.refactoring;

import jinny.study.refactoring.domain.InvoicePerformance;
import jinny.study.refactoring.domain.PlayForm;

public class PerformanceCalculator {
    InvoicePerformance performance;
    PlayForm play;

    public PerformanceCalculator(InvoicePerformance performance, PlayForm play) {
        this.performance = performance;
        this.play = play;
    }

    public long getAmount() {
        throw new RuntimeException("서브클래스에서 처리하도록 설계되었습니다.");
    }

    public long getVolumeCredits() {
        long result = 0;
        result += Math.max(performance.audience - 30, 0);
        return result;
    }




}
