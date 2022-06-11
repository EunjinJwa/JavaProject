package jinny.study.refactoring.domain;

import lombok.Getter;

@Getter
public class InvoicePerformance {
    public String playID;
    public int audience;

    public InvoicePerformance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}
